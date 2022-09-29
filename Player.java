
/**
 * This is the Player class. The player object stores information about the room and inventory.
 * Game talks to Player, and Player talks to Room.
 *
 * @Kristen Gallagher
 * @version 6
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Player
{
    private Room currentRoom;
    private Room room;
    private Command command;
    private ArrayList <Item> inventory;
    private ArrayList <Item> itemList;
    private ArrayList <Clue> clueInventory;
    private Item itemToTake;
    private int counter = 0;

    public Player()
    {
        currentRoom = null;
        //initialize array list inventory
        inventory = new ArrayList <Item>();
        clueInventory = new ArrayList <Clue>();
    }

    //returns string and takes command object command as parameter
    public String take(Command command){
        if(!command.hasSecondWord()){
            return "Take what?";
        }
        else{
            itemList = new ArrayList(currentRoom.getItems());
        }
        String itemTaken = command.getSecondWord();
        itemToTake = null;
        for(int x=0;x<itemList.size(); x++){
            itemToTake = (Item)itemList.get(x);
            if(itemToTake.getItemEasy().equals(itemTaken)){
                inventory.add(itemToTake);
                currentRoom.getItems().remove(itemToTake);
                return "You've taken " + itemToTake.getItemDescription() + "\n" + "You can now progress to the next location! Type 'go next' and press enter.";
            } 
        }
        return "This item does not exist";
    }
    
    //I altered the take method to create a drop method
    public String drop(Command command){
        //I account for mistakes in Game class in if statements.
        // if(!command.hasSecondWord()){
            // return "Drop what?";
        // }
        String itemTaken = command.getSecondWord();
        for(int x=0;x<inventory.size(); x++){        
            if(inventory.size()==0){
                return "Sorry, you don't have that in your inventory";
            }
            itemToTake = inventory.get(x);
            if(itemToTake.getItemEasy().equals(itemTaken)){
                inventory.remove(itemToTake);
                currentRoom.getItems().add(itemToTake);
                return "You've dropped " + itemToTake.getItemDescription();
            }
        }
        return "This item doesn't exist";
    }
    
    //use iterator to loop through inventory ArrayList and see what items are in inventory
    public String getInven(){
        String inventoryString="";
        Iterator it=inventory.iterator();
        while(it.hasNext()){
            Item nextInventory = (Item) it.next();
            counter +=1;
            inventoryString+="\n" + "\t" + nextInventory.getItemDescription();
        }
        if (inventoryString ==""){
            inventoryString ="Sorry, you do not have any items in your inventory";
        }
        return inventoryString;
    }
    
    public int getLengthOfInven(){
        Iterator it=inventory.iterator();
        while(it.hasNext()){
            Item nextInventory = (Item) it.next();
            counter +=1;
        }
        return counter;
    }
    
    public int getNumOfItems(){
        return counter+1;
    }
    
    //return currentRoom value
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    //requires room value passed to it, set first room at beginning of game.
    public void setCurrentRoom(Room room){
        currentRoom = room;
    }
    //similar to goRoom
    public String walk(String direction){
        String info = "";
        Room nextRoom = null;
        if(direction==null){
            info = "Go where?" + "\n";
        }
        else{
            if(direction.equalsIgnoreCase("next")){
                nextRoom=currentRoom.getExit("next");
            }
            //no need for additional if statements since my game is linear (the only option is go next)
        }
        if(nextRoom!=null){
            currentRoom = nextRoom;
        }
        else if((nextRoom==null) && (direction!=null)){
            info="You can't do that";
        }
        return info;
        }
}
