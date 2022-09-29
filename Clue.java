
/**
 * Clue stores important information and clues for user reference.
 *
 * @Kristen Gallagher
 * @version 6
 */
public class Clue

{
    String clues = "";
    String mostRecent = "";
    public void setClue(String item){
        //don't want repeat items in clue list, ex if players enter the correct apartment 
        //combo and then enter it again. I print that the player won every time the correct 
        //combo is entered, in case players are confused, but there is no need to have the 
        //donut flavor listed multiple times in the clues list.
        if(item.length()!=mostRecent.length()){
            clues+="\n" + "\t" + item;
            mostRecent = item;
        }
    }
    
    public String getClue(){
        String print = "";
        if (clues.length()!=0){
            print="Your clues are: " + clues;
        }
        else{
            print="Sorry, you don't have any clues right now";
        }
        return print;
    }
}
