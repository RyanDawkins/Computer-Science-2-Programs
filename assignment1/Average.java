import java.util.Scanner;

public class Average
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        boolean sentinal = scan.hasNextInt();

        while(sentinal)
        {
            int readIn = scan.nextInt();
            if(readIn < 0)
            {
                sentinal = false;
                continue;
            }

            sum = sum + readIn;
            count++;
        }

        System.out.println(getAverage(sum, count));
    }

    private static double  getAverage(int sum, int count)
    {
        double average;
        average = (double) sum / count;
        return average;
    }

}
