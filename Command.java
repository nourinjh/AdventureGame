/**
 * combined Command and CommandWords
 * @author  Nourin Abd El Hadi
 * @version 1.2
 * @since May 30, 2018
 */

class Command{
	
    private String commandWord;
    private String secondWord;
    private static final String validCommands[] = {"go", "quit", "help", "look", "take", "use", "inventory"};

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognized by this game.
     */
    public Command(String firstWord, String secondWord){
        
    		commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     */
    public String getCommandWord(){
        return commandWord;
    }

    /**
     * Return the second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord(){
        return secondWord;
    }

    /**
     * Return true if this command was not understood.
     */
    public boolean isUnknown(){
        return (commandWord == null);
    }

    /**
     * Return true if the command has a second word.
     */
    public boolean hasSecondWord(){
        return (secondWord != null);
    }
    

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString){
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}

