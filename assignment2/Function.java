/**
 * This class uses abstract methods and is the main framework for the findRoot methods and
 * is primarily used to put the root finding at a different level.
 *
 * @author Ryan Dawkins
 * @version 1.0
 * @since February 5, 2013
 */

public abstract class Function
{

	private static double EPSILON = 0.00000001;

	/**
	 * Used simply to test objects of the function class.
	 */
    public static void main(String[] args)
    {
        SinFunc sf1 = new SinFunc();
        CosFunc cf1 = new CosFunc();
        
        // Sine Junk
        System.out.println("\nSine Business");
        System.out.println(sf1.findRoot(1, 5));
        System.out.println(sf1.findRoot(3, 4));
        
        // Cosine Junk
        System.out.println("\nCosine Business");
        System.out.println(cf1.findRoot(1, 5));
        System.out.println(cf1.findRoot(3, 4));
        
        // Poly Junk
        
        int[] pfarr1 = {-3, 0, 1};
        int[] pfarr2 = {-2, -1, 1};

 		PolyFunc pf1 = new PolyFunc(pfarr1);
 		PolyFunc pf2 = new PolyFunc(pfarr2);
        
        System.out.println("\nPoly Business");
        System.out.println(pf1.findRoot(0, 3));
        System.out.println(pf2.findRoot(0, 2));
    }

    public abstract double evaluate(double x);

	/**
	 * This function finds roots using divide iteration by recursion.
	 * @param double x
	 * @return double x
	 */
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

}
