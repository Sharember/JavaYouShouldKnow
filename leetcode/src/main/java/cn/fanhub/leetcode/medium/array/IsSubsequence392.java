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
package cn.fanhub.leetcode.medium.array;

/**
 *
 * @author chengfan
 * @version $Id: IsSubsequence392.java, v 0.1 2018年04月12日 下午8:32 chengfan Exp $
 */
public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if(m > n) return false;

        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int i = 0, j = 0;
        while(i < m && j < n){
            if(sc[i] == tc[j]) i++;
            j++;
        }
        return i == m;
    }

    public boolean isSubsequence2(String s, String t) {
        for(int i=0, pos=0; i<s.length(); i++, pos++){
            pos = t.indexOf(s.charAt(i), pos);//使用java的类函数，java类函数肯定在jvm上会有优化所以比手写代码更快。
            if(pos == -1) return false;
        }
        return true;
    }
}