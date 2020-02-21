package sort;

import java.util.Random;
import java.util.Scanner;

public class Quicksort {
	public static double time = 0;
	public static int[] sort(int[] a){
		long t0 = System.nanoTime();
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
		long t1 = System.nanoTime();
		time = (double)((t1 - t0)/Math.pow(10, 9));
		return a;
	}
	public static int randomNum(int minvalue, int maxvalue){
		Random rand = new Random();
		return rand.nextInt((maxvalue+1)-minvalue)+minvalue;
	}
}