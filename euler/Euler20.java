import java.math.BigInteger;

public class Euler20
{
    public static void main(String[] args)
    {
	String str = factorial(100);
	int sum = 0;
	for(int i = 0; i < str.length(); i++)
	{
	    sum += Integer.parseInt(""+str.charAt(i));
	}
	System.out.println(sum);
    }

    public static String factorial(int n)
    {
	BigInteger x = BigInteger.ONE;
	for(int i = 1; i <= n; i++)
	{
	    x = x.multiply(BigInteger.valueOf(i));
	}
	return x.toString();
    }

}