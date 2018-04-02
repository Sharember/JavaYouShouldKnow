/**
 *
 *  Copyright 2018 chengfan
 *
 *  website: fanhub.cn
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.fanhub.classload;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author chengfan
 * @version $Id: Main.java, v 0.1 2018年03月14日 下午6:44 chengfan Exp $
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String classDataRootPath = "/Users/chengfan/Documents/SelfStudy/java/JavaYouShouldKnow/javabase/src/main/java";
        System.out.println(Thread.currentThread().getContextClassLoader().toString());
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);

        TestClassLoader testClassLoader = new TestClassLoader(new URL[]{new File(classDataRootPath).toURI().toURL()}, Thread.currentThread().getContextClassLoader());
        String classNamea = "cn.fanhub.classload.ClassA";
        String classNameb = "cn.fanhub.classload.ClassB";
        try {
            //Class<?> class1 = fscl1.findClass(classNamea);
            //Object obj1 = class1.newInstance();
            //Class<?> class2 = fscl2.loadClass(classNamea);
            //Object obj2 = class2.newInstance();
            Class<?> aClass = testClassLoader.loadClass(classNamea);
            Class<?> aClass1 = testClassLoader.loadClass(classNameb);
            System.out.println(aClass.getClassLoader());
            System.out.println(aClass1.getClassLoader());

            //Class<?> classb1 = fscl1.loadClass(classNameb);
            //Object objb1 = class1.newInstance();
            //Class<?> classb2 = fscl2.loadClass(classNameb);
            //Object objb2 = class2.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}