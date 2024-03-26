package com.ghulam.employee.utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());

    public static Long next() {
        long timestamp = System.currentTimeMillis();
        long id = counter.getAndIncrement();
        return (timestamp << 20) | (id & 0xFFFFF);
    }
}
