import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList 
{

	// Moved the message that shows how to use the program into a single method, so it can be reused in different places
	public static void showUsage()
	{
		System.out.println("Incorrect parameters. Usage: java StudentList -a | -r | -c | +WORD | ?WORD");
	}

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
			System.out.println("Could not open file.");
		}
	}
	public static void main(String[] args) 
	{
		// Loads all files at the beginning of the program for reading/writing
		fileMethods();

		// Checks for arguments
		// If Arguments aren't given or more than one argument is given, it shows how to use the program and exits
		if(args == null || args.length != 1) 
		{
			showUsage();
			return; 
		}

		if (args[0].equals(Constants.SHOW_ALL)) 
		{
			System.out.println("Loading data ...");
			try 
			{	
				String readString = reader.readLine();
				// Splits the single string in the file into an array of strings according to the delimiter "," by default
				String words[] = readString.split(Constants.DELIMITER); 
				for (String word : words) 
				{
					System.out.println(word);
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Could not open file.");
			}

			System.out.println("Data Loaded.");

		} 
		
		else if (args[0].equals(Constants.SHOW_RANDOM)) 
		{
			System.out.println("Loading data ...");
			try 
			{				
				String readString = reader.readLine();
				// Splits the single string in the file into an array of strings according to the delimiter "," by default
				String words[] = readString.split(Constants.DELIMITER);
				// Generates random number to get a random output from the file
				Random randomGenerator = new Random();
				int random = randomGenerator.nextInt(3);
				System.out.println(words[random]);
			} 
			catch (Exception e) 
			{
				System.out.println("Could not open file.");
			}

			System.out.println("Data Loaded.");
		} 

		// This method adds a word given in the argument and adds a date to the file to show when the new word was added
		else if (args[0].contains(Constants.ADD_WORD)) 
		{
			System.out.println("Loading data ...");
			try 
			{	
				String subString = args[0].substring(1);
				
				Date date = new Date();
				//Formats the date into a proper style
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				
				writer.write(", " + subString + "\nList last updated on " + dateFormat.format(date));
				writer.close();
			} 
			catch (Exception e) 
			{
				System.out.println("Could not open file.");
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
		
				String query = args[0].substring(1);
				for (int index = 0; index < words.length; index++)
				{
					if (words[index].equals(query)) 
					{
						System.out.println(query+" was found at " +index);
						break;
					}

					else if(index == words.length)
					{
						System.out.println(query+" was not found ");
						break;
					}
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Could not open file.");
			}

			System.out.println("Data Loaded.");
		} 
		
		else if (args[0].contains(Constants.SHOW_COUNT)) 
		{
			System.out.println("Loading data ...");
			try 
			{				
				String storedString = reader.readLine();
				String[] splittedStrings = storedString.split(Constants.DELIMITER);

				System.out.println(splittedStrings.length + " word(s) found ");
			} 
			catch (Exception e) 
			{
				System.out.println("Could not open file.");
			}
			
			System.out.println("Data Loaded.");
		}

		// When no arguments are given, shows how to use the program
		else
		{
			showUsage();
		}

		return;
	}
}