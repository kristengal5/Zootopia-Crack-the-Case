/**
 * 
 * This deals with the different rooms/locations/worlds in the game. There are exits to move around.
 * 
 * @Kristen Gallagher
 * @version 6
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
public class Room 
{
    //declare HashMap
    private HashMap<String, Room>exits=new HashMap<String, Room>();
    private ArrayList <Item> items = new ArrayList <Item>();
    private ArrayList <Character> characters = new ArrayList <Character>();
    private ArrayList <Clue> clue = new ArrayList <Clue>();
    public String description;
    public Room nextExit;
    public Conversations talking;
    private String imageName;

    public Room(String description, String image) 
    {
        //this is a keyword that saves parameter to the object with the same name
        this.description = description;
        talking = new Conversations();
        imageName=image;
    }

    public void setExits(Room next) 
    {
        //put key and value into HashMap 
        if(next != null) {
            exits.put("next", next);
            nextExit = next;
        }
    }

    //String direction parameter, then use parameter as key in get statement for HashMap
    public Room getExit(String direction){
        return (Room)exits.get(direction);
    }
    
    //String direction and Room neighbor parameters and use put method to place key and value into hash
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    //Responsibility for determining room exits is now in Rooms not Game
    //for loop specific for HashMap Set
    public String getExitString(){
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " "+exit;
        }
        return returnString;
    }
    
    public String getDescription()
    {
        return description;
    }

    //method that returns concatenated string with description and exits
    public String getLongDescription(){
        String resultString = "You are " + description + "\n" + getExitString() + "\n";
        //if there are no exits, players are in the last location and cannot advance anymore.
        //once players get to this location that means there are no more exits
        if(getExitString()=="Exits: "){
            resultString = "You are " + description;
        }
        //how many items there are
        if(items.size() != 0){
            resultString+="This room contains:";
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                Item nextItem = (Item) iter.next();
                resultString += "\n" + "\t" + nextItem.getItemDescription() + "\n";
            }
        }
        //how many characters there are
        if(characters.size() != 0){
            resultString+= "Characters this room contains: ";
            Iterator iterator = characters.iterator();
            while(iterator.hasNext()){
                Character nextCharacter = (Character) iterator.next();
                resultString += "\n" + "\t" + nextCharacter.getCharacterDescription();
            }
        }
        return resultString;
    }
    
    //this is used to "hide" the items in this room from the user,
    //so it is a surprise when a character drops an item!
    public String getShortDescription(){
        String resultString = "You are " + description + "\n" + getExitString() + "\n";
        if(getExitString()=="Exits: "){
            resultString = "You are " + description + ". ";
        }
        if(characters.size() != 0){
            resultString+= "Characters this room contains: ";
            Iterator iterator = characters.iterator();
            while(iterator.hasNext()){
                Character nextCharacter = (Character) iterator.next();
                resultString += "\n" + "\t" + nextCharacter.getCharacterDescription();
            }
        }
        return resultString;
    }
    
    public String getShortestDescription(){
        return description;
    }
    
    //this is for when players "talk" to other characters and gives some background story/descriptions
    public String getLongDescriptionConvos(){
        String resultString = "";
        if(characters.size() != 0){
            Iterator iterator = characters.iterator();
            while(iterator.hasNext()){
                Character nextCharacter = (Character) iterator.next();
                resultString += "\n" + "\t" + talking.talk(nextCharacter);
            }
        }
        //if players type talk without a character in the room, I give feedback
        if(resultString ==""){
            resultString = "Sorry, there is nobody to talk with";
        }
        return resultString;
    }
    
    //only tells items and characters, not their descriptions
    public String roomContains(){
        String resultString = " ";
        if(items.size() != 0){
            resultString = "This room contains: ";
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                Item nextItem = (Item) iter.next();
                resultString += "\n" + "\t" + nextItem.toString();
            }
        }
        if(characters.size() != 0){
            resultString+= "Characters this room contains: ";
            Iterator iterator = characters.iterator();
            while(iterator.hasNext()){
                Character nextCharacter = (Character) iterator.next();
                resultString += "\n" + "\t" + nextCharacter.toString();
            }
        }
        return resultString;
    }
    
    public String getImageName(){
        return imageName;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public void addCharacter(Character character){
        characters.add(character);
    }
    
    public void addClue(Clue clues){
        clue.add(clues);
    }
    
    public ArrayList getItems(){
        return items;
    }
}
