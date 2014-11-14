public class Euler4
{
    public static void main(String[] args)
    {
        int x = 999;
        int y = 999;
        String newPalin = "";
        int pal = 0;

        for(x = 999; 100 < x; y--)
        {
            newPalin = ""+(x * y);
            for(y = 999; 100 < y; y--)
            {
                if(newPalin.equals(new StringBuilder(newPalin).reverse().toString()))
                {
                    int palin = Integer.parseInt(newPalin);
                    pal = (palin > pal) ? palin : pal;
                }
            }
        }
        System.out.println(pal);
    }
}
