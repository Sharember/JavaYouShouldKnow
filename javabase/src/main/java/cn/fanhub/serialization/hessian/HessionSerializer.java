package cn.fanhub.serialization.hessian;

import cn.fanhub.serialization.base.MySerializer;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessionSerializer implements MySerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            HessianOutput output = new HessianOutput(outputStream);
            output.writeObject(obj);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if (data == null) {
            throw new NullPointerException();
        }
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            HessianInput input = new HessianInput(inputStream);
            return ((T) input.readObject());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}