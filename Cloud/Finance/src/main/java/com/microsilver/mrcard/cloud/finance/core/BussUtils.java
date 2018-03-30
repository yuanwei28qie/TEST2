package com.microsilver.mrcard.cloud.finance.core;

import java.util.Random;

/**
 * @Name com.microsilver.mrcard.cloud.finance.core.BussUtils
 * @Description
 * @Author Jade
 * @Version 2017/8/29
 * @Copyright Micro Silver
 */
public class BussUtils {

    public static String createBatchNo() {
        StringBuilder sb = new StringBuilder("BN");
        Random random = new Random();
        long rd = random.nextLong();
        if(rd < 0)
            sb.append(-rd);
        else
            sb.append(rd);
        int len = sb.length();
        return sb.substring(0,len >10?10:len);
    }

}
