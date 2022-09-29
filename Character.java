
/**
 * 
 * This deals with additional characters besides Judy Hopps, since players take the role of Judy.
 *
 * @Kristen Gallagher
 * @version 6
 */
public class Character
{
    private String descriptionOfChar;
    private String homeOfChar;
    private String nameOfChar;

    public Character(String nameOfChar, String descriptionOfChar, String homeOfChar)
    {
        this.nameOfChar = nameOfChar;
        this.descriptionOfChar = descriptionOfChar;
        this.homeOfChar = homeOfChar;
    }

    public String getCharacterDescription()
    {
        return nameOfChar + ", a " + descriptionOfChar + " who lives in " + homeOfChar+".";
    }
    
    public String getCharacterName(){
        return nameOfChar;
    }
}
