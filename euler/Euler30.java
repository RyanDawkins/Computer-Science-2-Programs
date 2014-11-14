public class Euler30
{

    public static void main(String[] args)
    {
	int sum = 0;
	for(int i = 2; i < 1000000; i++)
	{
	    String s = ""+i;
	    int x = 0;
	    for(int j = 0; j < s.length(); j++)
	    {
		x += (int)Math.pow(Integer.parseInt(""+s.charAt(j)), 5);
	    }
	    if(x == i)
	    {
		sum += x;
	    }
	}
	System.out.println(sum);
    }

}