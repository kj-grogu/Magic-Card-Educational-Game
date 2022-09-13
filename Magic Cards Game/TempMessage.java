import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempMessage extends Message
{
    private int timer;
 
    public TempMessage(String text)
    {
        super(text);
    }
 
    public void act()
    {
        timer++;
        if (timer == 10) 
        {
            getWorld().removeObject(this);
        }
    }
}  