import cn.hutool.log.Log;
import com.ruoyi.common.utils.poi.ExcelUtil;
import javafx.concurrent.Task;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


//接口方式实现线程
public class zhang implements Runnable {

    //定义一个时间
    String time = "2022-04-29 17:30:00";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //运行线程
    @Override
    public void run() {
        Date date = new Date();  //当前时间
        String format = sdf.format(date);
        if (time.equals(format)){
            System.out.println("执行完毕");
        }else {

        }

    }


}




//时间类
class time{
    private int hours;    //小时
    private int min;      //分钟
    private int second;   //秒

    public time(int hours, int min, int second) {
        this.hours = hours;
        this.min = min;
        this.second = second;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}