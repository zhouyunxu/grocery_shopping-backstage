import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JSONTest03 {


    public static Map<String, String> xmlToMap(String xml) {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public static void main(String[] args) {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<root>" +
                "<head>" +
                "<H>" +
                "<URL>http://eip.bydq.com/Portal/InstanceSheets.aspx?InstanceId=8b51dfa1-b528-44f9-903d-a9257be3e019</URL>" +
                "<name>张三</name>" +
                "<age></age>" +
                "</H>" +
                "</head>" +
                "</root>";


        Document document = XmlUtil.parseXml(str);
        System.out.println(document);

        Document docResult=XmlUtil.readXML(str);

        Object url = XmlUtil.getByXPath("//root/head/H/URL", docResult, XPathConstants.STRING);
        System.out.println(url);

        Object name = XmlUtil.getByXPath("//root/head/H/name", docResult, XPathConstants.STRING);
        System.out.println(name);

        Object age = XmlUtil.getByXPath("//root/head/H/age", docResult, XPathConstants.STRING);
        System.out.println(age);


        Map<String, String> stringStringMap = xmlToMap(str);
        String head = stringStringMap.get("head");

        System.out.println(head);


        System.out.println(stringStringMap);
    }




}
