/**
 *  
 * This is the back-end class for the Zootopia: Crack the Case game!
 * This is a text based adventure game.
 *  
 * @Kristen Gallagher
 * @version 6
 */
import java.util.ArrayList;
public class GameEngine 
{
    private Parser parser;
    private Player player;
    private String direction;
    private Room room;
    private Donut donut;
    private Fight fight;
    private Apt apt;
    private Car car;
    private Yoga yoga;
    private Clue clue;
    private Joke joke;
    private Plate plate;
    private Song song;
    public UserInterface gui;
    //ok needs to be true to move to next location
    private boolean ok;
    //this boolean will be used later on. It is set true when players save Fru Fru and will get an advantage in Tundratown.
    private boolean saved;
    private boolean berries;
    private boolean jokes;
    private boolean hit;
    private boolean chase;
    //counter is used for car mini game to ensure 10 different cars are counted as having expired parking
    private int counter = 0;
    //an array list was helpful to determine which cars were guessed already. I could add cars to this as needed
    private ArrayList<Integer> carsGuessedAlready = new ArrayList<Integer>();
    
    public GameEngine() 
    {
        player = new Player();
        createRooms();
        parser = new Parser();
        fight=new Fight();
        apt = new Apt();
        donut = new Donut();
        car = new Car();
        ok = false;
        saved=false;
        berries=false;
        jokes=false;
        hit=false;
        chase=false;
        yoga = new Yoga();
        clue = new Clue();
        joke = new Joke();
        plate = new Plate();
        song = new Song();
    }

    private void createRooms()
    {
        Room bunnyburrow, apartment, zootopiaPD,
        littleRodentia, nighthowlerLab, museum, concert, iceCreamShop, rainforestDistrict, 
        tundratown, dmv, mysticSpringOasis, fields;
      
        bunnyburrow = new Room("in Bunnyburrow, your hometown", "bunnyburrow.jpg");
        apartment = new Room("in front of your new apartment", "apartment.jpg");
        zootopiaPD = new Room("in the Zootopia Police Department Headquarters", "zootopiapd.jpg");
        littleRodentia = new Room("in Little Rodentia, where you are assigned parking duty", "littlerodentia.jpg");
        nighthowlerLab = new Room("in the Nighthowlers' Lab", "nighthowlerLab.jpg");
        fields=new Room("in the bunny fields of Zootopia", "fields.jpg");
        museum = new Room("in the Natural History Museum", "museum.jpg");
        concert = new Room("at a Gazelle concert", "concert.jpg");
        iceCreamShop = new Room("at the ice cream shop", "icecreamshop.jpg");
        rainforestDistrict = new Room("in Rainforest District", "rainforestDistrict.jpg");
        tundratown = new Room("in Tundratown", "tundratown.jpg");
        dmv = new Room("at the DMV", "dmv.jpg");
        mysticSpringOasis = new Room("at the Mystic Spring Oasis", "mysticSpringOasis.jpg");
        
        //all of the locations have "next" as the exit because my game is linear. 
        //To move rooms, users type 'go next'. If they have met the requirements, they should be able to advance to the next room.
        bunnyburrow.setExit("next", apartment);
        
        apartment.setExit("next", zootopiaPD);
        
        zootopiaPD.setExit("next", littleRodentia);
        
        littleRodentia.setExit("next", iceCreamShop);
        
        iceCreamShop.setExit("next", mysticSpringOasis);
        
        mysticSpringOasis.setExit("next", dmv);
        
        dmv.setExit("next", tundratown);
        
        tundratown.setExit("next", rainforestDistrict);
        
        rainforestDistrict.setExit("next", nighthowlerLab);
        
        nighthowlerLab.setExit("next", fields);
        
        fields.setExit("next", museum);
        
        museum.setExit("next", concert);
        
        //at last location, the concert, there are no exits because the game ends.
        
        //add an item to a room
        bunnyburrow.addItem(new Item ("pen", "records voices"));
        apartment.addItem(new Item ("badges", "give you super-secret access to police files"));
        zootopiaPD.addItem(new Item ("donut", "is really dense"));
        fields.addItem(new Item ("blueberry", "is from Gideon's farm"));
        
        //add a character to a room
        bunnyburrow.addCharacter(new Character ("Gideon Grey", "fox", "a carrot farm in Bunnyburrow"));
        apartment.addCharacter(new Character ("Landlord", "pangolin who you rent your apartment from", "Zootopia"));
        zootopiaPD.addCharacter(new Character ("Officer Clawhauser", "cheetah who works at the ZPD", "Zootopia"));
        littleRodentia.addCharacter(new Character ("Fru Fru", "rodent", "her father's mansion"));
        iceCreamShop.addCharacter(new Character ("Nick Wilde", "fox who schemes and appears to be a really sly animal", "Zootopia"));
        mysticSpringOasis.addCharacter(new Character ("Yax", "yak", "Mystic Spring Oasis practicing yoga 24/7"));
        dmv.addCharacter(new Character ("Flash", "sloth", "Zootopia"));
        tundratown.addCharacter(new Character ("Mr. Biggs", "rodent", "a mansion"));
        rainforestDistrict.addCharacter(new Character ("Manchas", "predator", "a beat-up fort made of roots and vines"));
        fields.addCharacter(new Character("Old Gideon", "fox", "his own farms in Bunnyburrow"));
        museum.addCharacter(new Character("Bellwether", "lamb", "Zootopia"));
        concert.addCharacter(new Character("Officer Bogo", "buffalo", "Zootopia"));
        
        //currentRoom = bunnyburrow;
        //call to setCurrentRoom method in Player class using player object. 
        //pass initial room in parameters
        player.setCurrentRoom(bunnyburrow);
    }

