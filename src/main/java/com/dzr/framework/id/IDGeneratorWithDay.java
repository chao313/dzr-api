package com.dzr.framework.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 返回的ID的时间戳信息支持到天级别
 */
public class IDGeneratorWithDay extends IDGeneratorWithTimestamp {
    private Logger log = LoggerFactory.getLogger(IDGeneratorWithDay.class);

    public IDGeneratorWithDay() {
        super("", IDDatePattern.PATTERN_DAY, 11);
    }

    public IDGeneratorWithDay(String prefix) {
        super(prefix, IDDatePattern.PATTERN_DAY, 11);
    }

    public IDGeneratorWithDay(String prefix, int bits) {
        super(prefix, IDDatePattern.PATTERN_DAY, bits);
    }

}
