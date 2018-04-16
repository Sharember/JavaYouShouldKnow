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
package cn.fanhub.Introspector;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

/**
 *
 * @author chengfan
 * @version $Id: Introspector.java, v 0.1 2018年04月16日 下午8:37 chengfan Exp $
 */
public class IntrospectorTest {


    @Test
    public void test1 () throws Exception {
        User user = new User("jack", 21);

        String propertyName = "name";
        PropertyDescriptor namePd = new PropertyDescriptor(propertyName, User.class);

        System.out.println("名字：" + namePd.getReadMethod().invoke(user));
        namePd.getWriteMethod().invoke(user, "tom");
        System.out.println("名字：" + namePd.getReadMethod().invoke(user));

        System.out.println("========================================");

        String agePropertyName = "age";
        PropertyDescriptor agePd = new PropertyDescriptor(agePropertyName, User.class);

        System.out.println("年龄：" + agePd.getReadMethod().invoke(user));
        agePd.getWriteMethod().invoke(user, 22);
        System.out.println("年龄：" + agePd.getReadMethod().invoke(user));

    }

    @Test
    public void test2() throws Exception {
        // 获取整个Bean的信息
        // BeanInfo beanInfo= Introspector.getBeanInfo(user.getClass());
        // 在Object类时候停止检索，可以选择在任意一个父类停止
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        System.out.println("所有属性描述：");
        // 获取所有的属性描述
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : pds) {
            System.out.println(propertyDescriptor.getName());
        }
        System.out.println("所有方法描述：");
        for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
            System.out.println(methodDescriptor.getName());
            // Method method = methodDescriptor.getMethod();
        }
    }

}