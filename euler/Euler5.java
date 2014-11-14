public class Euler5
{
    public static void main(String[] args)
    {
        int n = 2520;
        int x = 2520;
        boolean isFinished = false;

        while(!isFinished)
        {
            for(int i = 11; i <= 20; i++)
            {
                if((n % i) > 0)
                {
                    n += x;
                    break;
                }
                if(i == 20) isFinished = true;
            }
        }

        System.out.println(n);
    }
}
