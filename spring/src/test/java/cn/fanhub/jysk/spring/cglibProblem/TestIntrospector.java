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
package cn.fanhub.jysk.spring.cglibProblem;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author chengfan
 * @version $Id: TestIntrospector.java, v 0.1 2018年04月17日 下午9:08 chengfan Exp $
 */
public class TestIntrospector {

    @Test
    public void test1 () throws Exception {
        //模拟从 xml 中获得到了数据
        //<bean id="user" class="cn.fanhub.jysk.spring.introspector.User">
        //    <property name="name" value="chengfan" />
        //    <property name="age" value="22" />
        //</bean>

        String clazz = "cn.fanhub.jysk.spring.introspector.User";
        Map<String, Object> properties = new HashMap<>();

        //properties.put("Name", "chengfan");
        //properties.put("Age", 22);
        //reflect(clazz, properties);

        properties.put("name", "chengfan");
        properties.put("age", 22);
        introspector(clazz, properties);
    }

    @SuppressWarnings("unchecked")
    public void reflect(String clazz, Map<String, Object> properties) throws Exception {
        //反射创建实例
        Class target = Class.forName(clazz);
        Object bean = target.newInstance();

        //初始化容器时，调用setter注入
        for (Entry<String, Object> entry : properties.entrySet()) {
            String _setName = "set" + entry.getKey();
            if ("name".equalsIgnoreCase(entry.getKey())) {
                Method setMethod = target.getMethod(_setName, String.class);
                setMethod.invoke(bean, entry.getValue().toString());
            } else {
                Method setMethod = target.getMethod(_setName, int.class);
                setMethod.invoke(bean, Integer.parseInt(entry.getValue().toString()));
            }
        }

        // show
        for (Entry<String, Object> entry : properties.entrySet()) {
            String _getName = "get" + entry.getKey();
            if ("name".equalsIgnoreCase(entry.getKey())) {
                Method setMethod = target.getMethod(_getName);
                System.out.println(setMethod.invoke(bean));
            } else {
                Method setMethod = target.getMethod(_getName);
                System.out.println(setMethod.invoke(bean));
            }
        }
    }

    public void introspector(String clazz, Map<String, Object> properties) throws Exception {
        //反射创建实例
        Class target = Class.forName(clazz);
        Object bean = target.newInstance();

        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : pds) {
            Method setMethod = pd.getWriteMethod();
            String fieldName = pd.getName();

            if ("name".equalsIgnoreCase(fieldName)) {
                setMethod.invoke(bean, properties.get(fieldName));
            } else if ("age".equalsIgnoreCase(fieldName)){
                setMethod.invoke(bean, properties.get(fieldName));
            }
        }


        // show
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getReadMethod().invoke(bean));
        }

    }
}