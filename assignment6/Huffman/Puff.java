import java.util.HashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Puff
{
	
	public static void main(String[] args)
	{

		Puff puff = null;
		String fileName = "";
		if(args.length == 1)
		{
			fileName = args[0];
			puff = new Puff(fileName);
		}
		else
		{
			System.out.println("ERROR: invalid options.");
			System.out.println("Try: java Puff <filename>");
			System.exit(1);
		}
		puff.storeBytes();
		puff.writeToFile(fileName);
	}

	private HashMap<Byte, Node> map;
	private List<Integer> list;
	private Node tree;
	private byte[] bytes;
	private String bitStr = "";
	private ArrayList<Byte> prod;

	public Puff(String fileName)
	{
		try
		{
			System.out.println(fileName);
			prod = new ArrayList<Byte>();
			File file = new File(fileName);
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
			Object obj1 = objIn.readObject();
			Object obj2 = objIn.readObject();
			Object obj3 = objIn.readObject();
			Object obj4 = objIn.readObject();
			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>)obj1;
			@SuppressWarnings("unchecked")
			HashMap<Byte, Node> map = (HashMap<Byte, Node>)obj2;
			@SuppressWarnings("unchecked")
			Integer num = (Integer)obj3;
			@SuppressWarnings("unchecked")
			Node tree = (Node)obj4;
			this.tree = tree;
			this.list = list;
			this.map = map;
			this.bytes = Twiddle.bitsToBytes(this.list);
			bitStr = new String(this.bytes, "UTF-8");
		}
		catch(IOException e)
		{ System.out.println("IOException"); e.printStackTrace(); }
		catch(Exception e){ System.out.println("Other"); }
	}
	public Node getTree()
	{
		return this.tree;
	}
	public String getBitStr()
	{
		return this.bitStr;
	}
	public void storeBytes()
	{
		int x = 0;
		while(x < bitStr.length())
		{
			x = decode(this.tree, bitStr, x);
		}
	}

	public void writeToFile(String fileName)
	{
		try
		{
			File outputFile = new File(fileName+".out");
			if(outputFile.exists())
			{
				outputFile.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(outputFile);

			Byte[] b = prod.toArray(new Byte[prod.size()]);
			byte[] output = new byte[b.length];
			for(int i = b.length-1; i > -1; i-- )
			{
				output[i] = b[b.length-i-1];
			}
			fo.write(output);
		}
		catch(IOException e)
		{

		}
	}

	public int decode(Node n, String s , int x)
	{
		//System.out.println(x);
		if(n.getZero() == null && n.getOne() == null)
		{
			prod.add(n.getVal());
			return x;
		}
		if(s.charAt(x) == '1')
		{
			return decode(n.getOne(), s, x+1);
		}
		else
		{
			return decode(n.getZero(), s, x+1);
		}
	}

}