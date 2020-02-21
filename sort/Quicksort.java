package sort;

import java.util.Random;
import java.util.Scanner;

public class Quicksort {
	private int [][] arrs;
	public Quicksort(int[][] arrs){
		this.arrs = arrs;
	}
	public void result (){
		// int count = randomNum(5, 12);
		// int arr[] = new int[count];
		// for (int i = 0; i < count;i++){
		// 	arr[i] = randomNum(-100, 100);
		// }
		// outputArr(arr);
		// quickSort(arr);
		// outputArr(arr);
		int count = 0;
    	System.out.println("\nQuicksort algorithm using " + arrs.length
    		+ " arrays: ");
    	for (int []arr: arrs){
    		System.out.println("\nArray ("+ arr.length +"): ");
			outputArr(arr);
			long t0 = System.nanoTime();
    		quickSort(arr);
    		long t1 = System.nanoTime();
    		System.out.println("Sorted: ");
    		outputArr(arr);
    		System.out.printf("Sorting time: %.9f seconds taken\n", (double)((t1-t0)/Math.pow(10, 9)));
    		count++;
    	}
	}
	public static void quickSort(int[] a){
		int N = a.length;
		int prev = 0;
		int median = N/2;
		int left[] = new int[median];
		int right[] = new int[median];
		left[0] = 0;
		right[0] = N - 1;
		int stackpos = 1;
		do {
			stackpos--;
			int I = left[stackpos];
			int r = right[stackpos];
			do {
			int m = a[randomNum(I, r)];
			int i = I;
			int j = r;
				do {
					while (a[i] < m){
						i++;
					}
					while (a[j] > m){
						j--;
					}
					if (i <= j) {
						prev = a[i];
						a[i] = a[j];
						a[j] = prev;
						i++;
						j--;
					}
				} while(i <= j);
				if (i < r){
					left[stackpos] = i;
					right[stackpos] = r;
					stackpos++;
				}
				r = j;
			} while(I < r);
		} while(stackpos > 0);
	}
	public static void outputArr(int []arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int randomNum(int minvalue, int maxvalue){
		Random rand = new Random();
		return rand.nextInt((maxvalue+1)-minvalue)+minvalue;
	}
}