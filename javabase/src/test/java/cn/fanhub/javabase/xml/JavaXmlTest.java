package cn.fanhub.javabase.xml;

import org.junit.Test;

public class JavaXmlTest {

    private JavaXml javaXml = new JavaXml();

    @Test
    public void saveToXML() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setUserName("jack");
        javaXml.saveToXML(user);
    }

    @Test
    public void getObjectFromXML() throws Exception {
        System.out.println(((User) javaXml.getObjectFromXML("file/out/object.xml")).getUserName());
    }

}