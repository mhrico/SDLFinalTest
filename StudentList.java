import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList 
{
	public static void main(String[] args) 
	{

		// Checks for arguments
		// Checks for number of arguments and terminates early if arg number is incorrect

		if(args == null || args.length != 1) 
		{
			System.out.println("Incorrect parameters. Usage: java StudentList a | r | c | +WORD | ?WORD");
			return; 
		}

		if (args[0].equals("a")) 
		{
			System.out.println("Loading data ...");
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				
				String readString = reader.readLine();
				String words[] = readString.split(",");
				for (String word : words) 
				{
					System.out.println(word);
				}
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");

		} 
		
		else if (args[0].equals("r")) 
		{
			System.out.println("Loading data ...");
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				
				String readString = reader.readLine();
				//System.out.println(r);
				String words[] = readString.split(",");
				
				Random randomGenerator = new Random();
				int random = randomGenerator.nextInt(3);
				System.out.println(words[random]);
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 

		else if (args[0].contains("+")) 
		{
			System.out.println("Loading data ...");
			try 
			{
				BufferedWriter reader = new BufferedWriter(new FileWriter("students.txt", true));
				
				String subString = args[0].substring(1);
				
				Date date = new Date();
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				String formattedDate = dateFormat.format(date);
				
				reader.write(", " + subString + "\nList last updated on " + formattedDate);
				reader.close();
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 
		
		else if (args[0].contains("?")) 
		{
			System.out.println("Loading data ...");
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				
				String readString = reader.readLine();
				String words[] = readString.split(",");
				
				boolean done = false;
				String t = args[0].substring(1);
				for (int idx = 0; idx < words.length && !done; idx++)
				{
					if (words[idx].equals(t)) 
					{
						System.out.println("We found it!");
						done = true;
					}
				}
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 
		
		else if (args[0].contains("c")) 
		{
			System.out.println("Loading data ...");
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				
				String storedString = reader.readLine();
				char characterArray[] = storedString.toCharArray();
				
				boolean in_word = false;
				
				int count = 0;
				for (char characters : characterArray) 
				{
					if (characters == ' ') 
					{
						if (!in_word) 
						{
							count++;
							in_word = true;
						} 
						
						else 
						{
							in_word = false;
						}
					}
				}

				System.out.println(count + " word(s) found " + characterArray.length);
			} 
			catch (Exception e) 
			{

			}
			
			System.out.println("Data Loaded.");
		}
	}
}