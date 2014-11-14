/**
 * River class to hold data about rivers
 *
 * @author Ryan Dawkins
 * @since 1.0
 * @extends Boundary
 */

import java.util.ArrayList;

public class River<T> extends Boundary
{

	private T t;
	private String name;
	private String type;

	public River()
	{
		this(null);
	}

	/**
	 * Constructor to set the country's name
	 *
	 * @param String name
	 */
	public River(String name)
	{
		this.setName(name);
	}

	/**
	 * Sets watertype of the river
	 *
	 * @param String type
	 * @return void
	 */
	public void setWaterType(String type)
	{
		this.type = type;
	}

	/**
	 * Gets the watertype
	 *
	 * @return String waterType
	 */
	public String waterType()
	{
		return this.type;
	}

	/**
	 * Returns name of the river
	 *
	 * @return String name
	 */
	public String name()
	{
		return this.name;
	}

	/**
	 * Sets the name of the river
	 *
	 * @param String riverName
	 * @return void
	 */
	public void setName(String riverName)
	{
		this.name = riverName;
	}

}