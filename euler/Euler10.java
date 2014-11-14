public class Euler10
{

    public static void main(String[] args)
    {
	
	long sum = 0;
	for(int i = 1; i < 2000000; i+=2)
	{
	    //System.out.println(i);
	    if(prime(i)){ sum += i; }
	}
	System.out.println(sum);
    }

    public static boolean prime(long num)
    {
	if(num % 2 == 0 || num % 3 == 0)
	{
		return false;
	}
	for(int i = 3; i < Math.sqrt(num)+1; i++)
	{
		if(num % i == 0) return false;
	}
	return true;
    }
}