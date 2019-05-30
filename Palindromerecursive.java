/*=================================================================================

Name:          Brandon Mota

The program creates a palindrome using the input from a user

=================================================================================*/
import java.util.*;
import java.io.*;

public class Palindromerecursive
{
	
static String input;

	public static void main(String[] args) //will control the flow of the program and give details
	{
		Scanner check = new Scanner(System.in);
		String checkin = null;
		
		System.out.println("This program will create palindromes.");
		System.out.println("You can enter in as many strings, and lines, as you wish.");
		System.out.println("To stop the program from reading your inputs and create the palindrome(s), type in 'create'");
		System.out.println("Please enter in strings that you would like to create palindromes."); //inputs will be displayed after this
				
		do
		{
		userinput(); //calls 'userinput' method
		reader(); //calls the 'reader' method
		System.out.print("\nWould you like to create more palindromes? ('y' or 'n') -----> ");		
		checkin = check.nextLine();
		if (checkin.equalsIgnoreCase("n"))
		{
			System.out.println("Program Terminated.");			
		}
		else
		{
			System.out.println("\nEnter in new strings.");
			System.out.println("Remember to enter 'create' to create the palindromes.");
		}		
		}
		while (checkin.equalsIgnoreCase("y")); //program loops as long as the user enters in 'y' when asked
	}
	
	public static void userinput() //method will process the input
	{		
		Scanner palin = new Scanner(System.in);		
		PrintWriter writer = null;
		
		System.out.println("\nInput:\n");
		
		try 
		{
			writer = new PrintWriter("palindrome.txt", "UTF-8"); //text file would be created so multiple lines could be processed
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace(); //catches if the file is not found
		}
		catch (UnsupportedEncodingException e)
		{			
			e.printStackTrace(); //catches an unsupported text encoder
		}		
		input = palin.nextLine(); //user input is placed at this moment
		
		while (!input.equalsIgnoreCase("create")) //program will continue to read user input until 'stop' has been entered
		{
		writer.println(input);
		input = palin.nextLine();
		}
		writer.close();	//closes the editing of the text file
		
		System.out.println();
	}
	
	public static void reader()
	{
		try
		{
			BufferedReader fileread = new BufferedReader(new FileReader("palindrome.txt")); // file is read
			
			String line;
			
			System.out.println("Output:\n");
			
			while ((line = fileread.readLine()) != null) //program will loop until the end of the file
			{
				int palinlength = line.length() ;
				
			   	if((line.length() == 0))
			   	{
			   		System.out.println(); //blank line created if no string is present			   		
			   	}
			   	else
			   	{			   	
			   		System.out.print(line + ("-")); //the line is printed				
			   		recursioncreate(line, palinlength-1); //Recursive method is called		   
					System.out.println(); // a new line is created
			   	}
			}
			fileread.close(); //the file reader is closes
			
		} 
		catch (IOException e)
		{			
			e.printStackTrace(); //exception is caught, if any
		}
	}
	
	public static void recursioncreate(String recurstring, int recurlength) //recursive method creates the palindrome
	{
		String recur; //local string variable is called
		
		if ((recurlength == 0)) //only applies if the string index is at 0
		{		
			recur = Character.toString(recurstring.charAt(recurlength)); //local string variable is set to recurstring at the pointed index
			System.out.print(recur); //recur is printed
			return; //Recursive method ends
		}
		else
		{
			recur = Character.toString(recurstring.charAt(recurlength));
			System.out.print(recur);
		}
		
		recurlength--; //decreases the recurlength variable
		recursioncreate(recurstring, recurlength); //method will recur
	}

}
