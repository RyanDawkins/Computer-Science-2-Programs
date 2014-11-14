public class Poly
{

    private int[] coeffecients;

	/**
	 * Main method to structure testing for the Poly class
	 */
    public static void main(String[] args)
    {
        int[] test1 = {4, 0, -8, 0, 3, 2};
        Poly ptest1 = new Poly(test1);
        int[] test2 = {1, 1, 1, 1, 1, 1};
        
        System.out.println(ptest1.degree() == 5);
        System.out.println(ptest1.toString().equals("2x^5+3x^4-8x^2+4"));
        System.out.println(ptest1.evaluate(2) == 84);
        System.out.println(
        ptest1.add(test2).toString().equals("3x^5+4x^4+1x^3-7x^2+1x^1+5"));

    }

	/**
	 * Returns the highest degree of the given array
	 *
	 * @param none
	 * @return int coeffecients.length-1
	 */
    public Poly(int[] coeffecients)
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
	 * @return obj Poly
	 * @see Poly(int[])
	 */
    public Poly add(int[] a)
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
        return new Poly(newCoe);
    }

	/**
     * This evaluates a given integer array in the constructor which parsed to a function
     * and finds the roots in the given bounds.
     *
     * @param double x
     * @return double answer
     * @see Poly#Poly(int[] coeffecients)
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
