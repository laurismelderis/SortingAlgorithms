package sort;

import javax.swing.JFrame;
import java.util.Random;

public class InsertionSort {
	public static double time = 0;
	public static int[] sort(int[] a){
		long t0 = System.nanoTime();
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
		long t1 = System.nanoTime();
		time = (double)((t1 - t0)/Math.pow(10, 9));
		return a;
	}
	public static void offsetRightArr(int[] a, int b, int c){
		int change = a[c];
		for (int i = c-1; i >= b; i--){
			a[i+1] = a[i];
		}
		a[b] = change;
	}
}
