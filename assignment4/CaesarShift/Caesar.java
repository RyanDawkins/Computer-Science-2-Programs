:import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;

public class Caesar
{
	public static void main(String[] args)
	{
		if(args.length != 3)
		{
			System.out.println("ERROR: Not enough arguments, please try: ");
			System.out.println("java Caesar <input file> <outputfile>");
			System.exit(1);
		}

// 		if(args[0])

		int key = Integer.parseInt(args[0]);
		File in = new File(args[1]);
		File out = new File(args[2]);
		
		BufferedWriter fileWriter = null;
		
		try{
			fileWriter = new BufferedWriter(new FileWriter(out));
		}
		catch(IOException e){}
		 
		checkFiles(in, out, args[2]);
		
		String[] lines = fileToStringArray(in);
		String[] output = new String[lines.length];
		
		for(int i = 0; i < lies.length; i++)
		{
			output[i] = "";
			char[] letters = lines[i].toCharArray();
			for(int x = 0; x < letters.length; x++)
			{
				int intval = letters[x] + key;
				output[i] += ""+encrypt(intval);
			}
			try
			{
				fileWriter.write(output[i]+"\n");
			}
			catch(IOException e)
			{
				System.out.println("CANNOT WRITE TO FILE");
			}
		}
		try
		{
			fileWriter.close();
		}
		catch(IOException e)
		{
			System.out.println("ERROR: File permissions of output file is bad.");
		}
	}
	
	private static void checkFiles(File in, File out, String outFileString)
	{
		if(in.exists())
		{
			if(!in.canRead())
			{
				System.out.println("ERROR: Cannot read input file. Please change your" + " file permissions.");
				System.out.println("chmod <file> 777 if using linux.");
				System.exit(1);
			}
		}
		else
		{
			System.out.println("ERROR: Input file does not exist. Please make sure your"
				+ " command line usage is correct. Example: ");
			System.out.println("java Caesar <input file> <outputfile>");
			System.exit(1);
		}
		if(!out.exists())
		{
			try
			{
				out.createNewFile();
			}
			catch(IOException e)
			{
				System.out.println("ERROR: Cannot create new file "+outFileString
					+ " .\nCheck directory permissions.");
			}
		}
		if(!out.canWrite())
		{
				System.out.println("ERROR: Cannot write to file "+outFileString
					+" please change the Permissions of the file.\n"
					+"chmod <file> 777 if using linux.");
				System.exit(1);
		}
		
	}
	
	public static String[] fileToStringArray(File inFile)
	{
		int lineNum = countLines(inFile);
		String[] lines = new String[lineNum];
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(inFile));
			int count = 0;
			while((count < lineNum && (lines[count] = in.readLine()) != null)){count++;}
		}
		catch(IOException e){ System.out.println("ERROR: Cannot read file."); }
		return lines;
	}
	
	public static int countLines(File inFile)
	{
		int count = 0;
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(inFile));
			while(in.readLine() != null)
			{
				count++;
			}
		}
		catch(IOException e){ System.out.println("ERROR: Cannot read file.");}
		
		return count;
	}
	
	public static char encrypt(int intval)
	{
		char letter = (char)intval;
		if(32 < intval && intval < 126)
		{
			return letter;
		}
		else if(intval >= 126)
		{ 
			return letter = (char)(intval - 95);
		}
		else if(intval  < 32)
		{
			return letter = (char)(letter + 95); 
		}
		return letter;
	}
}