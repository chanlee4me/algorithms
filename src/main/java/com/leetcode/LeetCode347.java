package com.leetcode;

import java.util.*;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(Integer key : map.keySet()){
            if(minHeap.size() < k) minHeap.offer(key);
            else{
                if(map.get(key) > map.get(minHeap.peek())){
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()){
            res[index++] = minHeap.poll();
        }
        return res;
    }

}
