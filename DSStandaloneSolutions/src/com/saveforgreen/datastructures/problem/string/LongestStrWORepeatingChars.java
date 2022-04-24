package com.saveforgreen.datastructures.problem.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hashset is better for unique str/value problems... and use two indexes to avoid multiple loops
 * @author yes_d
 *
 */
public class LongestStrWORepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("aaajsdjksjhssskjhdfslkkkk"));

		System.out.println(lengthOfLongestSubstringMoreEfficient("aaajsdjksjhssskjhdfslkkkk"));
	}

	public static int lengthOfLongestSubstring(String s) {
        // form a string that is of unique characters stop when a character repeats

		int maxSubstrLen = 0;
        int index = 0;
        Map<Integer, String> substrTracker = new HashMap<>();
        substrTracker.put(index, new String(""));

        for (int i = 0; i < s.length(); i++) {
        	// append characters until a character repeats
            if (!substrTracker.get(index).contains(s.charAt(i)+"")) {
                substrTracker.put(index, (substrTracker.get(index) + s.charAt(i)));

                if (i == s.length()-1) {
                	maxSubstrLen = (maxSubstrLen > substrTracker.get(index).length()) ? maxSubstrLen : substrTracker.get(index).length();
                }
            // save the current substring in the Map and start working on the next substring
            } else {
            	maxSubstrLen = (maxSubstrLen > substrTracker.get(index).length()) ? maxSubstrLen : substrTracker.get(index).length();
                //substrTracker.put(substrTracker.get(index).length(), substrTracker.get(index));
                i = ++index;
                substrTracker.put(index, new String(s.charAt(i)+""));
            }
        }
        return maxSubstrLen;
    }

	/** Efficient !!!! **/
	public static int lengthOfLongestSubstringEfficient(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

	/** Even more Efficient !!!! **/
	public static int lengthOfLongestSubstringMoreEfficient(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
