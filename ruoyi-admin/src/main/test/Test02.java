import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.nuo.controller.ZhouUserController;
import com.ruoyi.nuo.domain.ZhouUser;
import com.ruoyi.nuo.mapper.ZhouUserMapper;
import com.ruoyi.nuo.service.IZhouUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Console;
import java.util.List;


public class Test02 {

    @Autowired
    private IZhouUserService zhouUserService;

    public static void main(String[] args) {
        //方法先解析这个数组字符串   在转换成 json 格式数据取值
        String sentList = "[{\"name\":5251,\"age\":\"20\",\"email\":\"12\"}," +
                "{\"name\":5252,\"age\":\"10\",\"email\":\"15\"}]";
        JSONArray array = JSONUtil.parseArray(sentList);
        System.out.println(array);

        System.out.println("--------------------------");

        for (int i = 0; i < array.size(); i++) {
            Object str = array.get(i);
            String list = str.toString();
            JSONObject jsonObject = JSONUtil.parseObj(list);
            Object name = jsonObject.get("name");
            Object age = jsonObject.get("age");
            Object email = jsonObject.get("email");
            String ageTo = age.toString();
            System.out.println(name);

            //object 转换成 long 类型: 要先转成 string 类型, 再转换成 long 类型
            //String countString=String.valueOf(countObject);
            //Long count=Long.valueOf(countString);
            //System.out.println(str);
        }


       // System.out.println(array);


        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        JSONObject str = JSONUtil.parseObj(jsonStr);
        System.out.println(str);


    }


}
