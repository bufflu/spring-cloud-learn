package com.frog.test;

import java.util.Date;

/**
 * ClassName:
 * Description:
 * Date: 2018/8/29 14:52
 *
 * @author guoxinlu
 */
public class TestDate {

    private void change(Date date) {

        date = null;
        //date.setTime(11111111);
    }

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        TestDate testDate = new TestDate();
        testDate.change(now);
        System.out.println(now);
    }
}
