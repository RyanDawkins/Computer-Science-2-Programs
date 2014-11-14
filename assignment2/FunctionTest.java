public class FunctionTest extends Function
{

    private static double EPSILON = 0.00000001;

    /**
     * This is the main function to test the class
     */
    public static void main(String[] args)
    {
        FunctionTest t = new FunctionTest();
        System.out.println(t.findRoot(3, 4));
    }

	/**
	 * This function finds roots using divide iteration by recursion.
	 * 
	 * @param double a, b (bounds to find roots)
	 * @return double of the evaluated roots based on the function in evaluate
	 */
	@Override
    public double findRoot(double a, double b)
    {
        double x = (a + b) / 2;
        if(Math.abs(a - x) < EPSILON)
        {
            return x;
        }
        else if((this.evaluate(x) < 0 && this.evaluate(a) < 0)
            || (this.evaluate(x) > 0 && this.evaluate(a) > 0))
        {
            return findRoot(x, b);
        }
        else
        {
            return findRoot(a, x);
        }
    }
    
    /**
     * Implemented because of the super class Function. This function evaluates based on
     * the sin value of the input.
     * 
     * @param double theta
     * @return double sine of theta
     */
    public double evaluate(double theta)
    {
        return Math.sin(x);
    }
}
