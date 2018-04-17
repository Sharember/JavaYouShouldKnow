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
 * @version $Id: SuperPow372.java, v 0.1 2018年04月16日 下午8:08 chengfan Exp $
 */
public class SuperPow372 {
    //public int superPow(int a, int[] b) {
    //    return superPow(a, b, b.length, 1337);
    //}
    //
    //private int superPow(int a, int[] b, int length, int k) {
    //    if (length == 1) {
    //        return powMod(a, b[0], k);
    //    }
    //
    //    return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    //}
    //
    //
    ////x^y mod k
    //private int powMod(int x, int y, int k) {
    //    x %= k;
    //    int pow = 1;
    //    for (int i = 0; i < y; i++) {
    //        pow = (pow * x) % k;
    //    }
    //    return pow;
    //}

    //public int superPow(int a, int[] b) {
    //    int res = 1;
    //    for(int i : b){
    //        res = pow(res, 10) * pow(a, i) % 1337;
    //    }
    //    return res;
    //}
    //
    //int pow(int x, int y){
    //    if(y == 0) return 1;
    //    if(y == 1) return x % 1337;
    //    return pow(x % 1337, y / 2) * pow(x % 1337, y - y / 2) % 1337;
    //}

    //

    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int p = 0;
        for (int i : b) p = (p * 10 + i) % 1140;
        if (p == 0) p += 1440;
        return power(a, p, 1337);
    }
    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }

}