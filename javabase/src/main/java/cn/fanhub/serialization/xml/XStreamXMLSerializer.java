package cn.fanhub.serialization.xml;

import cn.fanhub.serialization.base.MySerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xstream 序列化
 */
public class XStreamXMLSerializer implements MySerializer{

    private static final XStream X_STREAM = new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T obj) {
        return X_STREAM.toXML(obj).getBytes();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) X_STREAM.fromXML(xml);
    }

}