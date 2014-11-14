public class Euler6
{
    public static void main(String[] args)
    {
        long msum = 0;
        long asum = 0;

        for(int i = 1; i <= 100; i++)
        {
            asum += Math.pow(i, 2);
            msum += i;
        }
        System.out.println((msum * msum) - asum);
    }
}
