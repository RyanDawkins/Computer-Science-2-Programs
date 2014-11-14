import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.io.BufferedWriter;
import java.util.List;

public class Huff
{
	public static void main(String[] args)
	{
		Huff huff = null;
		String fileName = "";
		if(args.length == 1)
		{
			fileName = args[0];
			huff = new Huff(fileName);
		}
		else
		{
			System.out.println("ERROR: invalid options.");
			System.out.println("Try: java Huff <filename>");
			System.exit(1);
		}
		huff.encodeFile(fileName);
	}

	private Node tree;
	private byte[] fileBytes;
	private Model model;

	public Huff(String fileName)
	{

		model = new Model();
		fileBytes = model.getByteFile(fileName);
		if(fileBytes != null)
		{
			model.runFrequency(fileBytes);
			Node[] nodeArr = model.mapToNodeArray();
			this.tree = model.getTree(nodeArr);
		}
		else
		{
			System.out.println("ERROR: File returned null bytes.");
			System.exit(1);
		}
	}

	public void encodeFile(String fileName)
	{
		HashMap<Byte,Node> map = model.getKeyMap();
		String bitStr = "";
		for(int i = 0; i < this.fileBytes.length; i++)
		{
			Node n = map.get(fileBytes[i]);
			bitStr = this.traverse(n, "") + bitStr;
		}
		int count = 0;
		while(bitStr.length() % 8 != 0)
		{
			bitStr = bitStr + 0;
			count++;
		}
		byte[] raw = bitStr.getBytes();
		List<Integer> strBytes = Twiddle.bytesToBits(raw);
		try
		{
			File outputFile = new File(fileName+".huff");
			if(outputFile.exists())
			{
				outputFile.createNewFile();
			}
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(outputFile));
			objOut.write("".getBytes());
			objOut.flush();
			objOut.writeObject(strBytes);
			objOut.writeObject(map);
			objOut.writeObject(new Integer(count));
			objOut.writeObject(this.tree);
			objOut.flush();
			objOut.close();

		}
		catch(IOException e)
		{}
	}

	public String traverse(Node n, String s)
	{
		if(n.getParent() == null)
		{
			return s;
		}
		else if(n.getWhich() == 1)
		{
			s = ""+1+s;
			return traverse(n.getParent(),s);
		}
		else if(n.getWhich() == 0)
		{
			s = ""+0+s;
			return traverse(n.getParent(), s);
		}
		else
		{
			return s;
		}
	}

}