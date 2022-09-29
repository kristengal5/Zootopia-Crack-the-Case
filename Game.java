
/**
 * Create instances of UserInterface and GameEngine.
 *
 * @Kristen Gallagher
 * @version 6
 */
public class Game
{
    private UserInterface gui;
    private GameEngine engine;

    /**
     * Create the game and initialise its internal map
     */
    public Game()
    {
        engine = new GameEngine();
        gui = new UserInterface(engine);
        engine.setGUI(gui);
    }

}
