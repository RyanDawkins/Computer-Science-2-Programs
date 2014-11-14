/**
 * This class has a abstract method evaluate to reuse the findRoots method using cosine as
 * it's f(x)
 *
 * @author Ryan Dawkins
 * @version 1.0
 * @since February 5, 2013
 */

public class CosFunc extends Function
{

	/**
	 * Implements parent class Function
	 * 
	 * @param double theta
	 * @return double x cosine value of the input
	 * @see Function#findRoot()
	 */
    public double evaluate(double theta)
    {
        return Math.cos(theta);
    }
}
