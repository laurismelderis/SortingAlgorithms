package sort;

import java.util.Arrays;
import java.util.Random;

public class Main{
	public static void main(String[] args){
		int [][]unsortedArr = {new int[10], new int[25], new int [50],
    		new int[75], new int[100], new int[150]};
    	int [][]sortedArr = new int [unsortedArr.length][];
    	Quicksort quickSort = new Quicksort();
		InsertionSort insertionSort = new InsertionSort();
		SquareRootSort squareRootSort = new SquareRootSort();
		QuicksortRecursion quicksortR = new QuicksortRecursion();
    	insertRandomVal2D(unsortedArr, 0, 100);
    	outputArr(unsortedArr[0]);
    	System.out.println("Nr  Quicksort       InsertionSort   SquareRootSort  QuicksortWithRecursion");
    	for (int i = 0; i < unsortedArr.length; i++){
			sortedArr[i] = quickSort.sort(unsortedArr[i].clone());
			sortedArr[i] = insertionSort.sort(unsortedArr[i].clone());
			sortedArr[i] = squareRootSort.sort(unsortedArr[i].clone());
			sortedArr[i] = quicksortR.sort(unsortedArr[i].clone());
			System.out.printf("% d. %11.9fsec  %11.9fsec  %11.9fsec  %11.9fsec\n",
			(i+1), quickSort.time, insertionSort.time, squareRootSort.time, quicksortR.time);
		}
	}
	private static int[][] cloneArrays(int[][] arrays) {
		arrays = arrays.clone();
		for (int i = 0; i < arrays.length; i += 1) {
			arrays[i] = arrays[i].clone();
		}
		return arrays;
	}
	public static void insertRandomVal2D(int[][] arr, int min, int max){
		for (int []a: arr){
			for(int i = 0; i < a.length; i++){
				a[i] = randomNumber(min, max);
			}
		}
	}
	public static int randomNumber(int min, int max){
		Random rand = new Random();
		return rand.nextInt((max+1)-min)+min;
	}
	public static void outputArr(int []a){
		for (int i: a){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}