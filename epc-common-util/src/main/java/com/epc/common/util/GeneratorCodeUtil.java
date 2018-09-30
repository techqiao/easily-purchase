package com.epc.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-29 09:55
 * <p>@Author : wjq
 */
public class GeneratorCodeUtil {
    public static String GeneratorProjectCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
}
