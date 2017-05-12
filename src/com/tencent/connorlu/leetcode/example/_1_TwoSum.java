package com.tencent.connorlu.leetcode.example;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {

		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int anotherAddFactor = target - nums[i];
			Integer anotherAddFactorIndex = map.get(anotherAddFactor);
			if(anotherAddFactorIndex!=null){
				return new int[]{anotherAddFactorIndex,i};
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}

}
