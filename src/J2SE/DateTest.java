package J2SE;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateTest {
    public static void main(String[] args) {


        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date d=new Date();
        String str=sf.format(d);
        System.out.println(str);

        //日历对象使用
        Calendar c=Calendar.getInstance();
        Date d1=c.getTime();
        System.out.println(d1);

        Date d2=new Date(0);
        c.setTime(d2);
    }
}
