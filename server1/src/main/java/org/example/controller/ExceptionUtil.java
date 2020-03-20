package org.example.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ExceptionUtil {

    public static void handleException(String str, BlockException ex) {
        log.warn("Oops: {} str:{}", ex.getClass().getCanonicalName(), str);
    }
}
