import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Model
{

	private int numOfNodes;
	private HashMap<Byte, Integer> map;
	private HashMap<Byte, Node> keyMap;
	private Node[] nodeArrayTree;

	public byte[] getByteFile(String fileName)
	{

		File file = new File(fileName);
		byte[] fileBytes = null;

		if(file.exists())
		{
			try
			{
				FileInputStream stream = new FileInputStream(file);
				fileBytes = new byte[stream.available()];
				stream.read(fileBytes);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			return null;
		}

		return fileBytes;

	}

	public HashMap<Byte,Node> getKeyMap()
	{
		return this.keyMap;
	}

	public Node getTree(Node[] arr)
	{
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0; i < arr.length; i++)
		{
			pq.add(arr[i]);
		}
		this.nodeArrayTree = arr;
		return createTree(pq);
	}

	public void getMap()
	{
		//PriorityQueue<Node> pq = new PriorityQueue<Node>();
		//for(int i = 0; i < arr.length; i++)
		//{
		//	pq.add(this.nodeArrayTree[i]);
		//}
	}

	public Node createTree(PriorityQueue<Node> pq)
	{

		while(pq.size() > 1)
		{
			Node n = new Node();

			Node a = pq.poll();
			if(pq.size() > 0)
			{
				Node b = pq.poll();
				n = new Node(a.getFrequency() + b.getFrequency());
				n.setZero(a);
				a.setWhich(0);
				a.setParent(n);
				n.setOne(b);
				b.setWhich(1);
				b.setParent(n);
			}
			else
			{
				n = new Node(a.getFrequency());
				n.setZero(a);
				a.setWhich(0);
				n.setParent(n);
				n.setOne(null);
			}
			pq.add(n);
		}
		Node n = pq.poll();
		n.setParent(null);
		setParents(n);
		return n;
	}

	public void setParents(Node n)
	{
		if (n.getZero() != null) {
        	n.getZero().setParent(n);
        	setParents(n.getZero());
    }
    	if (n.getOne() != null) {
        	n.getZero().setParent(n);
        	setParents(n.getOne());
    	}
	}

	private void swap(Node[] arr, int a, int b)
	{
		Node temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void runFrequency(byte[] fileBytes)
	{

		numOfNodes = 0;
		map = new HashMap<Byte, Integer>();

		for(int i = 0; i < fileBytes.length; i++)
		{
			if(map.get(fileBytes[i]) == null)
			{
				map.put(fileBytes[i], 1);
			}
			else
			{
				map.put(fileBytes[i], map.get(fileBytes[i])+1);
			}
		}
	}

	public Node[] mapToNodeArray()
	{
		int size = map.size();
		//System.out.println(size);
		keyMap = new HashMap<Byte, Node>();
		Node[] nodeArr = new Node[size];
		int i = 0;
		for(byte key : map.keySet())
		{
			nodeArr[i] = new Node(map.get(key), key);
			keyMap.put(key, nodeArr[i]);
			if((2*i+2) < size)
			{
				//nodeArr[i].setZero(nodeArr[2*i + 1]);
				//nodeArr[i].setOne(nodeArr[2*i + 2]);
			}
			if(i == 0)
			{
				//nodeArr[i].setParent(null);
			}
			else
			{
				//nodeArr[i].setParent(nodeArr[i - 1 / 2]);
			}
			i++;
		}
		return nodeArr;
	}

	public void printMap()
	{
		int count = 0;
		for(byte key : map.keySet())
		{
			System.out.println("Count: "+count+" Key: "+key+" Value: "+map.get(key));
			count++;
		}
	}

}