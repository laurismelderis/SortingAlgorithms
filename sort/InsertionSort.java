package sort;

import javax.swing.JFrame;
import java.util.Random;

public class InsertionSort {
	private int [][] arrs;
	public InsertionSort(int[][] arrs){
		this.arrs = arrs;
	}
	public void result(){
    	int count = 0;
    	System.out.println("\nInsertion sort algorithm using " + arrs.length
    		+ " arrays: ");
    	for (int []arr: arrs){
    		System.out.println("\nArray ("+ arr.length +"): ");
			outputArr(arr);
			long t0 = System.nanoTime();
    		insertionSortM(arr);
    		long t1 = System.nanoTime();
    		System.out.println("Sorted: ");
    		outputArr(arr);
    		System.out.printf("Sorting time: %.9f seconds taken\n", (double)((t1-t0)/Math.pow(10, 9)));
    		count++;
    	}
    	
	}
	public static void insertionSortM(int[] a){
		int N = a.length;
		
		for (int i = 0; i < N; i++){
			int B = a[i];
			for (int j = 0; j < i+1; j++){
				if (B > a[j]){
					if (i == j){
						B = a[j];
					}
					continue;
				} else if (B == a[j]){
					B = a[j];
				} else {
					offsetRightArr(a, j, i);
					B = a[j];
					break;
				}
			}
		}
	}
	public static void outputArr(int[] a){
		for (int i: a){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void offsetRightArr(int[] a, int b, int c){
		int change = a[c];
		for (int i = c-1; i >= b; i--){
			a[i+1] = a[i];
		}
		a[b] = change;
	}
}
