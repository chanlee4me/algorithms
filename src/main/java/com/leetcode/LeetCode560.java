package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        map.put(0, 1);
        for(int val : nums){
            preSum += val;
            int target = preSum - k;
            if(map.containsKey(target)){
                res += map.get(target);
            }
            if(!map.containsKey(preSum)){
                map.put(preSum, 0);
            }
            map.put(preSum, map.get(preSum) + 1);
        }
        return res;
    }
}
