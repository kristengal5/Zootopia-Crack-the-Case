
/**
 * This is for the Yoga minigame where players guess Yax's favorite pose from the array.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;
public class Yoga
{
    Random randomGenerator = new Random();
    int randNum;
    String routine;
    public int setMenu(){
        int min=0;
        int max=9;
        randNum = randomGenerator.nextInt(max-min+1)+min;
        String array[] = {"downward dog", "warrior pose", "crow", "child's pose", "tree", "baby cobra", "locust", "camel", "pigeon", "rabbit"};
        routine = array[randNum];
        return randNum;
    }
    
    public String getActual(){
        return "Yax's favorite yoga pose is " + routine;
    }
    
    public String getRoutine(){
        return routine;
    }
    
    public String getString(int guess){
        if(guess == randNum+1){
            return "Yay! You entered the pose!";
        }
        return ("You did not guess the correct pose. Try again.");
        }
}
