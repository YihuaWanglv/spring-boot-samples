package com.qkc.bus.phoenix.util;

/**
 * 雪花算法生成全局有序唯一ID，长度19位，有long和String两种类型可选
 */
public class SequenceGenerator {

    private static SnowFlake snowFlake = new SnowFlake(1, 2);

    public static long nextId() {

        return snowFlake.nextId();
    }

    public static String nextStringId() {

        return "" + snowFlake.nextId();
    }
}
