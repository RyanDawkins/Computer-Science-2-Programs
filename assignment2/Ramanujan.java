import java.math.BigDecimal;

public class Ramanujan
{

    private static double PI = Math.PI;
    private static double CONSTANT = (2 * Math.pow(2, .5)) / 9801;

    public static void main(String[] args)
    {
        // Ensures only 1 argument recieved
        if(!(args.length == 1))
        {
            System.out.println("ERROR: Usage java Ramanujan <n>");
            System.exit(1);
        }

        double i = Integer.parseInt(args[0]);
        double answer = 0;

        for(int k = 0; k < i; k++)
        {
            double x = Factorial.calculate(4 * k);
            double y = (1103 + (26390 * k));

            double a = Math.pow(Factorial.calculate(k), 4);
            double b = Math.pow(396, (4 * k));


            answer = answer + ((x * y) / (a * b));
            System.out.println("Series: " + answer);
        }

        answer = CONSTANT * answer;
        answer = 1 / answer;

        System.out.println(CONSTANT);
        System.out.println(Factorial.calculate(3));

        System.out.println(answer);

    }
}
