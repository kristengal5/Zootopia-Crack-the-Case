/**
 *
 * This holds the acceptable command words that users will type.
 *
 * @Kristen Gallagher
 * @version 6
 */

public class CommandWords
{
    private Plate plate = new Plate();
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "take", "inventory", "call", "drop", "talk", "punch", "pursue", "kick", "fight", "clue", "compliment", "guess", "chase"
    };
    private String commandsList;

    public CommandWords()
    {
        // nothing to do at the moment.
    }

    //uses for loop to print commands array elements and return as String
    public String showAll(){
        commandsList = " ";
        for (int x=0; x<validCommands.length; x++){
            commandsList += validCommands[x] + " ";
        }
        return commandsList;
    }
    
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            //.equals because there are 2 strings
            if(validCommands[i].equals(aString))
                return true;
                //this means it is a valid command word
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
