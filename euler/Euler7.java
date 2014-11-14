public class Euler7
{

    public static void main(String[] args)
    {
	int count = 1;
	long num = 3;
	while(count < 10000)
	{
	    if(prime(num))
	    {
		count++;
		//	System.out.println(num);
	    }
	    num = num+1;
	}
	System.out.println(num-1);
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