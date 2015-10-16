/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package codox.net.demo.java.j2se.tutorials.datetime;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * 类EnumClassDemo.java的实现描述：TODO 类实现描述 
 * @author moxnet 2015年10月7日 上午12:29:26
 */
public class EnumClassDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.US;

        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));

        Month mon = Month.AUGUST;
        //Locale locale = Locale.getDefault();

        System.out.println(mon.getDisplayName(TextStyle.FULL, locale));
        System.out.println(mon.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(mon.getDisplayName(TextStyle.SHORT, locale));

    }

}
