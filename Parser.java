import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * The parser class is used to read the user's input 
 * and separates it into two (or more) words  
 * 
 * @author  Nourin Abd El Hadi
 * @version 1.8 (final)
 * @since May 11th, 2018
 **/

public class Parser{
	
	// holds all valid command words
    private Command commands;  

    public Parser(){
    		commands = new Command(null, null);
    }

    
    public Command getCommand() {
    		
    		//instantiating variables
    		String inputLine = "";   
    		String word1;
    		String word2;

    		System.out.print("> ");   

    		//reads the user input
    		BufferedReader reader = 
    				new BufferedReader(new InputStreamReader(System.in));
    		try {
    			inputLine = reader.readLine();
    		}
    		catch(java.io.IOException exc) {
    			System.out.println ("There was an error during reading: "
    					+ exc.getMessage());
    		}

    		//looks for a space and separates the words
    		StringTokenizer tokenizer = new StringTokenizer(inputLine);

    		if(tokenizer.hasMoreTokens())
    			word1 = tokenizer.nextToken();     
    		else
    			word1 = null;
    		if(tokenizer.hasMoreTokens())
    			word2 = tokenizer.nextToken();      
    		else
    			word2 = null;


    		//checking if the word is recognized
    		if(commands.isCommand(word1))
    			return new Command(word1, word2);
    		else
    			return new Command(null, word2);
    }
}
