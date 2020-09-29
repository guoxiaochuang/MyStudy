package com.guo.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * xml文件解析
 */
public class FileXmlAnalysis{

    public static void main(String[] args) {
        analysisXml();
    }

    private static void analysisXml(){
        try {

            String systemKey = "jiake";

            Map<String, String> map = new HashMap();

            String webserviceUrl = "";
            String methodName = "";
            String parameterSql = "";
            String dbUrl = "";
            String dbUser = "";
            String dbPassword = "";

            //1.创建Reader对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //2.加载xml
            Document document = builder.parse(new File("src/conf/config.xml"));
            //3.获取根节点
            NodeList list = document.getElementsByTagName("system");
            for(int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                NamedNodeMap names = node.getAttributes();
                Node n = names.item(0);
                String systemName = n.getNodeValue();
                NodeList childNodes = node.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node node2 = childNodes.item(j);
                    String keyFirst = node2.getNodeName();
//                    System.out.println("    " + node2.getNodeName());
                    NodeList childNodes2 = node2.getChildNodes();
                    for (int k=0;k<childNodes2.getLength();k++) {
                        Node node3 = childNodes2.item(k);
                        String keySecond = node3.getNodeName();
                        String value = node3.getTextContent();
//                        System.out.println("        "+node3.getNodeName() + ":" + node3.getTextContent());
//                        System.out.println(keySecond+":"+value);
                        if(keyFirst.equals("webService") && keySecond.equals("url")){
                            webserviceUrl = value;
                        }
                        if(keyFirst.equals("webService") && keySecond.equals("methodName")){
                            methodName = value;
                        }
                        if(keyFirst.equals("webService") && keySecond.equals("parameterSql")){
                            parameterSql = value;
                        }
                        if(keyFirst.equals("database") && keySecond.equals("url")){
                            dbUrl = value;
                        }
                        if(keyFirst.equals("database") && keySecond.equals("user")){
                            dbUser = value;
                        }
                        if(keyFirst.equals("database") && keySecond.equals("password")){
                            dbPassword = value;
                        }
                    }

                }
            }
            System.out.println(
                    "webserviceUrl:" + webserviceUrl
                            + ", methodName:" + methodName
                            + ", parameterSql:" + parameterSql
                            + ", dbUrl:" + dbUrl
                            + ", dbUser:" + dbUser
                            + ", dbPassword:" + dbPassword
            );
            map.put("webserviceUrl",webserviceUrl);
            map.put("methodName",methodName);
            map.put("parameterSql",parameterSql);
            map.put("dbUrl",dbUrl);
            map.put("dbUser",dbUser);
            map.put("dbPassword",dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}