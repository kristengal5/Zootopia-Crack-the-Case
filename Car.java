
/**
 * I determined the cars with expired parking.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.ArrayList;
public class Car
{
    String car="";
    String carGuessed = "";
    ArrayList<String> carsToGuess = new ArrayList<String>();
    
    public ArrayList getGraphicToStart(){
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        carsToGuess.add("-");
        
        return carsToGuess;
    }
    
    public void setGraphic(int guessed){
        guessed -=1;
        if(guessed>=0){
            carsToGuess.set(guessed, "X");
        }
    }
    
    public String getGraphic(){
        //I researched how to turn array list into string and came across StringBuffer on Geeks for Geeks. 
        //This method used to return an array list but now has to be a string after adding images. 
        StringBuffer sb = new StringBuffer();
        for (String x:carsToGuess){
            sb.append(x);
            sb.append("");
        }
        String stringCars = sb.toString();
        return stringCars;
    }
    
    public String carsExpired(int carGuess){
        String array[] = {"You picked car 1", "You picked car 2", "", "", "You picked car 5", "",
        "You picked car 7", "You picked car 8","", "", "", "You picked car 12", "", "", "You picked car 15", "You picked car 16",
        "You picked car 17", "", "", "You picked car 20"};
        carGuessed = array[carGuess];
        return carGuessed;
    }
}