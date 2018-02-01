package cn.fanhub.javabase.xml;

import org.junit.Test;

public class XStreamXMLTest {
    private XStreamXML xStreamXML = new XStreamXML();
    @Test
    public void saveToXML() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setUserName("jack");
        xStreamXML.saveToXML(user);
    }

    @Test
    public void getFromObject() throws Exception {
        System.out.println(((User) xStreamXML.getFromObject("file/out/xStream-object.xml")).getUserName());
    }

}