    // public void play() 
    // {            
        // boolean finished = false;
        // while (! finished) {
            // String input = gui.entryField.getText();
            // interpretCommand(input);
        // }
        // gui.println("Thank you for playing.  Good bye.");
    // }

    public void setGUI(UserInterface userInterface){
        gui=userInterface;
        printWelcome();
    }
    
    private void printWelcome()
    {
        gui.println("Welcome to Zootopia: Crack the Case! You're Judy Hopps, a bunny who aspires to be a police officer.");
        //Here, I explain some basic commands so users are not confused about how to start playing.
        gui.println("Here are some words you can type to play the game: If you want help, type 'help' and press enter.");
        gui.println("To take an item, type 'take' and the noun and press enter. To talk to a character, type 'talk' and press enter.");
        gui.println("To move locations, type 'go next' and press enter. To quit, please type 'quit' and press enter.");
        gui.println("Access clues, which contain information needed in challenges, by typing 'clue' and pressing enter.");
        gui.println("If you're unable to move rooms, try talking to a character or taking an item.");
        gui.println("Good luck, Hopps!");
        //I don't print getLongDescription because I don't want players to know there is an item in a room until after a challenge.
        //After a challenge, I will use getLongDescription and then they can pick up the item.
        gui.println(player.getCurrentRoom().getShortDescription());
        //I want to have these combos created only once because they set up the mini game combinations/correct answers. 
        //Only calling these methods in welcome ensures that new combos are not created multiple times.
        //this sets the lock combination and turns the combo into an integer instead of a string
        apt.aptNow();
        //this returns the randomly-selected menu option that is stuck in Clawhauser's neck
        donut.getMenu();
        //this sets up the dashes
        car.getGraphicToStart();
        plate.setLicenseGen();
        yoga.setMenu();
        song.getMenu();
        //all the other images show when go next, but this is the image for the first room
        gui.showImage(player.getCurrentRoom().getImageName());
        //gui.println(currentRoom.getLongDescription());
        //object calls method and prints
        //gui.println(currentRoom.getExitString());
    }    
    
    private void printLocationInfo(){
        gui.println(player.getCurrentRoom().getLongDescription());
        gui.println("");
    }
    
