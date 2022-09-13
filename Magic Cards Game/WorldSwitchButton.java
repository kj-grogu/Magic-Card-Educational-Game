import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;
/**
 * Write a description of class WorldSwithButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldSwitchButton extends ActionButton
{

    private World world;
    private String title;
    /**
     * WorldSwitchButton - class constructor
     * @param title - String of button image name, make should it has additional images for "<Title>_highlight.png" and "<Title>_OnPress.png"
     * @param w - A World object that this button will navigate to 
     */
    public WorldSwitchButton(String title, World w){
        this.world = w;
        this.title=title;
        this.image = new GreenfootImage(title+".png");
        this.hoverImage = new GreenfootImage(title+"_highlight.png");
        this.onPressImage = new GreenfootImage(title+"_OnPress.png");
        setImage(this.image);
    }
     /**
     * Act - animate clicking action and click button will going to the target world.
     */
    public void act() 
    {
        // Add your action code here.
        mouseAction();
        if(Greenfoot.mouseClicked(this)){
          System.out.println(title +"clicked");
          NewPlayer();
          askReset();
          Greenfoot.setWorld(this.world);
        }
    }
    private void NewPlayer(){
        if(this.world.getClass().equals(WaitingWorld.class)){
                if(Player.object==null){
                     String playerName = JOptionPane.showInputDialog("enter your name");
                     new Player(playerName);
                }
        }
    }
    private void askReset(){
        if(getWorld().getClass().equals(RankboardWorld.class)){
            //send out the request to server to reset the state
            
        }
    }
}
