import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 解析xml的方法
 */
@SpringBootTest
public class aaa {

   /* public static void main(String[] args) throws Exception {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<root>\n" +
                "    <head>\n" +
                "         <H />\n" +
                "        <line>\n" +
                "            <L>\n" +
                "                <LINE_DESCRIPTION>20220401003 人工 A 930915 14328347-2022年3月工资 记账凭证 CNY-491</LINE_DESCRIPTION>\n" +
                "                <BATCH>20220401003 人工 A 930915 14328347</BATCH>\n" +
                "                <LINE_NUM>491</LINE_NUM>\n" +
                "                <COST_CODE>101160404</COST_CODE>\n" +
                "                <COST_NAME>白云电器-营销总部-售后服务部-经理室</COST_NAME>\n" +
                "                <MA_ACCOUNT>66011402</MA_ACCOUNT>\n" +
                "                <MA_NAME>销售费用-工资-伙食补贴</MA_NAME>\n" +
                "                <MA_PROJECT>101400000004</MA_PROJECT>\n" +
                "                <PROJECT_NAME>薪酬福利-售后薪酬</PROJECT_NAME>\n" +
                "                <AMOUNT>400</AMOUNT>\n" +
                "                <OPERATOR_NAME></OPERATOR_NAME>\n" +
                "                <DESCRIPTION>2022-3月工资</DESCRIPTION>\n" +
                "                <PERIOD_NAME>2022-04</PERIOD_NAME>\n" +
                "                <LY></LY>\n" +
                "                <FYCDBM>101160404</FYCDBM>\n" +
                "            </L>\n" +
                "            <L>\n" +
                "                <LINE_DESCRIPTION>20220401003 人工 A 930915 14328347-2022年3月工资 记账凭证 CNY-656</LINE_DESCRIPTION>\n" +
                "                <BATCH>20220401003 人工 A 930915 14328347</BATCH>\n" +
                "                <LINE_NUM>656</LINE_NUM>\n" +
                "                <COST_CODE>101160404</COST_CODE>\n" +
                "                <COST_NAME>白云电器-营销总部-售后服务部-经理室</COST_NAME>\n" +
                "                <MA_ACCOUNT>66011404</MA_ACCOUNT>\n" +
                "                <MA_NAME>销售费用-工资-绩效工资</MA_NAME>\n" +
                "                <MA_PROJECT>101400000004</MA_PROJECT>\n" +
                "                <PROJECT_NAME>薪酬福利-售后薪酬</PROJECT_NAME>\n" +
                "                <AMOUNT>2800</AMOUNT>\n" +
                "                <OPERATOR_NAME></OPERATOR_NAME>\n" +
                "                <DESCRIPTION>2022-3月工资</DESCRIPTION>\n" +
                "                <PERIOD_NAME>2022-04</PERIOD_NAME>\n" +
                "                <LY></LY>\n" +
                "                <FYCDBM>101160404</FYCDBM>\n" +
                "            </L>\n" +
                "        </line>\n" +
                "    </head>\n" +
                "</root>";

        //System.out.println(aaa.readStringXmlOut(str));

        //str.replace()
        List<String> list = getChildMsgByParent(str, "<L>", "</L>");
        for (String s : list) {
            //System.out.println(s);


            Document docResult = XmlUtil.readXML(s);
            Object value = XmlUtil.getByXPath("//L/LINE_DESCRIPTION", docResult, XPathConstants.STRING);
            System.out.println(value);

            Object BATCH = XmlUtil.getByXPath("//L/BATCH", docResult, XPathConstants.STRING);
            System.out.println(BATCH);

            Object LINE_NUM = XmlUtil.getByXPath("//L/LINE_NUM", docResult, XPathConstants.STRING);
            System.out.println(LINE_NUM);

            TestAA testAA = new TestAA();

            testAA.setLINE_DESCRIPTION((String) value);

            System.out.println(testAA);

        }



       *//* String[] split = str.split("<L>");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            System.out.println(s);
        }*//*




        //Document doc = DocumentHelper.parseText(str);
        //Element roots = doc.getRootElement();
        //String line_description = roots.elementText("LINE_DESCRIPTION");
        //System.out.println();
        //System.out.println("根节点 = [" + roots.getName() + "]");
        //System.out.println("内容：" + roots.getText());
        //Document docResult = XmlUtil.readXML(str);

        //Object value = XmlUtil.getByXPath("//root/head/line/L/LINE_DESCRIPTION", docResult, XPathConstants.STRING);
        //System.out.println(value);

    }

    public static List<String> getChildMsgByParent(String info, String begin, String end){
        //通过起始字符拆分成数组
        String[] split = info.split(begin);
        List<String> list = new ArrayList<>();
        //遍历，从第二个元素开始取值（第一个元素为无效元素）
        for (int i = 1; i < split.length; i++) {
            String str = split[i].substring(0,split[i].lastIndexOf(end)+end.length());
            if (str.length() > end.length()) {
                list.add(begin+str);
            }
        }
        return list;
    }*/


    /*public static List<TestAA> readStringXmlOut(String xml) {
        List<TestAA> map = new ArrayList<TestAA>();
        Document doc = null;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml);
            // 获取根节点
            Element rootElt = doc.getRootElement();
            // 拿到根节点的名称
              //System.out.println("根节点：" + rootElt.getName());
            // 获取根节点下的子节点head
            Iterator iter = rootElt.elementIterator("head");
            // 遍历REQUEST_COMMON_FPKJ节点
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                Iterator iters = recordEle.elementIterator("line");
                // 遍历Header节点下的Response节点
                while (iters.hasNext()) {
                    Element s = (Element) iters.next();
                    Iterator a = recordEle.elementIterator("L");
                    String string = a.toString();
                    System.out.println(string);
                    char[] chars = string.toCharArray();
                    System.out.println(chars);


                    TestAA ts=new TestAA();
                        System.out.println(1);
                        String fpdm = s.elementTextTrim("LINE_DESCRIPTION");
                        System.out.println(fpdm);
                        ts.setLINE_DESCRIPTION(fpdm);
                        System.out.println(ts);
                        map.add(ts);

                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
*/

    @Test
    public void  test01(){
        int a = 1;
        Integer b = 1;
        String c = "1";


        if (a == b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }


    }























