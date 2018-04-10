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
package cn.fanhub.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: TestFastJson.java, v 0.1 2018年04月09日 下午2:27 chengfan Exp $
 */
public class TestFastJson {

    @Test
    public void test() {
        String str = "[{}]";
        List<Model> list = JSON.parseArray(str, Model.class);

        System.out.println(list.isEmpty());

    }
}

class Model {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}