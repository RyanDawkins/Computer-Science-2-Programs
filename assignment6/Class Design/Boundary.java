/**
 * This class Boundary is a class to store data about borders.
 *
 * @author Ryan Dawkins
 * @since 1.0
 */

import java.util.ArrayList;

public class Boundary
{

	private ArrayList<Object> neighbors;
	private int length;

	public Boundary()
	{
		this.neighbors = new ArrayList<Object>();
	}

	/**
	 * Sets border neighbor of the boundary
	 *
	 * @param Object obj
	 * @return void
	 */
	public void setBorderPair(Object obj1, Object obj2)
	{
		this.neighbors.add(obj1);
		this.neighbors.add(obj2);
	}

	/**
	 * Gets surrounding objects of the boundary.
	 *
	 * @return Object[] neighbors
	 */
	public ArrayList<Object> borderOf()
	{
		return this.neighbors;
	}

	/**
	 * Sets boundary length
	 *
	 * @param int length
	 * @return void
	 */
	public void setBoundaryLength(int length)
	{
		this.length = length;
	}

	/**
	 * Gets the boundary lenght
	 *
	 * @return int length
	 */
	public int boundaryLength()
	{
		return this.length;
	}

}