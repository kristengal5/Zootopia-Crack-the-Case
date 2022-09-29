
/**
 * This class will be used for the mini challenge where players guess the apartment lock combination.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;
public class Apt
{
    Random randomGenerator = new Random();
    int randNum1;
    int randNum2;
    int randNum3;
    int guessThis;
    String randNum;
    
    public void aptNow(){
        setCombo();
        String guessThisInt = getCombo();        
        guessThis = Integer.parseInt(guessThisInt);
    }
    
    public void setCombo(){
        int min=1;
        int max=9;
        randNum1 = randomGenerator.nextInt(max-min+1)+min;
        randNum2 = randomGenerator.nextInt(max-min+1)+min;
        randNum3 = randomGenerator.nextInt(max-min+1)+min;
        int array[] = {randNum1, randNum2, randNum3};
        randNum = "";
        for(int x=0; x<array.length; x++){
            randNum += array[x];
        }
    }
    
    public String getCombo(){
        return randNum;
    }
    
    public String getGuess(int guess){
        if(guess==guessThis){
            return("Yay! You entered the apartment by correctly guessing the code!");
        }
        else{
            return("You did not guess it correctly. Try accessing your clues!");
        }
    }
    
    public String getHint(){
        return "The first two digits of the apartment are " + randNum1 + randNum2;
    } 
    
    public String getClue(){
        return ""+ randNum1 + randNum2;
    }
}
