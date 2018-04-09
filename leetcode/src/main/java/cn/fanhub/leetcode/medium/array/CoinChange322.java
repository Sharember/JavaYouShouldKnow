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

import org.junit.Test;

/**
 *
 * @author chengfan
 * @version $Id: CoinChange322.java, v 0.1 2018年04月08日 下午8:30 chengfan Exp $
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // initialize to maximum value
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        // put this at outer loop to (possibly) avoid some dp slots
        for (int coin : coins)
            for(int i = coin ;i < dp.length ; i++)
                // check on possible overflow problem
                if(dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        // if bigger -> still Max_Value -> not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] sum = new int[]{1, 2, 5};
        System.out.println(coinChange(sum, 2));
    }
}