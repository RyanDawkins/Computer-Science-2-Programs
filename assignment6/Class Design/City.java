/**
 * This class is used to store data about cities
 *
 * @author Ryan Dawkins
 * @since 1.0
 * @implements Geographic
 */

import java.util.ArrayList;

public class City implements Geographic
{	

	private ArrayList<City> neighbors;
	private String name;
	private int x;
	private int y;
	private State state;

	public City(State state)
	{
		this(state, null);
	}

	/**
	 * Constructor to set the name of the object
	 *
	 * @param String name
	 */
	public City(State state, String name)
	{
		this.setState(state);
		this.setName(name);
		this.neighbors = new ArrayList<City>();
	}

	/**
	 * Sets the name of the city.
	 *
	 * @param String name
	 * @return void
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets name of the city
	 *
	 * @return String name
	 */
	public String name()
	{
		return this.name;
	}

	/**
	 * Sets neighboring cities
	 *
	 * @param City obj
	 * @return void
	 */
	public void setNeighbor(City obj)
	{
		this.neighbors.add(obj);
	}

	/**
	 * Gets neighboring cities
	 *
	 * @return City[] neighbors
	 */
	public City[] neighbors()
	{
		return (City[])this.neighbors.toArray();
	}

	/**
	 * Sets x position on globe
	 *
	 * @param int x
	 * @return void
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Gets x position on globe
	 *
	 * @return int x
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Sets y position on globe
	 *
	 * @param int y
	 * @return void
	 */
	public void setY()
	{
		this.y = y;
	}

	/**
	 * Gets y position on globe
	 *
	 * @return int y
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Gets distance between two city objects
	 *
	 * @param City other
	 * @return void
	 */
	public int distance(City other)
	{
		int dx = other.getX();
		int dy = other.getY();
		int distance = 0;
		// Calculate
		return distance;
	}

	/**
	 * Gets country
	 *
	 * @return Country
	 */
	public Country getCountry()
	{
		return this.state.getCountry();
	}

	/**
	 * Sets state
	 *
	 * @param State state
	 * @return void
	 */
	public void setState(State state)
	{
		this.state = state;
		this.state.addCity(this);
	}
}