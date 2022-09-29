
/**
 * Joke is for the Flash mini game.
 *
 * @Kristen Gallagher
 * @version 6
 */
public class Joke
{
    int counter = 0;
    int right = 0;
    
    public int getJokeOne(){
        return 2;
    }
    public int getJokeTwo(){
        return 3;
    }
    public int getJokeThree(){
        return 4;
    }
    public int getJokeFour(){
        return 1;
    }
    public int getJokeFive(){
        return 1;
    }
    public int getJokeSix(){
        return 3;
    }
    public int getJokeSeven(){
        return 2;
    }
    public int getJokeEight(){
        return 1;
    }
    public int getJokeNine(){
        return 3;
    }
    public int getJokeTen(){
        return 2;
    }
    
    public int getCounter(){
        return counter;
    }
    
    public int getRight(){
        return right;
    }
    
    public String getString(int guess){
        if(counter==0){
            counter+=1;
            if(guess == getJokeOne()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==1){
            counter+=1;
            if(guess == getJokeTwo()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==2){
            counter+=1;
            if(guess == getJokeThree()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==3){
            counter+=1;
            if(guess == getJokeFour()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==4){
            counter+=1;
            if(guess == getJokeFive()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==5){
            counter+=1;
            if(guess == getJokeSix()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==6){
            counter+=1;
            if(guess == getJokeSeven()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==7){
            counter+=1;
            if(guess == getJokeEight()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==8){
            counter+=1;
            if(guess == getJokeNine()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        else if(counter==9){
            counter+=1;
            if(guess == getJokeTen()){
                right+=1;
                return "Yay! You knew that joke!";
            }
        }
        return "Sorry, that is not correct.";
    }
    
}
