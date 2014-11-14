import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Permutations<E>
{
	private E e;
	private boolean hasNext;
	private Object[] combinations;
	private ArrayList<E> list;
	private int count;
	private int spot;

	public static void main(String[] args)
	{

		ArrayList<Integer> al = new ArrayList<Integer>();

		for(int i = 0; i < 10; i++)
		{
			al.add(i, i);
		}

		Permutations<Integer> perm = new Permutations<Integer>(al);
		
		while(perm.hasNext())
		{
			System.out.println(perm.next());
		}

	}

	public Permutations(ArrayList<E> list)
	{
		this.list = list;
		count = 0;
		spot = 0;
		combinations = new Object[this.factorial(list.size())];
		for(int i = 0; i < combinations.length; i++)
		{
			@SuppressWarnings("unchecked")
			ArrayList<E> temp = new ArrayList<E>();
			for(int j = 0; j < list.size(); j++)
			{
				temp.add(j, null);
			}
			combinations[i] = temp;
		}
		combinations(list, 0);
	}

	private void combinations(ArrayList<E> vals, int k)
	{

		for(int i = k; i < vals.size(); i++)
		{
			Collections.swap(vals, i, k);
			combinations(vals, k+1);
			Collections.swap(vals, k, i);
		}
		if(k == vals.size()-1)
		{
			combinations[this.count] = new ArrayList<E>(vals);
			//System.out.println(combinations[this.count].toString());
			count++;
		}

	}

	public boolean hasNext()
	{
		if(combinations.length > this.spot)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public ArrayList<E> next()
	{
		if(this.hasNext())
		{
			@SuppressWarnings("unchecked")
			ArrayList<E> temp = (ArrayList<E>)combinations[this.spot];
			this.spot++;
			return temp;
		}
		else
		{
			return null;
		}
	}

	private int factorial(int num)
	{
		if(num == 1)
		{
			return num;
		}
		return num * factorial(num-1);
	}

}
