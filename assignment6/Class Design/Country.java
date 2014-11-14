/**
 * This class stores data about Country's
 *
 * @author Ryan Dawkins
 * @since 1.0
 * @implements Geographic
 */

import java.util.ArrayList;

public class Country implements Geographic
{
	
	private int area;
	private ArrayList<Country> neighbors;
	private String country;
	private City capital;
	private ArrayList<State> states;

	public Country()
	{
		this(null);
	}

	/**
	 * Default constructor that takes country's name and
	 * stores.
	 *
	 * @param String name
	 */
	public Country(String country)
	{
		this.setName(country);
		states = new ArrayList<State>();
	}

	/**
	 * Sets capital for the Country
	 *
	 * @param City capital
	 * @return void
	 */
	public void setCapital(City capital)
	{
		this.capital = capital;
	}

	/**
	 * Returns capital
	 *
	 * @return City capital
	 */
	public City capital()
	{
		return this.capital;
	}

	/**
	 * Sets area for the country
	 *
	 * @param int area
	 * @return void
	 */
	public void setArea(int area)
	{
		this.area = area;
	}

	/**
	 * Gets area of the country
	 *
	 * @return int area
	 */
	public int area()
	{
		return this.area;
	}

	/**
	 * Adds the neighbor to the neighbors array
	 *
	 * @param Country obj
	 * @return void
	 */
	public void setNeighbor(Country obj)
	{
		this.neighbors.add(obj);
	}

	/**
	 * Gets the neighbor array.
	 *
	 * @return Country[] neighbors
	 */
	public Country[] neighbors()
	{
		return (Country[])this.neighbors.toArray();
	}

	/**
	 * Sets name of the country
	 *
	 * @param String countryName
	 * @return void
	 */
	public void setName(String countryName)
	{
		this.country = countryName;
	}

	/**
	 * Gets country name
	 *
	 * @return void
	 */
	public String name()
	{
		return this.country;
	}

	/**
	 * Adds to collection of states.
	 *
	 * @param State state
	 * @return void
	 */
	public void addState(State state)
	{
		this.states.add(state);
	}

	public State[] getStates()
	{
		return this.states.toArray(new State[this.states.size()]);
	}

}