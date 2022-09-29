
/**
 * Plate deals with the randomized license plate.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;

public class Plate
{
    private String name;
    private String descript;
    Random randomGenerator = new Random();
    int rand1;
    int rand2;
    int rand3;
    int rand4;
    int rand5;
    int rand6;
    char letter1;
    char letter2;
    char letter3;
    char letter4;
    char letter5;
    char letter6; 
    int guessThis;
    String randLicense;
    
    public String getLicense(){
        return randLicense;
    }
    
    public void setLicenseGen(){
        char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
        int minimum = 0;
        int maximum = 25;
        randLicense = "";
        rand1 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter1 = letters[rand1];
        randLicense += letter1;
        rand2 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter2 = letters[rand2];
        randLicense += letter2;
        rand3 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter3 = letters[rand3];
        randLicense += letter3;
        rand4 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter4 = letters[rand4];
        randLicense += letter4;
        rand5 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter5 = letters[rand5];
        randLicense += letter5;
        rand6 = randomGenerator.nextInt(maximum-minimum+1)+minimum;
        letter6 = letters[rand6];
        randLicense += letter6;
    }
}
