public class euler2
{

    private static final int SENT = 4000000;

    public static void main(String[] args)
    {
        int current = 0;
        int back1 = 1;
        int back2 = 1;
        int sum = 0;

        while( current < SENT )
        {
            current = back1 + back2;
            back2 = back1;
            back1 = current;
            sum = (back2 % 2 == 0) ? sum + back2 : sum;
            System.out.println(back2);
        }
        System.out.println("The sum is: " + sum);
    }
}
