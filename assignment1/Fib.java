public class Fib
{
    public static void main(String[] args)
    {
        double firstArg;
        firstArg = (args.length == 1) ? Integer.parseInt(args[0]) : -1;
        if(firstArg == -1) System.exit(0);

        long fib2 = 0;
        long fib1 = 1;
        long fibWanted = 0;
        int count = 1;

        do
        {
            fibWanted = fib1 + fib2;
            fib2 = fib1;
            fib1 = fibWanted;
            count++;
        } while(count < firstArg);

        System.out.println(fibWanted);
    }
}
