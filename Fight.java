/**
 * This is used for the fight with Gideon Grey mini challenge in the first location.
 * @Kristen Gallagher
 * @version 6
 */
import java.util.Random;
public class Fight
{
    int punchesNeeded;
    int kicksNeeded;
    int counter=0;
    
    public String fightNow(){
        generator();
        return "There is a correct series of 4 punches and/or kicks to beat Gideon." + "\n"+
        "Type either 'punch' or 'kick' and press enter to strike. Good Luck!";
    }
    
    public void generator(){
        int min = 0;
        int max = 4;
        Random randNo = new Random();
        kicksNeeded = randNo.nextInt((max-min+1)+min);
        punchesNeeded = 4-kicksNeeded;
        //counter variable because a series/combination must be generated before punching/kicking
        counter +=1;
    }
    
    public void setPunch(){
        punchesNeeded-=1;
        if (punchesNeeded<0){
            punchesNeeded = 0;
        }
    }
    
    public String getPunch(){
        //check counter to make sure players meet the requirements based on their combination.
        //if so, and they do not need any more punches or kicks, they won this mini challenge
        if((punchesNeeded ==0)&&(kicksNeeded==0) &&(counter>=1)){
            return "You beat Gideon!";
        }
        else if(counter<=0){
            return "You need to type 'fight' to choose to engage in a fight with Gideon Grey";
        }
        return "You need more punches and/or kicks. " + "\n" + "Keep striking until you have the correct combination of punches and kicks, then you will win!";
    }
    
    public void setKick(){
        kicksNeeded-=1;
        if (kicksNeeded<0){
            kicksNeeded = 0;
        }
    }
    
    public String getKick(){
        if((punchesNeeded ==0)&&(kicksNeeded==0)&&(counter>=1)){
            return "You beat Gideon!";
        }
        else if(counter<=0){
            return "You need to type 'fight' to choose to engage in a fight with Gideon Grey";
        }
        return "You need more punches and/or kicks. " + "\n" + "Keep striking until you have the correct combination of punches and kicks, then you will win!"; 
    }
}   
