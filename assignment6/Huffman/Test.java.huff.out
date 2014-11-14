public class Test
{

	public static void main(String[] args)
	{
		Model m = new Model();
		byte[] fileBytes = m.getByteFile("Model.java");
		if(fileBytes != null)
		{
			m.runFrequency(fileBytes);
			Node[] nodeArr = m.mapToNodeArray();
			Node tree = m.getTree(nodeArr);
			goThrough(tree);
		}
		else
		{
			System.out.println("fileBytes is null");
		}
	}
	public static void goThrough(Node n)
	{
	}

}
