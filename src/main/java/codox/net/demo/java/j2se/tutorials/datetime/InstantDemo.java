/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package codox.net.demo.java.j2se.tutorials.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * 类InstantDemo.java的实现描述：TODO 类实现描述 
 * @author moxnet 2015年10月9日 下午2:49:45
 */
public class InstantDemo {

    public static void main(String[] args) {
        Instant ts1 = Instant.now();
        Instant ts2 = ts1.plusSeconds(3600);
        long interval = ts1.until(ts2, ChronoUnit.SECONDS);
        System.out.println(interval);
        
        LocalDateTime ldt = LocalDateTime.ofInstant(ts2, ZoneId.systemDefault());
        System.out.println(ldt);
    }
}
