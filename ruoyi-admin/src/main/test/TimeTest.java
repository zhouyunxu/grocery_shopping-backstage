import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    public static long midTime;   //相差时间秒数

    public static void main(String[] args) {
        //创建一个日历
        Calendar instance = Calendar.getInstance();
        //设置日历时间
        instance.set(2022, 4, 29, 17, 30, 0);  // 注意月份的设置，0-11表示1-12月
        //获取日历时间 秒数
        long endTime = instance.getTimeInMillis();
        //创建当前时间
        Date date = new Date();
        //获取当前时间的秒数
        long startTime = date.getTime();
        midTime = (endTime - startTime) / 1000;

        time2(); //执行方法
    }

    /**
     * 设定时间戳，倒计时
     */
    private static void time2() {
        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            System.out.println("还有" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
