import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaitingScoreWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaitingScoreWorld extends World
{
    private boolean playerHere = false;
    private GameProxy gameProxy;
    private boolean playerAdded = false;
    private String playerName;
     private static WaitingScoreWorld waitingScoreWorld = null;

    public WaitingScoreWorld()
    {
        super(800, 600, 1);
        gameProxy = new GameProxy();
        setBackground(new GreenfootImage("WaitingWorldBG.jpg"));
        this.waitingScoreWorld = this;
    }
    
    public static WaitingScoreWorld getInstance(){
        if( waitingScoreWorld == null){
            new WaitingScoreWorld();
        }
        return waitingScoreWorld;
    }
    
    public boolean hasSecondPlayerSubmitted(){
     String  status = gameProxy.getGameState(); 
     return (status.equals("Game Finished State")) || (status.equals("Player One Recieved Score State"));
    }
    
    public void act()
    {   
        if (!hasSecondPlayerSubmitted())
        {
            Message message = new Message(" Waiting for second player to Submit .     ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Waiting for second player to Submit ..    ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Waiting for second player to Submit ...   ");
            addObject(message, 400, 500); 
            Greenfoot.delay(50);
            removeObject(message);
        }
        else
        {
            RankboardWorld rankboardWorld = new RankboardWorld();
            
            Greenfoot.setWorld(rankboardWorld);
        }
    }
}
