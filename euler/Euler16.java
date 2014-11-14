import java.math.BigInteger;

public class Euler16
{

    public static void main(String[] args)
    {
	BigInteger n = BigInteger.valueOf(2);
	n = n.pow(1000);
	String str = n.toString();
	int sum = 0;
	for(int i = 0; i < str.length(); i++)
	{
	    sum += Integer.parseInt(""+str.charAt(i));
	}
	System.out.println(sum);
    }

}