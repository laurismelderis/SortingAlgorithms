package sort;

public class SelectionSort{
	public static double time = 0;
	public static int[] sort(int []array){
		long t0 = System.nanoTime();
		for(int i = array.length - 1; i > 0; i--){
			int first = 0;
			for(int j = 1; j <= i; j++){
				if(array[j] < array[first])
					first = j;
			}
			int temp = array[first];
			array[first] = array[i];
			array[i] = temp;
		}
		long t1 = System.nanoTime();
		time = (double)((t1 - t0)/Math.pow(10, 9));
		return array;
	}
}