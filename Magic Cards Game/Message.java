import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{   
    public Message()
    {
        updateImage("");
    }
    
    public Message(String text)
    {
        updateImage(text);
    }
    
    public void updateImage(String text)
    {
        getImage().clear();
        setImage(new GreenfootImage(text, 30, Color.black, Color.white));
    }     
}
