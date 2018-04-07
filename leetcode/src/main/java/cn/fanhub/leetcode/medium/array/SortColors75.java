/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.leetcode.medium.array;

import org.junit.Test;

/**
 *
 * @author chengfan
 * @version $Id: SortColors75.java, v 0.1 2018年04月03日 下午7:54 chengfan Exp $
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        int zero = 0;
        int second = nums.length - 1;
        for(int i = zero; i <= second;) {
            if (nums[i] == 0) {
                swap(nums, zero++, i++);

            } else if(nums[i] == 2) {
                swap(nums, second--, i);
            } else {
                i++;
            }
        }

    }

    private void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {2};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }
}