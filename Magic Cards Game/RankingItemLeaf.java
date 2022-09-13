import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class RankingItemLeaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RankingItemLeaf extends Actor implements IRankingitem
{
    private GreenfootImage caption = new GreenfootImage(700,32);
    private Font headerFont = new Font("Bookman Old Style Bold",Font.PLAIN, 16);
    private Color color = Color.white;
    public RankingItemLeaf(String rank, String player, String score){
        caption.clear();
        caption.setColor(color);
        caption.setFont(headerFont);
        caption.drawString(rank, 170, 16);
        caption.drawString(player, 300, 16);
        caption.drawString(score, 450, 16);
        
    }
    public void act() 
    {
        // Add your action code here.
    } 
     public void addItem(IRankingitem c){}
    public void removeItem(IRankingitem c){}
    public void display(int x, int y){
        RankboardWorld.getInstance().addObject(this, x,y);
        setImage(caption);
       // setLocation(x,y);
        System.out.println(this.getClass().toString());
        System.out.println(getWorld().getClass().toString());
        System.out.println(getX());
        System.out.println(getX());
    }
    public IRankingitem getItem(int i){return null;}
}
