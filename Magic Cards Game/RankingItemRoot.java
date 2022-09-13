import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.*;
/**
 * Write a description of class RankingItemRoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RankingItemRoot extends Actor implements IRankingitem
{
    private ArrayList<IRankingitem> rankingitems = new ArrayList<IRankingitem>();
    private GreenfootImage caption = new GreenfootImage(700,40);
    private Font headerFont = new Font("Comic Sans Ms Bold",Font.PLAIN, 20);
    private Color color = Color.ORANGE;
    public RankingItemRoot(){
        caption.clear();
        caption.setColor(color);
        caption.setFont(headerFont);
        caption.drawString("User Name", 150, 30);
        caption.drawString("Time(ms)", 300, 30);
        caption.drawString("Result", 450, 30);
        
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void addItem(IRankingitem c){
        rankingitems.add(c);
    }
    public void removeItem(IRankingitem c){
         rankingitems.remove(c);
    }
    public void display(int x, int y){
        RankboardWorld.getInstance().addObject(this, x,y);
        setLocation(x,y);
        setImage(caption);
        System.out.println(getWorld().getClass().toString());
        System.out.println(getX());
        System.out.println(getX());
        int i=1;
        for(IRankingitem item: rankingitems){
            item.display(x,y + 30*i);
            i++;
        }
    }
    public IRankingitem getItem(int i){return rankingitems.get(i);}
}
