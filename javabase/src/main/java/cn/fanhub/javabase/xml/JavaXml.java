package cn.fanhub.javabase.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaXml {

    public void saveToXML(Object o) throws IOException {
        File xmlFile = new File("file/out/object.xml");
        if (!xmlFile.exists()) {
            xmlFile.createNewFile();
        }
        FileOutputStream ofs = new FileOutputStream(xmlFile);
        XMLEncoder xe = new XMLEncoder(ofs);
        xe.writeObject(o);
        xe.close();
        ofs.close();
    }

    public Object getObjectFromXML(String path) throws IOException {
        File xmlFile = new File(path);
        FileInputStream in = new FileInputStream(xmlFile);
        XMLDecoder xd = new XMLDecoder(in);
        Object o  = xd.readObject();
        xd.close();
        in.close();
        return o;
    }
}