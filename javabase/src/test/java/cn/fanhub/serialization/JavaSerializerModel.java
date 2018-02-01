package cn.fanhub.serialization;

import java.io.Serializable;
import java.util.Date;

public class JavaSerializerModel implements Serializable {
    private transient String name  = "name";
    private String phone = "123";
    private Date date = new Date(1514739661000L);

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}