    //changed to public otherwise there is an error in UserInterface
    public boolean interpretCommand(String commandLine){
        boolean wantToQuit = false;
        Command command = parser.getCommand(commandLine);
        //need to have boolean word now that I also take number answers for some mini games. This is used to determine word or number input.
        boolean word = true;
        //these ints used for apartment and donut mini games, respectively
        int guessNum = 0;
        int guessDonut = 0;
        int guessYoga = 0;
        int guessJoke = 0;
        int guessSong = 0;
        if((command.isUnknown()) && (parser.switchcase()=="")) {
            gui.println("I don't know what you mean..." + "\n");
            return false;
        }
        //for apartment game
        else if((command.isUnknown()) && (parser.switchcase()!="") &&(player.getNumOfItems()>0)&&(player.getCurrentRoom().getShortestDescription()=="in front of your new apartment")){
            guessNum = parser.getGuessInt();
            gui.println(apt.getGuess(guessNum));
            if(apt.getGuess(guessNum) == "Yay! You entered the apartment by correctly guessing the code!"){
                gui.println("You see shiny things on your desk...What are they?");
                gui.println("In addition, you notice a lot of posters with " + donut.getOrder() + " donuts. Weird...is that a clue that can help later on?");
                clue.setClue("The donut flavor is " + donut.getOrder());
                printLocationInfo();
            }
            word = false;
            return false;
        }
        //for donut game
        else if((command.isUnknown()) && (parser.switchcase()!="") &&(player.getNumOfItems()>0)&&(player.getCurrentRoom().getShortestDescription()=="in the Zootopia Police Department Headquarters")){
            guessDonut = parser.getGuessInt();
            gui.println(donut.getString(guessDonut));
            if(donut.getString(guessDonut) == "Yay! You entered the correct donut that is in Clawhauser's neck!"){
                gui.println(donut.getActual());
                gui.println("It looks like Clawhauser wants to give you something for your work...what is it?");
                printLocationInfo();
            }
            word = false;
            return false;
        }
        //for yoga game
        else if((command.isUnknown()) && (parser.switchcase()!="") &&(player.getNumOfItems()>0)&&(player.getCurrentRoom().getShortestDescription()=="at the Mystic Spring Oasis")){
            guessYoga = parser.getGuessInt();
            gui.println(yoga.getString(guessYoga));
            if(yoga.getString(guessYoga) == "Yay! You entered the pose!"){
                gui.println(yoga.getActual());
                gui.println("It looks like Yax wants to repay you. He will give you the license plate of a limo Otterton rode in:");
                gui.println(plate.getLicense());
                clue.setClue(plate.getLicense());
                gui.println("That info may come in handy later.");
                gui.println("Remember, you can access your clues anytime by typing 'clue' and pressing enter");
                gui.println("But for now, you can 'go next'");
                ok=true;
                printLocationInfo();
            }
            word = false;
            return false;
        }
        //for mr. biggs game
        else if((command.isUnknown()) && (parser.switchcase()!="")&&(player.getNumOfItems()>0)&&(player.getCurrentRoom().getShortestDescription()=="in Tundratown")){
            guessSong = parser.getGuessInt();
            gui.println(song.getString(guessSong));
            if(song.getString(guessSong)=="Yay! You entered the correct singer!"){
                gui.println(song.getActual());
                gui.println("You: I hate " + song.getSinger());
                gui.println("Mr. Biggs: You SAID WHAT ABOUT MY FAVORITE SINGER? Now you will pay...ice them!");
                gui.println("You: Wait, what?");
                if(saved==true){
                    gui.println("Fru Fru: Daddy! I picked my wedding dress! Hey, didn't you save my dress eariler?");
                    gui.println("Mr. Biggs: You saved my daughter's dress?");
                    gui.println("Fru Fru: Yeah, she used a donut!");
                    gui.println("You: Wait, you are her father?!");
                    gui.println("Biggs: I owe you. Guards, please don't ice this bunny anymore. You are free to go search my limo.");
                    gui.println("Ypu: Why are there claw marks in the limo?");
                    gui.println("Biggs: Perhaps Otterton went savage.");
                    gui.println("You: Savage?");
                    gui.println("Biggs: Yeah. You want more information? Talk to the driver of the limo, Manchas.");
                    gui.println("He lives in Rainforest District. 'go next' to visit him."); 
                    ok = true;
                    printLocationInfo();
                }
                else{
                    gui.println("Fru Fru: Daddy! I picked my wedding dress!");
                    gui.println("But I saw this bunny earlier, and she didn't even save my dress...my wedding dress!");
                    gui.println("Biggs: I can't believe that. Do you have any last words before I ice you?");
                    gui.println("You: Wait, you are her father?!");
                    gui.println("Perhaps...give her a compliment?");
                    gui.println("Type 'compliment' and then perhaps I will change my mind");
                }
            }
            word=false;
            return false;
        }
        //for sloth game
        else if((command.isUnknown()) && (parser.switchcase()!="") &&(player.getNumOfItems()>0)&&(player.getCurrentRoom().getShortestDescription()=="at the DMV")){
            guessJoke = parser.getGuessInt();
            gui.println(joke.getString(guessJoke));
            gui.println("Amount correct: " + joke.getRight());
            gui.println("Amount guessed: " + joke.getCounter());
            if((joke.getCounter()==10)||(joke.getRight()==3)){
                jokes=true; 
                gui.println("Flash: Fine, now I'll give you some info about that plate. What was that license again?");
                gui.println("Type 'guess' and the plate combination, but if you need a hint first, type 'clue'.");
            }
            else if(joke.getCounter()==1){
                printJokeTwo();
            }
            else if(joke.getCounter()==2){
                printJokeThree();
            }
            else if(joke.getCounter()==3){
                printJokeFour();
            }
            else if(joke.getCounter()==4){
                printJokeFive();
            }
            else if(joke.getCounter()==5){
                printJokeSix();
            }
            else if(joke.getCounter()==6){
                printJokeSeven();
            }
            else if(joke.getCounter()==7){
                printJokeEight();
            }
            else if(joke.getCounter()==8){
                printJokeNine();
            }
            else if(joke.getCounter()==9){
                printJokeTen();
            }
            word = false;
            return false;
        }
        //for car game
        else if((command.isUnknown()) && (player.getNumOfItems()>0)&& (player.getCurrentRoom().getShortestDescription()  == "in Little Rodentia, where you are assigned parking duty")&&(parser.switchcase()!="")){
            int carNum = 0;
            gui.println(parser.switchcase());
            int y=0;
            boolean yes = true;
            //I conducted further research on ArrayLists to hold values users already guessed
            //according to zuul lab 3 there are methods for searching, and I found .contains.
            if(yes==true){
                //x is the index for cars
                for (int x=0; x<20; x++){
                    if(car.carsExpired(x) ==parser.switchcase()){
                        //y is in human terms/not the indexing style
                        y=x+1;
                        x=20;
                    }
                    //already guessed a specific number
                    if(carsGuessedAlready.contains(y)){
                        gui.println("You can't guess that again. Try a different number.");
                        counter-=1;
                        yes=false;
                    }
                }
                if(y!=0){
                    gui.println("Car " + y + " was one of the cars with expired parking!");
                    car.setGraphic(y);
                    gui.println(car.getGraphic());
                    carsGuessedAlready.add(y);
                    //counter must be ten to move on
                    counter +=1;
                }
                else{
                    gui.println("Sorry that car is not expired");
                    gui.println(car.getGraphic());
                }
                gui.println("So far you guessed " + counter + " correct cars");
                if(counter ==10){
                    gui.println("You won since you guessed ten cars!");
                    gui.println("Is that a thief you see?");
                    gui.println("What should you do? Either 'go next' to ignore, or 'pursue' to catch him!");
                    //ok set to true here because users do not have to pursue, they can just go next and not receive an advantage
                    ok=true;
                }
            }
            word = false;
            return false;
        }
        //if users entered a number where they were not supposed to
        else if(((command.isUnknown()) && (parser.switchcase()!=""))){
            word = false;
            gui.println("Enter a word.");
        }
        //these choices are for word inputs
        if(word == true){
            String commandWord = command.getCommandWord();
            if (commandWord.equalsIgnoreCase("help")) {
                printHelp();
            }
            else if(commandWord.equalsIgnoreCase("punch")){
                if(player.getCurrentRoom().getShortestDescription()=="in Bunnyburrow, your hometown"){
                    //if players type punch, the variable representing the number of punches needed decreases using setPunch()
                    fight.setPunch();
                    gui.println(fight.getPunch());
                    //I check if players beat Gideon, then I lead them to pick up the pen. 
                    if((fight.getPunch() == "You beat Gideon!")||(fight.getKick() == "You beat Gideon!")){
                        clue.setClue("The apartment combination is " + apt.getHint());
                        gui.println("Gideon: Leave me alone, and I'll give you " + apt.getClue() + " tickets for the stupid fair.");
                        gui.println("Did Gideon just give you a clue?");
                        gui.println("");
                        gui.println("It looks like he dropped something...what item did he drop?");
                        //only call printLocationInfo() when I want the item to print and then players will pick it up.
                        //note: so far, items are located in bunnyburrow, the police dept, and nighthowler lab.
                        printLocationInfo();
                    }
                }
                else{
                    gui.println("You do not need to punch");
                }
            }
            else if(commandWord.equalsIgnoreCase("kick")){
                if(player.getCurrentRoom().getShortestDescription()=="in Bunnyburrow, your hometown"){
                    fight.setKick();
                    gui.println(fight.getKick());
                    if((fight.getKick() == "You beat Gideon!")||(fight.getPunch() == "You beat Gideon!")){
                        clue.setClue("The apartment combination is " + apt.getHint());
                        gui.println("Gideon: Leave me alone, and I'll give you " + apt.getClue() + " tickets for the stupid fair. Did Gideon just give you a clue?");
                        gui.println("");
                        gui.println("It looks like he dropped something...what item did he drop?");
                        printLocationInfo();
                    }
                }
                else{
                    gui.println("You do not need to kick");
                }
            }
            //players type fight before they start punching/kicking
            else if(commandWord.equalsIgnoreCase("fight")){
                if(player.getCurrentRoom().getShortestDescription()=="in Bunnyburrow, your hometown"){
                    printFight();
                }
                else{
                    gui.println("You do not need to fight");
                }
            }
            //guess license plate
            else if(commandWord.equalsIgnoreCase("guess")){
                if((player.getCurrentRoom().getShortestDescription()=="at the DMV")&&(jokes==true)){
                    //goRoom(command);
                    direction=command.getSecondWord();
                    if(direction==null){
                        direction="";
                    }
                    //if statements to prevent problems with typos after winning games
                    if(direction.equals(plate.getLicense())){
                        gui.println("Oh, right.");
                        gui.println("Flash: It appears a rodent named Mr. Biggs owns that limo." + "\n" + "Otterton rode that limo the night of his disappearance.");
                        gui.println("He lives in Tundratown. I would 'go next' to investigate there.");
                        clue.setClue("The singer is " + song.getSinger());
                        gui.println("You: Do you hear that music? It sounds like " + song.getSinger() + "!");
                        printLocationInfo();
                        ok=true;
                    }
                    else{
                        gui.println("What was that?");
                    }
                }
                else{
                    gui.println("You don't need to guess right now!");
                }
            }
            else if (commandWord.equalsIgnoreCase("go")) {
                //boolean used to see if players can move on to the next room after winning a mini game
                if (ok==true){
                    //goRoom(command);
                    direction=command.getSecondWord();
                    //if statements to prevent problems with typos after winning games
                    //In case players make a typo after winning a game, they should not have to replay the game in order to progress. I give them another chance instead of changing the boolean to false at the end of each time they type go.
                    if((player.walk(direction).equals("You can't do that"))||(direction==null)){
                        gui.println("Did you really mean to type that? Try typing your next move again.");
                    }
                    //at the end of my game, there is one room where I want players to see there is an object right away so I print getLongDescription instead of only getShortDescription
                    else{
                        if(player.getCurrentRoom().getShortestDescription()=="in the bunny fields of Zootopia"){
                            gui.println(player.getCurrentRoom().getLongDescription());
                            berries=true;
                            if(player.getCurrentRoom().getImageName()!=null){
                                gui.showImage(player.getCurrentRoom().getImageName());
                            }
                        }
                        else{
                            //printLocationInfo();
                            gui.println(player.getCurrentRoom().getShortDescription());
                            if(player.getCurrentRoom().getImageName()!=null){
                                gui.showImage(player.getCurrentRoom().getImageName());
                            }
                            //set ok to false so players need to win the challenges to move to the next location
                            if(player.getCurrentRoom().getShortestDescription()=="in the Nighthowlers' Lab"){
                                gui.println("It was dead silent in the lab. You've never been in here before, as only the Nighthowler wolves have access.");
                                gui.println("But, you snuck in to investigate. All of a sudden, ");
                                gui.println("BRRRRINNNNGGGGG! BRRRRINNNNGGGGG! CALL FROM NICK");
                                gui.println("Oh no! Your cover is blown! The wolves call security and you can't think of any other plan.");
                                gui.println("Pick up his call by typing 'call' and pressing enter."); 
                            }
                        }
                        ok=false;
                    }
                }
                //give the user feedback
                else{
                    gui.println("Sorry, you can't move to the next room yet.");
                }
            }
            else if (commandWord.equalsIgnoreCase("quit")) {
                if(command.hasSecondWord()){
                    gui.println("Quit what?");
                }
                else{
                    endGame();
                }
            }
            else if(commandWord.equalsIgnoreCase("look")){
                look();
            }
            else if(commandWord.equalsIgnoreCase("take")){
                if((player.getNumOfItems() == 1)&&((fight.getKick() == "You beat Gideon!") ||(berries==true)||(fight.getPunch() == "You beat Gideon!")||(apt.getGuess(guessNum))=="Yay! You entered the apartment by correctly guessing the code!")||(donut.getString(guessDonut) == "Yay! You entered the correct donut that is in Clawhauser's neck!")){
                    gui.println(player.take(command));
                    if(player.getNumOfItems()==1){
                        ok = true;
                    }
                }
                else{
                    gui.println("Sorry, you can't take anything at this moment...");
                }
            }  
            //this command is for the Nighthowler Lab setback when Judy gives up on her dream temporarily
            else if(commandWord.equalsIgnoreCase("call")){
                if(player.getCurrentRoom().getShortestDescription()=="in the Nighthowlers' Lab"){
                    gui.println("You: Nick! What's your problem? You just blew my cover!");
                    gui.println("Nick: How is that my fault? But Judy, I have a lead on the case! The Nighthowlers are plants, not wolves!");
                    gui.println("They look like the color of...a blueberry!");
                    gui.println("You: I can't believe you. You know, you were right, doubting me and my dreams...");
                    gui.println("...Maybe bunnies just shouldn't become cops.");
                    gui.println("Nick: You know I didn't mean...");
                    gui.println("You: It's fine. I'm out of here. I'll 'go next'");
                    ok = true;
                }
                else{
                    gui.println("You don't need to call right now!");
                }
            }
            else if(commandWord.equalsIgnoreCase("drop")){
                //I don't want players to drop important items throughout the game, because the items are needed in later levels.
                //so far the players can only drop the donut in the car mini game.
                if(player.getCurrentRoom().getShortestDescription()=="in Little Rodentia, where you are assigned parking duty"){
                    if(player.drop(command).equals("You've dropped the donut that is really dense")){
                        gui.println("Great idea, using the donut as handcuffs! You will be a great police officer");
                        gui.println("It turns out the thief was stealing Fru Fru's new clothes, so she wants to thank you.");
                        gui.println("Fru Fru promises to return the favor in the future. In the meantime, 'go next'");
                        saved = true;
                        ok=true;
                    }
                    else{
                        gui.println("You don't need to drop that!");
                        player.take(command); 
                    }
                }
                else if(player.getCurrentRoom().getShortestDescription()=="at the ice cream shop"){
                    if(player.drop(command).equals("You've dropped the badges that give you super-secret access to police files")){
                        gui.println("Nick: Oh, you really are a cop...");
                        gui.println("You: Yeah, and in order to repay me, give me information about a missing mammal case: Mr. Otterton");
                        gui.println("Nick: Fine. First, you must go to Mystic Spring Oasis. Otterton was a regular there.");
                        gui.println("Nick: He did a whole bunch of yoga poses, especially "+ yoga.getRoutine()); 
                        gui.println("Nick: I would 'go next' to continue solving.");
                        gui.println("You: Alright, thanks for the help, sly fox. I wonder if Nick just gave me a clue...");
                        clue.setClue("The yoga pose is " + yoga.getRoutine());
                        ok=true;
                    }
                    else{
                        gui.println("You don't need to drop that!");
                        player.take(command);
                    }
                }
                //want players to chase Bellwether and get hurt before using the blueberry juice
                else if((player.getCurrentRoom().getShortestDescription()=="in the Natural History Museum")&&(chase==true)){
                    if(player.drop(command).equals("You've dropped the blueberry that is from Gideon's farm")){
                        gui.println("Good idea, you will pretend you got hit with the serum and use blueberry juice instead to trick Bellwether!");
                        gui.println("Bellwether: Watch out Hopps! It is time for you to turn savage!");
                        gui.println("She started shooting at you, and you faked getting hit.");
                        gui.println("You: Noooo! I'm turning savage!");
                        gui.println("You growled and scared Bellwether, making her drop the rest of the savage-inducing serum.");
                        gui.println("You: It's over, Bellwether. Any last words before I put you in jail?");
                        gui.println("You searched your pockets for handcuffs and hit 'record' on your pen to record Bellwether's confession.");
                        gui.println("Bellwether: I really thought we could be friends, Judy. But I just want domination. I want to rule Zootopia.");
                        gui.println("The only way to do so was to eliminate any potential threats.");
                        gui.println("So I made other animals go savage, including Manchas and Otterton. Mwa ha ha!");
                        gui.println("You: You almost got away with it. But, I caught you, so you are going to jail for the rest of your life.");
                        gui.println("I, on the other hand, am going to a Gazelle concert to celebrate my first solved case. 'go next' to celebrate");
                        ok=true;
                    }
                    else{
                        gui.println("You don't need to drop that!");
                        //if for some reason the user types 'drop pen' instead of the blueberry, I add pen back to the inventory/make them 'take' it to reverse their mistake.
                        player.take(command);
                    }
                }
                else if(player.getCurrentRoom().getShortestDescription()=="at a Gazelle concert"){
                    if(player.drop(command).equals("You've dropped the pen that records voices")){
                        gui.println("You: I had recorded Bellwether confessing her evil scheme.");
                        gui.println("Bogo: Wow, what a good idea, Judy. You are one of the best police officers in Zootopia.");
                        gui.println("Judy, Bogo, and all the other animals in Zootopia were able to enjoy the concert..." + "\n" +"that is, all the animals besides Bellwether.");
                        gui.println("Congratulations! You won! Thanks for playing!");
                        ok=true;
                        endGame();
                    }
                    else{
                        gui.println("You don't need to drop that!");
                        player.take(command);
                    }
                }
                else{
                    gui.println("You can't drop anything at this moment. Keep items in your inventory until later use");
                }
            }
            else if(commandWord.equalsIgnoreCase("inventory")){
                gui.println(player.getInven());
            }
            else if(commandWord.equalsIgnoreCase("clue")){
                gui.println(clue.getClue());
            }
            else if(commandWord.equals("talk")){
                talk();
                if(player.getCurrentRoom().getShortestDescription()=="in Rainforest District"){
                    clue.setClue("Nighthowlers are the color of blueberries");
                    ok=true;
                }
                else if(player.getCurrentRoom().getShortestDescription()=="in the bunny fields of Zootopia"){
                    printLocationInfo();
                    berries=true;
                }
            }
            else if(commandWord.equals("pursue")){
                if(player.getCurrentRoom().getShortestDescription()=="in Little Rodentia, where you are assigned parking duty"){
                    printPursue();
                }
                else{
                    gui.println("You do not need to pursue right now");
                }
            }
            else if(commandWord.equals("compliment")){
                //players can compliment either way, whether they actually needed to or not to move on, because players love Fru Fru and want to talk to her.
                //However, players only need to compliment if they did not save her with the thief.
                if(player.getCurrentRoom().getShortestDescription()=="in Tundratown"){
                    gui.println("You: I love your dress");
                    gui.println("Biggs: Guards, please do not ice this bunny anymore. At least she showed kindness to my daughter.");
                    gui.println("You may go next. I hope you find what you are looking for in my limo.");
                    gui.println("You: Why are there claw marks in the limo?");
                    gui.println("Biggs: Perhaps Otterton went savage.");
                    gui.println("You: Savage?");
                    gui.println("Biggs: Yeah. You want more information? Talk to the driver of the limo, Manchas. ");
                    gui.println("He lives in Rainforest District. 'go next' to visit him."); 
                    ok=true;
                    printLocationInfo();
                }
                else{
                    gui.println("You don't need to compliment anyone right now!");
                }
            }
            //add if in museum room
            else if(commandWord.equals("chase")){
                if(player.getCurrentRoom().getShortestDescription()=="in the Natural History Museum"){
                    gui.println("I'm going to catch you, Bellweth...ow! My ankle!");
                    gui.println("How am I going to catch her if I just twisted my ankle?");
                    gui.println("There has to be another way to prove she is the villain. If I can't outrun her, I can outsmart her!");
                    gui.println("I will pretend that Bellwether hits me with the serum and I turn into a savage animal,");
                    gui.println("but I won't actually be hit.");
                    gui.println("What item can I drop that looks like the Nighthowlers? (hint: type 'inventory' to see all your items.)");
                    chase=true;
                }
                else{
                    gui.println("You don't need to chase right now!");
                }
            }
        }
        return wantToQuit;
    }
    
