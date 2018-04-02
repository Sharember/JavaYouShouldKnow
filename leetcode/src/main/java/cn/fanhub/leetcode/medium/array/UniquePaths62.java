/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.leetcode.medium.array;

import org.junit.Test;

/**
 *
 * @author chengfan
 * @version $Id: UniquePaths62.java, v 0.1 2018年04月02日 下午7:17 chengfan Exp $
 * @url https://leetcode.com/problems/unique-paths/description/
 *
 * 机器人位于一个 m x n 网格的左上角, 在下图中标记为“Start” (开始)。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”(结束)。
 *
 * 问有多少条不同的路径？
 */
public class UniquePaths62 {

    /**
     * 典型的动态规划
     */
    public int uniquePaths(int m, int n) {
        int results[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    results[i][j] = 1;
                } else {
                    results[i][j] = results[i-1][j] + results[i][j-1];
                }
            }
        }
        return results[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[] results = new int[n];
        results[0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                results[j] += results[j - 1];
            }
        }
        return results[n-1];
    }

    @Test
    public void main(){
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths2(7,3));

    }




}