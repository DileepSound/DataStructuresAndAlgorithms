package com.saveforgreen.datastructures.problem.string;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> palindromelist = new ArrayList<>();
    public static String longestPalindrome(String s) {
        String result = null;
        if (s == null || s.length() == 0 ) {
            return result;
        }
        if (s.length() == 1
           || isPanlindrome(s)) {
            return s;
        }
        
        //1. iterate through the string s from left to right
        int endIndex = s.length() - 1;
        int i = 0;
        System.out.println("endIndex = " + endIndex);
        while (i < s.length()) {
        //2. if character on the left matches character on the right call palindrome function
            if (i >= 0 && endIndex > 0 
                && (s.charAt(i) == s.charAt(endIndex-1)) 
                && isPanlindrome(s.substring(i, endIndex))) {

                i++;
                endIndex = s.length();
            } else if (i >= endIndex-1) {
                i++;
                endIndex = s.length();
            } else {
                endIndex = endIndex - 1;
            }
        }            
        
        //4. find the longest list
        if (palindromelist.size() > 0) {
            int longestIndex = 0;
            int longestStrLength = 0;
            for (int idx = 0; idx < palindromelist.size(); idx++) {
                String palindrome = palindromelist.get(idx);
                System.out.println(palindrome);
                if (palindrome.length() > longestStrLength) {
                    longestIndex = idx;
                    longestStrLength = palindrome.length();
                }
            }
            result = palindromelist.get(longestIndex);
        } else {
            result = s.substring(0, 1);
        }        
        return result;
    }
    
    private static boolean isPanlindrome(String substr) {
        //3. if true store it in the palindrome list
        if (substr != null && substr.length() > 1) {
            if (substr.equalsIgnoreCase((new StringBuilder(substr).reverse()).toString())) {
                palindromelist.add(substr);
                return true;
            } else {
                return false;
            }
        }    
        return false;
    } 
    
    public static void main(String[] args) {
    	
    System.out.println("Answer = " + longestPalindrome("kamalahaasan"));
    
    }
    
}