    private void printJokeTwo(){
        gui.println("What do you call a bagel that flies? 1.) everything bagel 2.) blueberry bagel 3.) plane bagel 4.) egg bagel");
    }
    private void printJokeThree(){
        gui.println("What do you call a fake noodle? 1.) spaghetti 2.) imposter 3.) ramen 4.) impasta");
    }
    private void printJokeFour(){
        gui.println("What do you call sad cheese? 1.) blue cheese 2.) cheddar cheese 3.) american cheese 4.) mozzarella");
    }
    private void printJokeFive(){
        gui.println("What do you call cheese that doesn't belong to you? 1.) nacho cheese 2.) cheddar cheese 3.) not your cheese 4.) string cheese");
    }
    private void printJokeSix(){
        gui.println("What do you call a blessed avocado? 1.) guacamole 2.) taco 3.) holy guacamole 4.) nachos");
    }
    private void printJokeSeven(){
        gui.println("What do you call a cold dog? 1.) chihuahua dog 2.) chili dog 3.) shivering dog 4.) bulldog");
    }
    private void printJokeEight(){
        gui.println("What do you call a monkey that loves chips? 1.) chipmonk 2.) chimpanzee 3.) hungry 4.) nacho");
    }
    private void printJokeNine(){
        gui.println("What do you call an elephant that doesn't matter? 1.) zoo 2.) Dumbo 3.) irrelephant 4.) peanut");
    }
    private void printJokeTen(){
        gui.println("What do you call a cow in an earthquake? 1.) milk 2.) milkshake 3.) moo 4.) beef");
    }
    
