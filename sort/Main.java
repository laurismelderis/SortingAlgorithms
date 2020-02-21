package sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args){
		int [][]arr = {new int[10], new int[25], new int [50],
    		new int[75], new int[100], new int[150]};
    	insertRandomVal2D(arr, 0, 100);
		Quicksort quickSort = new Quicksort(cloneArrays(arr));
		InsertionSort insertionSort = new InsertionSort(cloneArrays(arr));
		SquareRootSort squareRootSort = new SquareRootSort(cloneArrays(arr));
		squareRootSort.result();
		// quickSort.result();
		// insertionSort.result();
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
}