package com.miscellaneous.datastructures;// Java program to remove duplicates, the order of
// characters is not maintained in this program

import java.util.Arrays;

public class RemoveDuplicateCharsInArray
{
	/* Method to remove duplicates in a sorted array */
	static String removeDupsSorted(String str)
	{
		int index = 1, resultArrayIndex = 1;
		
		// Character array for removal of duplicate characters
		char arr[] = str.toCharArray();

		char result[] = new char[str.length()];
		result[0] = arr[0];
		
		/* In place removal of duplicate characters*/
		while (index != arr.length)
		{
			if(arr[index] != arr[index-1])
			{
				result[resultArrayIndex] = arr[index];
				resultArrayIndex++;
			}
			index++;
		
		}
	
		str = new String(result);
		return str.substring(0,result.length);
	}
	
	/* Method removes duplicate characters from the string
	This function work in-place and fills null characters
	in the extra space left */
	static String removeDups(String str)
	{
	// Sort the character array
	char temp[] = str.toCharArray();
	Arrays.sort(temp);
	str = new String(temp);
		
	// Remove duplicates from sorted
	return removeDupsSorted(str);
	}
	
	// Driver Method
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println(removeDups(str));
	}
}
