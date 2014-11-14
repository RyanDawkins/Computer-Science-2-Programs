import java.io.Serializable;

public class Node implements Comparable<Node>, Serializable
{
	private Node parent;
	private Node zero;
	private Node one;
	private int frequency;
	private byte val;
	private int which;

	public Node()
	{
		
	}

	public Node(int frequency)
	{
		this.frequency = frequency;
	}

	public Node(int frequency, byte val)
	{
		this.frequency = frequency;
		this.val = val;
	}

	public void setWhich(int which)
	{
		this.which = which;
	}

	public int getWhich()
	{
		return this.which;
	}

	public void setZero(Node zero)
	{
		this.zero = zero;
	}
	public void setOne(Node one)
	{
		this.one = one;
	}
	public void setParent(Node parent)
	{
		this.parent = parent;
	}

	public Node getParent()
	{
		return this.parent;
	}

	public Node getZero()
	{
		return this.zero;
	}

	public Node getOne()
	{
		return this.one;
	}

	public int getFrequency()
	{
		return this.frequency;
	}

	public byte getVal()
	{
		return this.val;
	}

	public int compareTo(Node n)
	{
		if(n.getFrequency() == this.getFrequency())
		{
			return 0;
		}
		else if(n.getFrequency() < this.getFrequency())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

}