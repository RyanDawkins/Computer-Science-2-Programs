import java.util.Scanner;

public class Gregory
{
    public static void main(String[] args)
    {
        // My exgirlfriends names
        double nina;
        double cassidy = 0;

        if(args.length == 1)
        {
            try
            {
                cassidy = Double.parseDouble(args[0]);
            } catch(NumberFormatException e)
            {
                System.out.println("Error the number input'd is not an integer.");
                System.out.println("Debug: " + e);
                System.exit(0);
            }

        }
        else
        {
            System.out.println("Error: The input must be one and only one integer");    
            System.exit(0);
        }

        // Does math
        nina = alex(cassidy);

        System.out.println("Pi according to Gregory series: " + (nina * 4) );
        System.out.println("This differs from Java's value by " + (100 - (((nina * 4) / Math.PI) * 100)) + " perecent.");

    }

    /**
     * This function alex helps me with math like in highschool
     * @param double input
     * @return double kenzie
     */
    public static double alex(double input)
    {

        double kenzie = 0;

        for(int k = 1; k <= input; k++)
        {
            double x = (Math.pow(-1, (k + 1))) / ((2 * k) - 1);
            kenzie = kenzie + x;
        }

        return kenzie;
    }
}
