
/**
 * This holds conversations with various characters, depending on the characters present in the current room.
 *
 * @Kristen Gallagher
 * @version 6
 */

public class Conversations
{ 
    public String talk(Character character){
        String text="Sorry, there is nobody to talk with.";
        if (character.getCharacterName() == "Gideon Grey"){
            text="Gideon: Hey Judy, I heard you want to become a BUNNY cop...Ha! " + "\n" + "\t"+ "That is the most stupidest thing I ever heard." 
            + "\n" + "\t"+"Can you even beat me in a fight? Type fight and press enter to find out.";
        }
        else if(character.getCharacterName()=="Landlord"){
            text="Landlord: Make sure you pay your rent on time every month! No exceptions." + "\n" + "\t"+
            "You: But, the door is locked! Don't you have the combination?" + "\n" + "\t" + 
            "Landlord: Oh well, figure it out. Type the 3-digit combination to try to enter your apartment.";
        }
        else if(character.getCharacterName() == "Officer Clawhauser"){
            text = "Officer Clawhauser: O...M...G. You are SO ADORABLE." + "\n"+"\t"+ 
            "You would probably fit right in with Assistant Mayor Bellwether..."+ "\n"+"\t"+"...or, maybe not, since she can act a bit strangely sometimes." + "\n" + "\t" + 
            "Anyway, your main assignment for the next few hours is to solve a missing mammal case." + "\n"+"\t"+"Mr. Otterton recently went missing." + "\n" + "\t" + 
            "Nobody knows where he is or why he left his family." + "\n" + "\t" +
            "You: Thanks for the tip about Bellwether, and I will be sure to find him!" + "\n"+"\t"+"On a side note, is that a donut in your neck?" + "\n"+"\t"+ 
            "Clawhauser: Wanna play a game? Guess the number of the flavor stuck in there." + "\n"+
            "Type the number according to the menu and press enter in order to guess: "+ "\n"+"\t"+ "1. strawberry, 2. chocolate, 3. vanilla, 4. funfetti, 5. glazed, 6. jelly, 7. powdered, 8. coconut";
        }
        else if(character.getCharacterName()=="Fru Fru"){
            text="Fru Fru: I was just shopping at the mall, but I noticed a ton of cars with expired parking." + "\n" + "\t"+
            "Do you think you can bust those criminals?" + "\n" + "\t"+"Type the number, 1 through 20, of a car you think is expired, and press enter." +"\n"+"\t"+
            "You must find ten cars with expired parking in total." + "\n" + "\t" + 
            "A graphic will appear where dashes represent cars, " + "\n" + "\t"+"and dashes with expired parking that you guess will change to 'X' as you guess them." + "\n" + "\t"+
            "You: I'm in the middle of a missing mammal case, but I can find ten cars before continuing.";
        }
        else if(character.getCharacterName()=="Yax"){
            text="Yax: Hi! I practice yoga all day at the Oasis. Want to practice yoga with me? " + "\n" + "\t"+"Guess my favorite pose!" + "\n" + "\t" +
            "You: But I don't even know any yoga! And I really just need your help with a case." + "\n" + "\t" +
            "Yax: Oh, right. Pick a number from this list, then press enter. " + "\n" + "\t"+"Keep guessing until correct, then I will help you out." + "\n" + "\t" +
            "1. downward dog 2. warrior pose 3. crow 4. child's pose 5. tree" + "\n" + "\t"+ "6. baby cobra 7. locust 8. camel 9. pigeon 10. rabbit";
        }
        else if(character.getCharacterName()=="Flash"){
            text="Flash: It's..." + "\n"+ "...nice..."+ "\n"+ "...to..."+
            "\n"+ "...meet..." + "\n"+ "...you"+ "\n"+
            "You: Please, can we speed this up a bit? I need you to run a plate for me."+ "\n"+
            "Flash: Not...without...answering...some...jokes!" + "\n" + "\t" +
            "Answer ten of my jokes and then I'll give you the owner's name!"+ "\n"+
            "You: What!?! I don't have that kind of time!"+ "\n"+
            "Flash: Fine. Ten jokes is a lot. " + "\n" + "\t"+"If you can answer three correctly, I will let you off the hook and give the owner's info." + "\n" + "\t" +"What do you call a 3-humped camel? 1.) fat 2.) pregnant 3.) different 4.) endangered";
        }
        else if(character.getCharacterName()=="Mr. Biggs"){
            text="Mr. Biggs: Welcome to Tundratown. What do you need?"+ "\n" + "\t" +
            "You: Well, I was actually hoping to search one of your limos. " + "\n" + "\t"+"I believe Mr. Otterton rode in one the night he went missing." + "\n" + "\t" +
            "Biggs: Otterton? He was a good friend of mine. Of course you can search my limos. " + "\n" + "\t"+"My limos are the newest models and are made from..." + "\n" + "\t" +
            "You: Actually, I really just need to get searching." + "\n" + "\t" +
            "Biggs: WAIT! I have been so lonely recently. " + "\n" + "\t"+"My daughter is getting married tonight and I am going to miss living with her. " + "\n" + "\t"+"I really need a friend." + "\n" + "\t" +
            "You: How can I help?" + "\n" + "\t" + 
            "Biggs: Well, do you like music? Guess my favorite singer:"+ "\n" + "\t" + "1. Taylor Swift 2. Ed Sheeran 3. Ariana Grande 4. Billie Eilish 5. Justin Bieber" + "\n" + "\t"+"6. Dua Lipa 7. Katy Perry 8. Bruno Mars 9. Elvis 10. Adele";
        }
        else if(character.getCharacterName()=="Manchas"){
            text="Manchas: Whaddya want?" + "\n" + "\t" + "You: Actually, I was just hoping for some help. Do you know anything about Mr. Otterton?" + "\n" + "\t" + "..."+
            "\n" + "\t" + "Manchas, is everything ok in there?" + "\n" + "\t" + "Manchas: It's the Nighthowlers...The Nightholwers make animals savage...aaahhhhhh! " + "\n" + "\t"+"Get away!" + "\n" + "\t" + "You: Manchas? MANCHAS?" + "\n" + "\t" +
            "You notice that Manchas looks scarier than before." + "\n" + "\t" +"What happened to him? Did Manchas just turn savage? You need to run and get out of here!" + "\n" + "\t" + "Perhaps he meant go to the Nighthowlers' Lab! " + "\n" + "\t"+
            "You look around for an escape...and notice monkey bars! " +
            "\n" + "\t" + "You swing as fast as you can in an effort to leave Rainforest District, " + "\n" + "\t"+"but you want to learn more about the Nighthowlers." + "\n" + "\t" + "You swing to the Nighthowlers' lab. 'Go next' to investigate there.";
        }
        else if(character.getCharacterName()=="Nick Wilde"){
            text="You: So, what's the best thing to order from this ice cream shop?" + "\n" + "\t" +
            "Nick: I get the JumboPop, since I then resell it to make more money!" + "\n" + "\t" +
            "You: Wait a minute, that sounds so evil! That's against the law!" + "\n" + "\t" +
            "Nick: Yeah, what are you going to do about it, bunny?" + "\n" + "\t" +
            "You: I'm a cop! I can arrest you!" + "\n" + "\t" +
            "Nick: I don't believe you. If you have proof that you're a police officer, drop your badges!";
        }
        else if(character.getCharacterName()=="Old Gideon"){
            text="Gideon: Judy? I haven't seen you in ages!" + "\n" + "\t" + "You: Hey, Gideon. You have your own farms now?" + "\n" + "\t" +
            "Gideon: Yup! Here we have my tomatoes, and carrots, and blueberries over there." + "\n" + "\t" + "You: Wow, good for you!" + "\n" + "\t" +
            "You notice some unusual flowers in his fields. You: What is that blue flower?" + "\n" + "\t" + "Gideon: You haven't seen them? They're Nighthowlers, a new species of flowers."
            + "\n" + "\t" + "They are known to cause strange reactions." + "\n" + "\t" +"You: Strange reactions, as in going savage?" + "\n" + "\t" +  "Gideon: I never thought about it like that, but I guess that's one way of putting it!"
            + "\n" + "\t" +"Oh. My. Gosh. That's what I've been missing this whole time! These are the flowers Nick was talking aboout!"+ "\n" + "\t" +
            "The Nighthowler flower causes animals to go savage! I need to go back to Zootopia!" +"\n" + "\t" + "Gideon: Remember to take some blueberries on the road!";
        }
        else if(character.getCharacterName()=="Bellwether"){
            text="Bellwether: Hey, Judy. What are you doing here?"+ "\n" + "\t" +"Judy: Are you holding a Nighthowler?" + "\n" + "\t" + "Bellwether: How do you know about Nighthowlers?" + "\n" + "\t" +
            "Judy: You're busted, Bellwether." + "\n" + "\t" + "Bellwether: You are going to need to catch me, first! " + "\n" + "\t"+"Type 'chase' and press enter to catch me";
        }
        else if(character.getCharacterName()=="Officer Bogo"){
            text="Bogo: Judy, how were you so successful?" + "\n" + "\t"+"Can you show me the evidence that Bellwether is guilty?" + "\n" + "\t" + 
            "Judy: Of course! The item I used was actually a gift from my parents! " + "\n" + "\t"+"Type 'drop' and the item used and press enter";
        }
        return text;
    }
}
