package sort;

import java.util.Random;

public class QuicksortRecursion {
	public static double time = 0;
	public static int[] sort (int []array){
		long t0 = System.nanoTime();
		quickSort(array, 0, array.length-1);
		long t1 = System.nanoTime();
		time = (double)((t1 - t0)/Math.pow(10, 9));
		return array;
	}
	public static void quickSort(int a[], int I, int r){
		int m = a[randomNumber(I, r)];
		int i = I;
		int j = r;
		int prev = 0;
		do {
			while (a[i] < m){
				i++;
			}
			while (a[j] > m){
				j--;
			}
			if (i <= j){
				prev = a[i];
				a[i] = a[j];
				a[j] = prev;
				i++;
				j--;
			}
		} while(i <= j);
		if (j > I) {
			quickSort(a, I, j);
		}
		if (r > i){
			quickSort(a, i, r);
		}
	}
	public static int randomNumber(int min, int max){
		Random rand = new Random();
		return rand.nextInt(max+1-min)+min;
	}
}