public class Factorial
{

	public static void main(String[] args)
	{
	
		// Storage for expected
		final int TEST_1_EXPECTED = 1;
		final int TEST_2_EXPECTED = 120;
		
		// Storage for input
		final int TEST_1_INPUT = 0;
		final int TEST_2_INPUT = 5;
		
		// Storage for output
		int test1Out = 0;
		int test2Out = 0;
		
		test1Out = calculate(TEST_1_INPUT);
		test2Out = calculate(TEST_2_INPUT);
		
		if(test1Out == TEST_1_EXPECTED)
		{
			System.out.println("Factorial.calculate(0) returned " + test1Out
				+ ".  Test passed!");
		}
		else
		{
			System.out.println("Factorial.calculate(0) returned " + test1Out
				+ ".   Test failed!");
		}
		if(test2Out == TEST_2_EXPECTED)
		{
			System.out.println("Factorial.calculate(0) returned " + test2Out
				+ ".  Test passed!");
		}
		else
		{
			System.out.println("Factorial.calculate(0) returned " + test2Out
				+ ".   Test failed!");
		}
		
	
	}

	public static int calculate(int n)
	{
		int factorial = 0;
		
		if(n <= 1)
		{
			return 1;
		}
		else
		{
			factorial = n * calculate(n - 1);
		}
		return factorial;
	
	}

}