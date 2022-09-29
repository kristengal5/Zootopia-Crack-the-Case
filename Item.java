
/**
 * 
 * This deals with the items in the game. Items have a name and description.
 * 
 * @Kristen Gallagher
 * @version 6
 */
public class Item
{
    private String description;
    private int weight;
    private String name;

    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getItemDescription()
    {
        return "the " + name + " that " + description;
    }
    
    public String getItemEasy()
    {
        return name;
    }
}
