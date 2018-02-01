package cn.fanhub.javabase.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FastjsonWithFeature {
    @Before
    public void setUp() {

    }

    @Test
    public void intValue() {
        String jsonString = getJson("file/json/TestValue.json");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println();

        if (jsonObject.get("int") instanceof Integer) {
            System.out.println("int");
        } else {
            System.out.println("string");
        }

        System.out.println("------------");
        System.out.println(jsonObject.get("string") instanceof String);
        if (jsonObject.get("string") instanceof Integer) {
            System.out.println("int");
        } else {
            System.out.println("string");
        }

        System.out.println("------------");
        if (jsonObject.get("long") instanceof Long) {
            System.out.println("long");
        } else {
            System.out.println("string");
        }

        System.out.println("------------");
        System.out.println(jsonObject.get("double") instanceof String);
        if (NumberUtils.isCreatable(jsonObject.get("double").toString())) {
            System.out.println("double");
        } else {
            System.out.println("string");
        }

        System.out.println(jsonObject.get("booleanb") instanceof String);
        System.out.println(jsonObject.get("boolean") instanceof String);
        System.out.println(jsonObject.get("booleanb") instanceof Boolean);
        System.out.println(jsonObject.get("boolean") instanceof Boolean);

    }

    private String getJson(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuilder stringBuilder = new StringBuilder();
                while (bufferedReader.ready()) {
                    stringBuilder.append(bufferedReader.readLine().trim());
                }
                System.out.println(stringBuilder.toString());
                return stringBuilder.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "{}";
    }


}