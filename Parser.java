import java.util.Scanner;

/**
 * 
 * This deals with user input. It checks the user input against the known commands.
 * 
 * @Kristen Gallagher
 * @version 6
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input
    int nInput = 0;
    //read from terminal
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    //calls show all method
    public String showCommands(){
        return commands.showAll();
    }
    
    public Command getCommand(String inputLine) 
    {
        String word1 = null;
        String word2 = null;

        //inputLine = reader.nextLine().toLowerCase();
        String [] arrOfString = inputLine.toLowerCase().split(" ");
        try{
            nInput = Integer.parseInt(inputLine);
            switchcase();
        }
        catch(NumberFormatException exc){
            nInput = 0;
        }
        
        if(arrOfString.length==1){
            word1=arrOfString[0];
            word2=null;
        }
        else{
            word1=arrOfString[0];
            word2=arrOfString[1];
        }
        if(commands.isCommand(word1)){
            return new Command(word1, word2);
        }
        else{
            return new Command(null, word2);
        }
        
        // // Find up to two words on the line. THE ONLY SCANNER IS HERE
        // Scanner tokenizer = new Scanner(inputLine);
        // //tockenizer looks at each word user enters
        // if(tokenizer.hasNext()) {
            // word1 = tokenizer.next();      // get first word
            // if(tokenizer.hasNext()) {
                // word2 = tokenizer.next();      // get second word
            // }
        // }

        // // Now check whether this word is known. If so, create a command
        // // with it. If not, create a "null" command (for unknown command).
        // if(commands.isCommand(word1)) {
            // return new Command(word1, word2);
        // }
        // else {
            // return new Command(null, word2); 
        // }
    }
    public String switchcase(){
        String retString = "";
        switch(nInput){
            case 1:
                nInput = 1;
                retString = "You picked car 1";
                break;
            case 2:
                nInput = 2;
                retString = "You picked car 2";
                break;
            case 3:
                nInput = 3;
                retString = "You picked car 3";
                break;
            case 4:
                nInput = 4;
                retString = "You picked car 4";
                break;
            case 5:
                nInput = 5;
                retString = "You picked car 5";
                break;
            case 6:
                nInput = 6;
                retString = "You picked car 6";
                break;
            case 7:
                nInput = 7;
                retString = "You picked car 7";
                break;
            case 8:
                nInput = 8;
                retString = "You picked car 8";
                break;
            case 9:
                nInput = 9;
                retString = "You picked car 9";
                break;
            case 10:
                nInput = 10;
                retString = "You picked car 10";
                break;
            case 11:
                nInput = 11;
                retString = "You picked car 11";
                break;
            case 12:
                nInput = 12;
                retString = "You picked car 12";
                break;
            case 13:
                nInput = 13;
                retString = "You picked car 13";
                break;
            case 14:
                nInput = 14;
                retString = "You picked car 14";
                break;
            case 15:
                nInput = 15;
                retString = "You picked car 15";
                break;
            case 16:
                nInput = 16;
                retString = "You picked car 16";
                break;
            case 17:
                nInput = 17;
                retString = "You picked car 17";
                break;
            case 18:
                nInput = 18;
                retString = "You picked car 18";
                break;
            case 19:
                nInput = 19;
                retString = "You picked car 19";
                break;
            case 20:
                nInput = 20;
                retString = "You picked car 20";
                break;
            default:
                retString = "Not a valid guess";
        }
        return retString;
    }
    public int getGuessInt(){
        return nInput;
    }
}
