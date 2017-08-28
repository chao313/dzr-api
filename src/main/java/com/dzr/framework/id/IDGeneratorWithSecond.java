package com.dzr.framework.id;


/**
 * 返回的ID的时间戳信息支持到秒级别
 * 本机测试结果：1.6G i5 CPU, 8G内存， 每秒生成35万个ID
 * 理论上满足集群中单节点的需求
 */
public class IDGeneratorWithSecond extends IDGeneratorWithTimestamp {
    public IDGeneratorWithSecond() {
        super("", IDDatePattern.PATTERN_SECONDS, 5);
    }

    public IDGeneratorWithSecond(String prefix) {
        super(prefix, IDDatePattern.PATTERN_SECONDS, 5);
    }

    public IDGeneratorWithSecond(String prefix, int bits) {
        super(prefix, IDDatePattern.PATTERN_SECONDS, bits);
    }

}
