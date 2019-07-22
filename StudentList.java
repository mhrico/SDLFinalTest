import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList 
{

	//Declaring reader and writer outside of methods and making public, so they can be accessed from all methods
	static BufferedReader reader;
	static BufferedWriter writer;

	// Putting all duplicate read/write logic into one method
	public static void fileMethods()
	{
		try 
		{
			 reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			 writer = new BufferedWriter(new FileWriter("students.txt", true));
		}

		catch(Exception e)
		{

		}
	}
	public static void main(String[] args) 
	{
		//Loads all the files for reading/writing
		fileMethods();

		// Checks for arguments
		// Checks for number of arguments and terminates early if arg number is incorrect

		if(args == null || args.length != 1) 
		{
			System.out.println("Incorrect parameters. Usage: java StudentList -a | -r | -c | +WORD | ?WORD");
			return; 
		}

		if (args[0].equals(Constants.SHOW_ALL)) 
		{
			System.out.println("Loading data ...");
			try 
			{	
				String readString = reader.readLine();
				String words[] = readString.split(Constants.DELIMITER);
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
		
		else if (args[0].equals(Constants.SHOW_RANDOM)) 
		{
			System.out.println("Loading data ...");
			try 
			{				
				String readString = reader.readLine();
				//System.out.println(r);
				String words[] = readString.split(Constants.DELIMITER);
				
				Random randomGenerator = new Random();
				int random = randomGenerator.nextInt(3);
				System.out.println(words[random]);
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 

		else if (args[0].contains(Constants.ADD_WORD)) 
		{
			System.out.println("Loading data ...");
			try 
			{	
				String subString = args[0].substring(1);
				
				Date date = new Date();
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				
				writer.write(", " + subString + "\nList last updated on " + dateFormat.format(date));
				writer.close();
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 
		
		else if (args[0].contains(Constants.SEARCH_WORD)) 
		{
			System.out.println("Loading data ...");
			try 
			{				
				String readString = reader.readLine();
				String words[] = readString.split(Constants.DELIMITER);
				
				//boolean done = false;
				String query = args[0].substring(1);
				for (int idx = 0; idx < words.length; idx++)
				{
					if (words[idx].equals(query)) 
					{
						System.out.println(query+" was found at " +idx);
						break;
						//done = true;
					}

					else if(idx == words.length)
					{
						System.out.println(query+" was not found ");
						break;
					}
				}
			} 
			catch (Exception e) 
			{

			}

			System.out.println("Data Loaded.");
		} 
		
		else if (args[0].contains(Constants.SHOW_COUNT)) 
		{
			System.out.println("Loading data ...");
			try 
			{				
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

				System.out.println(count + " word(s) found ");
			} 
			catch (Exception e) 
			{

			}
			
			System.out.println("Data Loaded.");
		}
	}
}