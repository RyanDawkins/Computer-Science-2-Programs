import java.util.Arrays;

public class Sorting
{

	private static long start;

	public static void main(String[] args)
	{
		int x = 1;
		boolean check = true;
		while(check)
 		{
			x = x * 10;
			double[] array1 = new double[x];
			for(int i = 0; i < array1.length; i++)
			{
				array1[i] = Math.random();
			}
			start = System.currentTimeMillis();
			bubbleSort(array1);
			System.out.println("\nBubble sort with computations "+x+" took: "+(System.currentTimeMillis()-start)+" milliseconds");
			for(int i = 0; i < array1.length; i++){ 
				System.out.print(array1[i]+" ");
			}
			double[] array2 = new double[x];
			for(int i = 0; i < array2.length; i++)
			{
				array2[i] = Math.random();
			}
			start = System.currentTimeMillis();
			double[] result = mergeSort(array2);
			System.out.println("\nMerge sort with computations "+x+" took: "+(System.currentTimeMillis()-start)+" milliseconds");
			for(int i = 0; i < result.length; i++){
				System.out.print(result[i]+" ");
			}
 		}
		
	}
	
	public static void bubbleSort(double[] arr)
	{
	
		for(int i = 0; i < arr.length; i++)
		{
			boolean swapped = true;
			while(swapped)
			{
				swapped = false;
				for(int j = arr.length-1; (i + 1) <= j; j--)
				{
					if(arr[j] < arr[j-1])
					{
						arr[j] = arr[j-1] + arr[j];
						arr[j-1] = arr[j] - arr[j-1];
						arr[j] = arr[j] - arr[j-1];
						swapped = true;
					}
					if((System.currentTimeMillis() - start) > 20000)
					{
						System.out.println("Error: Bubble sort Ran too long");
						System.exit(0);
					}
				}
			}
			if(swapped)
			{
				break;
			}
		}
	}
	
	public static double[] mergeSort(double[] arr)
	{
	
		if((System.currentTimeMillis() - start) > 20000)
		{
			System.out.println("Error: Merge Sort Ran too long");
			System.exit(0);
		}
	
		if(arr.length <= 1)
		{
			return arr;
		}
		int m = arr.length/2;
		double[] merged;
		double[] l = new double[m];
		double[] r = new double[arr.length-m];
		
		System.arraycopy(arr, 0, l, 0, m);
		System.arraycopy(arr, m, r, 0, arr.length-m);
		
		l = mergeSort(l);
		r = mergeSort(r);
		merged = merge(l, r);
		return merged; 
	}
	
	private static double[] merge(double[] l, double[] r)
	{
		double[] merged = new double[l.length + r.length];
		int lx = 0;
		int rx = 0;
		int i = 0;
		
		while((lx < l.length) || (rx < r.length))
		{
			if(lx < l.length && rx < r.length)
			{
				if(l[lx] > r[rx])
				{
					merged[i] = r[rx];
					rx++;
					i++;
				}
				else
				{
					merged[i] = l[lx];
					lx++;
					i++;
				}
			}
			else if(rx < r.length)
			{
				merged[i] = r[rx];
				rx++;
				i++;
			}
			else if(lx < l.length)
			{
				merged[i] = l[lx];
				lx++;
				i++;
			}
		}
		return merged;
	}
	
}