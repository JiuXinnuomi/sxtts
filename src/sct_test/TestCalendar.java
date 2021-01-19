package sct_test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日历类的使用
 */
public class TestCalendar {

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);
        int year = calendar.get(Calendar.YEAR);  //获取某项数值
        int month = calendar.get(Calendar.MONTH);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK); // 1-7的数值为 1：星期日，7：星期六
        int day = calendar.get(Calendar.DATE);   //也可以使用：DAY_OF_MONTH

        System.out.println( "year: " + year + "month: " + month + "weekday: " + weekday + "day: " + day);  //月份数值为0-11

        //设置日期的相关元素
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.YEAR,8012);

        System.out.println(c2);

        //日期的计算
        Calendar c3 = new GregorianCalendar();
        c2.add(Calendar.DATE,-100);  //追加到100天以前

        System.out.println(c3);

        //日期对象和时间对象的转化
        Date d4 = c3.getTime();

        Calendar c4 = new GregorianCalendar();
        c4.setTime(new Date());

        printCalender(c4);

    }

    /*打印一个具体时间*/
    public static void printCalender(Calendar c){
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int dayweek = c.get(Calendar.DAY_OF_WEEK) - 1 ;
        String dayweek2 = dayweek == 0? "日" : dayweek+"";

        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒" + "周" + dayweek2);

    }
}
