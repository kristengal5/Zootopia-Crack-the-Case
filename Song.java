
/**
 * Write a description of class Song here.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;
public class Song
{
    Random randomGenerator = new Random();
    int randNum;
    String singer;
    public int getMenu(){
        int min=0;
        int max=7;
        randNum = randomGenerator.nextInt(max-min+1)+min;
        String array[] = {"Taylor Swift", "Ed Sheeran", "Ariana Grande", "Billie Eilish", "Justin Bieber","Dua Lipa", "Katy Perry", "Bruno Mars", "Elvis", "Adele"};
        singer = array[randNum];
        return randNum;
    }
    
    public String getSinger(){
        return singer;
    }
    
    public String getActual(){
        return "His favorite singer is " + singer;
    }
    
    public String getString(int guess){
        if(guess == randNum+1){
            return "Yay! You entered the correct singer!";
        }
        return "You did not guess the correct singer. Try again.";
        }
}
