import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest{

    public static void main(String[] args) {
//        new Person("小张").start();
//        new Person("小李").start();
//        new Person("小周").start();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);


        //定义一个时间变量
        String date1 = "2022-1-12 17:31:20";

        Person person = new Person();
        if (date1.equals(format)){
            person.start();
        }


//        Person person1 = new Person();
//        person1.start();


    }

}

//继承方法
class Person extends Thread{
    private int i = 1;  //10个苹果


    public Person(){
    }

    public Person(String userName){
        super(userName);
    }

    @Override
    public void run() {
        for (int j = 0; j < 1; j++) {
            if (i > 0){
                System.out.println(super.getName()+"吃了编号号为" + i-- + "的苹果");
            }
        }
    }
}

