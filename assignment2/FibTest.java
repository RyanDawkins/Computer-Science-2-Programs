public class FibTest
{

	public static void main(String[] args)
	{
	
		long startTime;
		long test1End;
		long test2End;
		
		long fib1;
		long fib2;
		
		startTime = System.currentTimeMillis();
		fib1 = Fib.fibRecur(40);
		test1End = System.currentTimeMillis();
		fib2 = Fib.fibIter(40);
		test2End = System.currentTimeMillis();
		
		System.out.println("Fib.fibRecur(40) returned " + fib1
			+ " timed at: " + (test1End - startTime));
		System.out.println("Fib.Iter(40) returned " + fib2 
			+ " timed at: " + (test2End - test1End));
	
	}
	
}
