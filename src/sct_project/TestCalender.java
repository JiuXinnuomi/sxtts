package sct_project;

/**
 * 可视化日历程序
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalender {

    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期：(格式：2021-2-10)" );
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        TestCalender2(str);

    }

    public static void TestCalender2(String rq) throws ParseException {

        //字符串生成时间对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(rq);

        //时间对象生成日期对象
        Calendar c =new GregorianCalendar();
        c.setTime(date);

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        int today = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH,1);

        //使日期与星期对应☆☆☆
        for (int i = 0; i<c.get(Calendar.DAY_OF_WEEK)-1; i++ ){
            System.out.print("\t");
        }

        //循环最后一次追加日期，会将月份天数追加到下个月
        int Maxc = c.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= Maxc; i++){

            if (today == c.get(Calendar.DAY_OF_MONTH)){
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
            }else {
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            }
            if (c.get(Calendar.DAY_OF_WEEK) == 7){
                System.out.println(); //换行
            }

            c.add(Calendar.DAY_OF_MONTH,1);

        }
    }
}
