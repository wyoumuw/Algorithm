package com.youmu.maven.Algorithm;

import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class A
{
    Object t;

    public A(Object t) {
        this.t = t;
    }

    public void close() throws Exception{
        ((Closeable)t).close();
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取从开始日期到今天前的日子
        List<Date> dates = getBetweenDates(df.parse("2017-07-01"), new Date());
        dates.stream().map((date)->df1.format(date)).forEach(System.out::println);

    }

    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.DAY_OF_MONTH, -1);
        while (tempEnd.after(tempStart)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_MONTH, 1);
        }
        return result;
    }

static class B{

        static int i;
}
}
