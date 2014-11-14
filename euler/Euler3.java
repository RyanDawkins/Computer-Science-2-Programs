public class Euler3
{
    public static void main(String[] args)
    {
        int i;
        long n = 600851475143l;

        for (i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                i--;
            }
        }
        System.out.println(i);
    }
}
