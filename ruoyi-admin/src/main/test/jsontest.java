import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class jsontest {

    public static void main(String[] args) {

        String str = "[\n" +
                "        {\n" +
                "            \"name\": \"\",\n" +
                "            \"url\": \"http://www.google.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Baidu\",\n" +
                "            \"url\": \"http://www.baidu.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"SoSo\",\n" +
                "            \"url\": \"http://www.SoSo.com\"\n" +
                "        }\n" +
                "    ]";

        //String str = "{\"name:\"\",age:\"18\"}";


      //  JSONObject jsonObject = JSONObject.parseObject(str);
        //System.out.println(jsonObject);

        JSONArray objects = JSONArray.parseArray(str);
        for (int i = 0; i < objects.size(); i++) {
            Object o = objects.get(i);
            String string = o.toString();
            JSONObject jsonObject = JSONObject.parseObject(string);
            String name = jsonObject.getString("name");
            System.out.println(name);
            System.out.println(o);
        }



        System.out.println(objects);

       // String id = jsonObject.getString("c");



       // System.out.println(id);










    }


}
