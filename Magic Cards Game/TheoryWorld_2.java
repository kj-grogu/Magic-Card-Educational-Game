import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TheoryWorld_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheoryWorld_2 extends TheoryWorld
{
    private static GreenfootImage backGround2 = new GreenfootImage("TheoryBG_2.jpg"); 
    private World theoryWorld_3(){
        if(TheoryWorld.worlds.size()<3){
            new TheoryWorld_3();
        }
        return TheoryWorld.worlds.get(2);
    }
    public TheoryWorld_2()
    {
        this.setBackground(backGround2);
        
        WorldSwitchButton forwardArrow = new WorldSwitchButton("rightarrow",theoryWorld_3());
        addObject(forwardArrow, 700, 60);
    }
}