    //leads users to drop donut
    private void printPursue(){
        if(player.getCurrentRoom().getShortestDescription()=="in Little Rodentia, where you are assigned parking duty"){
            gui.println("You decided to try and stop a thief!");
            gui.println("This is your first time attempting to stop a crime as a police officer!");
            gui.println("But, you unfortunately DONUT have the proper equipment to stop him.");
            gui.println("What round, delicious item is in your inventory that can be used in place of handcuffs?" + "\n" + "Type 'drop' and the item you think can come in handy");
            ok=false;
        }
        else{
            gui.println("You can't pursue right now. Try to 'go next' instead.");
        }
    }
    
    //print response if user types fight command.
    //this must be called before players punch or kick because this generates the correct punch/kick ratio.
    private void printFight(){
        gui.println("You want to fight Gideon Grey! Type punch or kick to fight.");
        //this generates the number of punches vs kicks in the series of strikes.
        gui.println(fight.fightNow());
    }

    //calls show commands method
    private void printHelp() 
    {
        gui.println("Your command words are:");
        gui.println(parser.showCommands());
    }

    //look command prints description. 
    //This is a good shortcut to use if players are stuck because players are able to see the items in a room without completing the mini challenge
    private void look(){
        gui.println(player.getCurrentRoom().getLongDescription());
    }

    //this moves the story line along
    private void talk(){
        gui.println(player.getCurrentRoom().getLongDescriptionConvos());
    }
    
    //print items and characters from Game class without printing location
    private String printItems(){
        return player.getCurrentRoom().roomContains();
    }
    
    //quit boolean determines if game continues to play or not
    private void endGame() 
    {
        gui.println("Thanks for playing. Good bye");
        gui.enable(false);
    }
}
