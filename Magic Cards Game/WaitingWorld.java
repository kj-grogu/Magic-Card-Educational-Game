import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.Color;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;

public class WaitingWorld extends World
{
    private boolean playerHere = false;
    private GameProxy gameProxy;
   // private boolean playerAdded = false;
    private String playerName;
     private static WaitingWorld waitingWorld = null;

    public WaitingWorld()
    {
        super(800, 600, 1);
        gameProxy = new GameProxy();
        setBackground(new GreenfootImage("WaitingWorldBG.jpg"));
        this.waitingWorld = this;
    }
    
    public static WaitingWorld getInstance(){
        if( waitingWorld == null){
            new WaitingWorld();
        }
        return waitingWorld;
    }

    public void showStatus(){
     String  status = gameProxy.getGameState();
     showText(status, 250, 554);
    }
    
    public boolean isPlayerPresent(){
     String  status = gameProxy.getGameState(); 
     if(status == "NoPlayerState"){
         gameProxy.addPlayer(Player.object.getName());
     }
     return status.equals("Game Started State");
    }
    
    // public void addPlayerToGame(String userName){
        // gameProxy.addPlayer(userName); 
    // }
    
    public void act()
    {   
        // if(playerAdded == false){
           // // playerName = JOptionPane.showInputDialog("enter your name");
            
            // addPlayerToGame(Player.object.getName());
            // playerAdded = true;
        // }
        
        if (!isPlayerPresent())
        {
            Message message = new Message("  Hi "+ Player.object.getName() +" Waiting for second player to join .     ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Hi "+  Player.object.getName() +" Waiting for second player to join ..    ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Hi "+  Player.object.getName() +" Waiting for second player to join ...   ");
            addObject(message, 400, 500); 
            Greenfoot.delay(50);
            removeObject(message);
        }
        else
        {
            PlayWorld playWorld = new PlayWorld();
            JSONObject grid = gameProxy.getGrid();
            playWorld.setGrid(grid);
            Greenfoot.setWorld(playWorld);
        }
    }
}
