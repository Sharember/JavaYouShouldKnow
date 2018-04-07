/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.leetcode.medium.array;

/**
 *
 * @author chengfan
 * @version $Id: TargetSum494.java, v 0.1 2018年04月06日 下午9:47 chengfan Exp $
 */
public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S < -sum || S > sum) { return 0;}
        int sumLength = 2 * sum + 1;
        int dp[][] = new int[nums.length + 1][sumLength];
        dp[0][sum] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < sumLength; j++) {
                int currentNum = nums[i - 1];
                if (j + currentNum < sumLength) {
                    dp[i][j] = dp[i - 1][j + currentNum];
                }
                if (j - currentNum >= 0) {
                    dp[i][j] += dp[i - 1][j - currentNum];
                }
            }
        }
        return dp[nums.length][sum + S];
    }

    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}