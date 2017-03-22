package com.fire.utils;


public class SortUtil {
	public static void insertSort(int[] numbers) {   
	    int size = numbers.length, temp, j;   
	    for(int i=1; i<size; i++) {   
	        temp = numbers[i];   
	        for(j = i; j > 0 && temp < numbers[j-1]; j--)   
	            numbers[j] = numbers[j-1];   
	        numbers[j] = temp;   
	    }   
	}  
}
