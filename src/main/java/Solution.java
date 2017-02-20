package main.java;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author Fikru
 *
 */
public class Solution {
	
	static String regex = "[10]*(10+1)";
	static int numOfPartition = 0;
	static Pattern pattern;
	
	public Solution(){
		pattern = Pattern.compile(regex);
	}	
	
    /** recursively finds the match of the input string and returns the numOfPartition
	 * Returns -1 if the input is: 
	 *				null, 
	 *				empty string, 
	 *				with leading zero or 
	 *				with ending zero.
	 * splits the string in to a matched(left) and unmatched(right) sections.
	 * if the right section are all '1s', the count will add to numOfPartition
	 * it then looks for the index of a power of 5 sequence using the left section and the last match from the left section.
	 * @param input
	 * @return
	 */
	public static int getMin(String input) {
		if(input == null || input.equals("") || input.charAt(0) == '0' || input.charAt(input.length() - 1) == '0'){
			return -1;
		}else if (isPowerOfFive(input)) {
			return numOfPartition++;
		} else {
			int end = 0;			
			String left = "";
			String right = "";
			Matcher matcher = pattern.matcher(input);
			if (matcher.find()) {
				end = matcher.end();
				left = matcher.group();
			}
			right = input.substring(end);
			if (!right.equals("")) {
				// if all the bits on the right of the match are all '1s', then
				// each bit will count as a partition				
				if (isSequenceOfOne(right)) {
					numOfPartition += right.length();
				}
			} else {
				String lastMatchedGroup = matcher.group(matcher.groupCount());
				int index = indexFinder(left, lastMatchedGroup);
				if (index != -1) {
					numOfPartition++;
					left = input.substring(0, index);
				}
			}
			return getMin(left);
		}
	}

	/**checks if the '1' and '0' sequence is a power of 5
	 * @param str
	 * @return
	 */
	public static boolean isPowerOfFive(String str) {
		long decimal = binaryToDecimal(str);
		int x = (int) (Math.log(decimal) / Math.log(5));
		if (decimal == Math.pow(5, x)) {
			return true;
		}
		return false;
	}

	/**converts the '1' and '0' sequence to decimal
	 * @param str
	 * @return
	 */
	public static long binaryToDecimal(String str) {
		long n = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				n = (long) (Math.pow(2, str.length() - 1 - i) + n);
			}
		}
		return n;
	}
	
	/** for the given inputs(input and match), this functions returns an index which points to the 
	 * Starting point of a sequence representing power of 5. 
	 * It looks for the index by shifting one bit to the left from the 'input' for each recursion and prepending the bit to the 'match'.
	 * @param input
	 * @param match
	 * @return
	 */
	public static int indexFinder(String input, String match){	
		if(input.length() == match.length()){ return -1;}
		if(isPowerOfFive(match)){return input.length() - match.length();}
		else{
			match = input.substring(input.length() - match.length() - 1, input.length());
		}
		return indexFinder(input, match);
	}
	
	/** used to check the input string are all '1s'
	 * @param str
	 * @return
	 */
	public static boolean isSequenceOfOne(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				num++;
			}
		}
		if (num / str.length() == 1) {
			return true;
		}
		return false;
	}
}