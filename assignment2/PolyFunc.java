/**
 * The purpose of this class is to evaluate the bounds and find the roots using functions
 * by a given parameter
 *
 * @author Ryan Dawkins
 * @version 1.0
 * @since February 5, 2013
 */

public class PolyFunc extends Function
{

    private int[] coeffecients;
    
    /**
     * Constructer for the PolyFunc class and sets the integer array
     *
     * @param int[] coeffecients
     */
    public PolyFunc(int[] coeffecients)
    {
        this.coeffecients = coeffecients;
    }

	/**
	 * Returns the highest degree of the given array
	 *
	 * @param none
	 * @return int coeffecients.length-1
	 */
    public int degree()
    {
        return (this.coeffecients.length - 1);
    }

	/**
	 * Returns a string representation of the array of coefficients.
	 *
	 * @param none
	 * @return String polyString
	 */
    public String toString()
    {
        String polyString = "";

        for(int i = 0; i < coeffecients.length; i++)
        {
            if(coeffecients[i] == 0) continue;
            else if(i == coeffecients.length -1 && coeffecients[i] > 0)
            {
                polyString = ""+coeffecients[i]+"x^"+i+polyString;
            }
            else if(coeffecients[i] < 0)
            {
                polyString = ""+coeffecients[i]+"x^"+i+polyString;
            }
            else if(i == 0)
            {
                polyString = "+"+coeffecients[i]+polyString;
            }
            else if(i > 0)
            {
                polyString = "+"+coeffecients[i]+"x^"+i+polyString;
            }
        }
        return polyString;
    }

	/**
	 * Handles new given integer array and adds it to the original array taken. Returning
	 * a new object with the new array stored.
	 *
	 * @param int[] a
	 * @return obj PolyFunc
	 * @see PolyFunc(int[])
	 */
    public PolyFunc add(int[] a)
    {
        int[] newCoe = new int[this.coeffecients.length];

        // Handles expressions where there are less values in a
        // then there are in the original
        if(a.length < this.coeffecients.length)
        {
            for(int i = 0; i < a.length; i++)
            {
                newCoe[i] = this.coeffecients[i] + a[i];
            }
            for(int i = (a.length - 1); i < this.coeffecients.length; i++)
            {
                newCoe[i] = this.coeffecients[i];
            }
        }
        // Handles expressions where they are equal length
        else if(a.length == this.coeffecients.length)
        {
            for(int i = 0; i < a.length; i++)
            {
                newCoe[i] = this.coeffecients[i] + a[i];
            }
        }
        // Handles expression where there are more polynomials
        // than originally input'd
        else
        {
            for(int i = 0; i < this.coeffecients.length; i++)
            {
                newCoe[i] = this.coeffecients[i] + a[i];
            }
            for(int i = (this.coeffecients.length - 1); i < a.length; i++)
            {
                newCoe[i] = a[i];
            }
        }
        return new PolyFunc(newCoe);
    }

    /**
     * This evaluates a given integer array in the constructor which parsed to a function
     * and finds the roots in the given bounds.
     *
     * @param double x
     * @return double answer
     * @see Function#findRoot()
     * @see PolyFunc#PolyFunc(int[] coeffecients)
     */ 
    public double evaluate(double x)
    {
        double answer = 0;

        for(int i = 0; i < coeffecients.length; i++)
        {
            answer = answer + (coeffecients[i] * Math.pow(x, i));
        }
        return answer;
    }

}
