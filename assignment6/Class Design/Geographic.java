/**
 * This is an interface that forces necessary methods
 *
 * @author Ryan Dawkins
 * @since 1.0
 */
public interface Geographic
{


	/**
	 * Necessary to get the neighbors
	 * 
	 * @return Object[] neighbors
	 */	
	public Object[] neighbors();
	
	/**
	 * Necessary to get the objects origin country
	 *
	 * @return String country name
	 */
	public String name();

}