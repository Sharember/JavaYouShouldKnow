/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.leetcode.medium.array;

/**
 *
 * @author chengfan
 * @version $Id: MinimumPathSum64.java, v 0.1 2018年04月05日 下午9:36 chengfan Exp $
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int[] result = new int[grid[0].length];
        // 初始化第一行
        result[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            result[j] = result[j - 1] + grid[0][j];
        }
        // 从第二行开始动态规划
        for (int i = 1; i < grid.length; i++) {
            // 初始化第一个值
            result[0] = result[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                result[j] = Math.min(result[j], result[j - 1]) + grid[i][j];
            }
        }


        return result[grid[0].length - 1];
    }


}