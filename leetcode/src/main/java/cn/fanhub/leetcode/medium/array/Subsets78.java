/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: Subsets78.java, v 0.1 2018年04月04日 下午7:42 chengfan Exp $
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}