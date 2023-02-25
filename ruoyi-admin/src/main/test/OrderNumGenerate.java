import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class OrderNumGenerate {

    private static final String SERIAL_NUMBER = "0000"; // 流水号格式
    private static OrderNumGenerate orderNumGenerater = null;

    private OrderNumGenerate() {
    }
    /**
     * 取得PrimaryGenerate的单例实现
     * @return
     */
    public static OrderNumGenerate getInstance() {
        if (orderNumGenerater == null) {
            synchronized (OrderNumGenerate.class) {
                if (orderNumGenerater == null) {
                    orderNumGenerater = new OrderNumGenerate();
                }
            }
        }
        return orderNumGenerater;
    }
    /**
     * 生成下一个编号
     */
    public static synchronized String generateNextNumber(String num) {
        String id = null;
        String s = num.substring(0, 2); //截取订单号前缀
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        if (num == null) {
            id = s+formatter.format(date) + "0001";
        } else {
            int count = SERIAL_NUMBER.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            String dateString=num.substring(2, 10);
            if(formatter.format(date).compareTo(dateString)==0){
                DecimalFormat df = new DecimalFormat("000000");
                id =s+formatter.format(date)+ df.format(1 + Integer.parseInt(num.substring(10, 16)));
            }else{
                id = s+formatter.format(date) + "000001";
            }
        }
        return id;
    }
    public static void main(String[] args) {

        String str = "0002";
        Long sr = Long.valueOf(str);

        AtomicLong at = new AtomicLong();
        for (int i = 0; i < 1; i++) {
            Long atLong = at.incrementAndGet();
            System.out.println(String.format("%04d", atLong));

            if (atLong == sr){
                Long er = at.incrementAndGet();
                System.out.println(String.format("%04d", er));
            }
        }



    }




}
