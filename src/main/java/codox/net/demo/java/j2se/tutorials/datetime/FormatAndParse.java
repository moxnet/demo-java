/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package codox.net.demo.java.j2se.tutorials.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * 类FormatAndParse.java的实现描述：TODO 类实现描述
 * 
 * @author moxnet 2015年10月9日 下午3:10:16
 */
public class FormatAndParse {
    public static void main(String[] args) {
        String dateStr = "2015-10-20 23:15:22";

        DateTimeFormatter formatParse = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatForma = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a", Locale.US);
        try {
            LocalDateTime ldt = LocalDateTime.parse(dateStr, formatParse);
            System.out.println(ldt.format(formatForma));

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }
}
