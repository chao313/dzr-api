package com.dzr.framework.id;



import com.dzr.common.util.PropertyPlaceholderConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 返回的ID的时间戳信息支持到毫秒级别
 */
public class IDGeneratorWithTimestamp implements IDGenerator {
    private Logger log = LoggerFactory.getLogger(IDGeneratorWithTimestamp.class);

    private long lastTimestamp = -1L;
    private long sequence = 0L;
    private long max = 10000;
    //    @Value("${server.id}")
    protected String serverId; //集群中的serverId，不能重复，否则ID会重复
    private String prefix = "";
    private IDDatePattern pattern;

    /**
     * @param prefix  ID的前缀，比如可以是业务类型：AP,OR
     * @param pattern ID中日期的格式
     * @param bits    日期后面还要根几位数字，冲突情况下，递增，默认是0
     */
    public IDGeneratorWithTimestamp(String prefix, IDDatePattern pattern, int bits) {
        this.prefix = prefix;
        this.max = (long) Math.pow(10, bits);
        this.pattern = pattern;
        serverId = System.getProperty("server.id");
        if(serverId==null) {
            Object obj = PropertyPlaceholderConfigurer.getContextProperty("server.id");
            serverId = obj == null ? "" : obj.toString();
        }
    }


    public String getId() {
        return prefix + (serverId == null ? "" : serverId) + nextId(pattern, max);
    }

    public String getId(String prefix) {
        return prefix + (serverId == null ? "" : serverId) + nextId(pattern, max);
    }

    /**
     * 规则：
     * prefix_serverid_时间_sequence
     */
    private synchronized long nextId(IDDatePattern pattern, long max) {
        Date now = new Date();
        long timestamp = getTimeStamp(now.getTime(), pattern);

        if (lastTimestamp == timestamp) {
            //当前毫秒内，则+1
            sequence = sequence + 1;
            if (sequence >= (max * 0.85)) {
                //TODO 发出告警

            }

            if (sequence == max) {
                if (pattern.equals(IDDatePattern.PATTERN_MILLIS) ||
                        pattern.equals(IDDatePattern.PATTERN_SECONDS)) {
                    log.warn("========单位时间内的ID数量满了，等待下一个时间窗口===========  max:{},seqwnce:{}", max, sequence);
                    now = new Date();
                    timestamp = getTimeStamp(now.getTime(), pattern);
                    while (timestamp <= lastTimestamp) {
                        //FIXME 循环耗CPU
                        now = new Date();
                        timestamp = getTimeStamp(now.getTime(), pattern);
                    }
                } else {
                    throw new RuntimeException("ID请求数已达上限:" + max);
                }
                sequence = 0;
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern.getCode());
        String date = simpleDateFormat.format(now);
        long id = Long.valueOf(date) * max + sequence;
        return id;
    }

    private long getTimeStamp(long timestamp, IDDatePattern datePattern) {
        switch (datePattern) {
            case PATTERN_MILLIS:
                break;
            case PATTERN_SECONDS:
                timestamp = timestamp / 1000L;
//                max=1000;
                break;
            case PATTERN_MINUTES:
                timestamp = timestamp / (1000L * 60);
//                max=1000*100;
                break;
            case PATTERN_HOURS:
                timestamp = timestamp / (1000L * 60 * 60);
//                max=1000*100*100;
                break;
            case PATTERN_DAY:
                timestamp = timestamp / (1000L * 60 * 60 * 24);
//                max=1000*100*100*100;
                break;
        }

        return timestamp;
    }

}
