/**
 * 
 * There are lots of commands in this game, and this deals with holding the information of the command.
 * 
 * @Kristen Gallagher
 * @version 6
 */

public class Command
{
    private String commandWord;
    private String secondWord;
    private Parser parser;

    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

