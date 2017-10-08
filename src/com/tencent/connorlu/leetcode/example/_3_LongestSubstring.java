package com.tencent.connorlu.leetcode.example;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int max = end - start + Math.min(s.length(), 1);
		int count = s.length();
		for (int index = 1; index < count; index++) {

			char c = s.charAt(index);

			for (int j = start; j <= end; j++) {
				if (s.charAt(j) == c) {
					start = j + 1;
					break;
				}
			}

			end = index;

			// for(int j=start;j<=end;j++){
			// System.out.print(s.charAt(j));
			// }
			// System.out.println();

			max = Math.max(end - start + 1, max);
		}

		return max;

	}
	
	public int lengthOfLongestSubstring_2(String s) {
		int start = 0;
		int max = 0;
		int count = s.length();
		
		Map<Character,Integer> sMap = new HashMap<>();
		for(int end=0;end<count;end++){
			char c = s.charAt(end);
			if(sMap.containsKey(c)){
				start = Math.max(start, sMap.get(c)+1);
			}
			
			max = Math.max(max, end-start+1);
			sMap.put(c, end);
		}
		
		return max;
	}

	public static void main(String[] args) {
		_3_LongestSubstring algorithms = new _3_LongestSubstring();

		System.out.println(algorithms.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(algorithms.lengthOfLongestSubstring(""));
		System.out.println(algorithms.lengthOfLongestSubstring("abc"));
		System.out.println(algorithms.lengthOfLongestSubstring("b"));

		System.out.println("<------------------------------------------->");

		System.out.println(algorithms.lengthOfLongestSubstring_2("abcabcbb"));
		System.out.println(algorithms.lengthOfLongestSubstring_2(""));
		System.out.println(algorithms.lengthOfLongestSubstring_2("abc"));
		System.out.println(algorithms.lengthOfLongestSubstring_2("b"));
	}
}
