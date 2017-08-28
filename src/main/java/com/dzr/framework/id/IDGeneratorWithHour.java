package com.dzr.framework.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 返回的ID的时间戳信息支持到小时级别
 */
public class IDGeneratorWithHour extends IDGeneratorWithTimestamp {
    private Logger log = LoggerFactory.getLogger(IDGeneratorWithHour.class);

    public IDGeneratorWithHour() {
        super("", IDDatePattern.PATTERN_HOURS, 9);
    }

    public IDGeneratorWithHour(String prefix) {
        super(prefix, IDDatePattern.PATTERN_HOURS, 9);
    }

    public IDGeneratorWithHour(String prefix, int bits) {
        super(prefix, IDDatePattern.PATTERN_HOURS, bits);
    }

}
