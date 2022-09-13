import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheoryWorld_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheoryWorld_3 extends TheoryWorld
{
    private static GreenfootImage backGround3 = new GreenfootImage("TheoryBG_3.jpg");
    
    public TheoryWorld_3()
    {
        super();
        this.setBackground(backGround3);
        addObject(new WorldSwitchButton("Menu",this.menuworld),700,60);
    }
}
