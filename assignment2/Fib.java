public class Fib
{

	public static int fibRecur(int n)
	{
		int fibNum = 0;
		
		if(n <= 2)
		{
			return 1;
		}
		else
		{
			fibNum = fibRecur(n - 1) + fibRecur(n - 2);
		}
		return fibNum;
		
	}
	
	public static long fibIter(int n)
	{
		long fib2 = 0;
        long fib1 = 1;
        long fibWanted = 0;
        int count = 1;

        do
        {
            fibWanted = fib1 + fib2;
            fib2 = fib1;
            fib1 = fibWanted;
            count++;
        } while(count < n);

		return fibWanted;
	}
	
}
