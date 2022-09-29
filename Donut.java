
/**
 * Donut is used for Officer Clawhauser's mini game where users guess the flavor.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;
public class Donut
{
    Random randomGenerator = new Random();
    int randNum;
    String order;
    public int getMenu(){
        int min=0;
        int max=7;
        randNum = randomGenerator.nextInt(max-min+1)+min;
        String array[] = {"strawberry", "chocolate", "vanilla", "funfetti", "glazed","jelly", "powdered", "coconut"};
        order = array[randNum];
        return randNum;
    }
    
    public String getOrder(){
        return order;
    }
    
    public String getActual(){
        return "The donut stuck in his neck was " + order;
    }
    
    public String getString(int guess){
        if(guess == randNum+1){
            return "Yay! You entered the correct donut that is in Clawhauser's neck!";
        }
        return "You did not guess the correct donut. Try again.";
        }
    }
