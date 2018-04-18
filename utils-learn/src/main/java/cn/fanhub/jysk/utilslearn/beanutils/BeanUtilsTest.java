/**
 *    Copyright 2018 chengfan(fanhub.cn)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.fanhub.jysk.utilslearn.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author chengfan
 * @version $Id: BeanUtilsTest.java, v 0.1 2018年04月18日 下午7:58 chengfan Exp $
 */
public class BeanUtilsTest {
    @Test
    public void test() throws Exception {
        // init
        Class<?> clazz = Class.forName(User.class.getName());
        Object user = clazz.newInstance();

        // set
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("name")) {
                BeanUtils.setProperty(user, field.getName(), "chengfan");
            } else {
                BeanUtils.setProperty(user, field.getName(), 22);
            }
        }

        // show
        for (Field field : clazz.getDeclaredFields()) {
            String property = BeanUtils.getProperty(user, field.getName());
            System.out.println(property);
        }
    }

    @Test
    public void test2() throws Exception {
        // init
        Class<?> clazz = Class.forName(User.class.getName());
        Object user = clazz.newInstance();

        Map<String, Object> beanMap = new HashMap<String, Object>();
        beanMap.put("name", "chengfan");
        beanMap.put("age", 22);

        // set
        BeanUtils.populate(user, beanMap);

        // show
        for (Field field : clazz.getDeclaredFields()) {
            String property = BeanUtils.getProperty(user, field.getName());
            System.out.println(property);
        }
    }

    @Test
    public void test3() throws Exception {
        // init
        Class<?> clazz = Class.forName(User.class.getName());
        Object user = clazz.newInstance();

        Map<String, Object> beanMap = new HashMap<String, Object>();
        beanMap.put("name", "chengfan");
        beanMap.put("age", 22);

        // set
        BeanUtils.populate(user, beanMap);

        // trans
        Map<String, String> describe = BeanUtils.describe(user);

        for (Entry<String, String> entry : describe.entrySet()) {
            System.out.println(String.format("%s -- %s", entry.getKey(), entry.getValue()));
        }
    }

    @Test
    public void  test4() throws Exception {

        DateBean bean = new DateBean();

        ConvertUtils.register(new Converter() {
            public Object convert(Class aClass, Object o) {
                String p = (String)o;
                if(p== null || p.trim().length()==0){
                    return null;
                }
                try{
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(p.trim());
                }
                catch(Exception e){
                    return null;
                }
            }
        }, java.util.Date.class);

        BeanUtils.setProperty(bean, "date", "2018-04-18");

        System.out.println(BeanUtils.getProperty(bean, "date"));
    }
}