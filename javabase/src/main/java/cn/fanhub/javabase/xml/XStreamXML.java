package cn.fanhub.javabase.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XStreamXML {

    public void saveToXML(Object o) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        File xmlFile = new File("file/out/xStream-object.xml");
        FileOutputStream ofs = new FileOutputStream(xmlFile);
        xStream.toXML(o, ofs);
        ofs.close();
    }

    public Object getFromObject(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));
        XStream xStream = new XStream(new DomDriver());
        return xStream.fromXML(inputStream);
    }
}