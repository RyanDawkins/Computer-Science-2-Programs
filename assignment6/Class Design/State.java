/**
 * Class to store data about States
 *
 * @author Ryan Dawkins
 * @since 1.0
 * @extends Country
 */

import java.util.ArrayList;

public class State extends Country
{

	private City capital;
	private ArrayList<State> neighbors;
	private Country country;
	private ArrayList<City> cities;

	public State(Country country)
	{
		this(country, null);
	}

	/**
	 * Constructor to set the name of the object
	 *
	 * @param String name
	 */
	public State(Country country, String name)
	{
		cities = new ArrayList<City>();
		neighbors = new ArrayList<State>();
		this.setName(name);
		this.setCountry(country);
	}

	/**
	 * Sets capital for the State
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
	 * Sets neighboring states
	 *
	 * @param State neighbor
	 * @return void
	 */
	public void setNeighbor(State neighbor)
	{
		this.neighbors.add(neighbor);
	}

	/**
	 * Gets neighboring states 
	 *
	 * @return State[] neighbors
	 */
	public State[] neighbors()
	{
		return (State[])this.neighbors.toArray();
	}

	public void setCountry(Country country)
	{
		this.country = country;
		this.country.addState(this);
	}

	/**
	 * Gets country
	 *
	 * @return Country country
	 */
	public Country getCountry()
	{
		return this.country;
	}

	/**
	 * Adds to collection of cities
	 *
	 * @param City city
	 * @return void
	 */
	public void addCity(City city)
	{
		this.cities.add(city);
	}

	public City[] getCities()
	{
		return this.cities.toArray(new City[this.cities.size()]);
	}

}