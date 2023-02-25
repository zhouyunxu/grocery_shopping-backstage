

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Map;

public class JSON {
    public static void main(String[] args) {
        //创建测试object
        User user = new User("李宁",24,"北京");
        System.out.println(user);

        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
        System.out.println(json1);

        JSONObject json2 = new JSONObject(user);
        String s = json2.toString();
        System.out.println(s);

        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
         //方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        System.out.println(jsonObject);
        //方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);
        System.out.println(jsonObject2);
        Object b = jsonObject2.get("b");
        System.out.println(b);

        System.out.println("----------------------------------");
        //转换成数组
        String jsonStr2 = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array = JSONUtil.parseArray(jsonStr2);
        System.out.println(array);
        Object o = array.get(0);
        System.out.println(o);


        //工具类转换   false表示
        JSONObject json = JSONUtil.parseObj(user, false,true);
        //Console.log(json.toStringPretty());
        System.out.println(json);
        Object name = json.get("name");
        System.out.println(name);
    }



}
