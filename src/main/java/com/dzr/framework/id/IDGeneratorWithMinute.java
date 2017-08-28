package com.dzr.framework.id;


/**
 * 返回的ID的时间戳信息支持到秒级别
 * 本机测试结果：1.6G i5 CPU, 8G内存， 每秒生成35万个ID
 * 理论上满足集群中单节点的需求
 */
public class IDGeneratorWithMinute extends IDGeneratorWithTimestamp {
    public IDGeneratorWithMinute() {
        super("", IDDatePattern.PATTERN_MINUTES, 7);
    }

    public IDGeneratorWithMinute(String prefix) {
        super(prefix, IDDatePattern.PATTERN_MINUTES, 7);
    }

    public IDGeneratorWithMinute(String prefix, int bits) {
        super(prefix, IDDatePattern.PATTERN_MINUTES, bits);
    }

}
