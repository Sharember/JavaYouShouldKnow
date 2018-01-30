package cn.fanhub.rpc.serialization.base;

import java.io.Serializable;


public class JavaSerializerModel implements Serializable {
    private transient String name = "name";
    private String phone = "123";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}