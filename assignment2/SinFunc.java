/**
 * This class has a abstract method evaluate to reuse the findRoots method using sine as
 * it's f(x)
 *
 * @author Ryan Dawkins
 * @version 1.0
 * @since February 5, 2013
 */

public class SinFunc extends Function
{
	/**
	 * Implements from parent class Function and evaluates the input returning a the sine
	 * value for the given theta.
	 *
	 * @param double theta
	 * @return double sine of theta
	 * @see Function#findRoot()
	 */
    public double evaluate(double theta)
    {
        return Math.sin(theta);
    }
}
