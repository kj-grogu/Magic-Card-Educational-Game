import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TheoryWorld_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheoryWorld_1 extends TheoryWorld
{
    private static GreenfootImage backGround1 = new GreenfootImage("TheoryBG_1.jpg");
    private World theoryWorld_2(){
        if(TheoryWorld.worlds.size()<2){
            new TheoryWorld_2();
        }
        return TheoryWorld.worlds.get(1);
    }
    
    public TheoryWorld_1()
    {
        super();
        this.setBackground(backGround1);
        
        WorldSwitchButton forwardArrow = new WorldSwitchButton("rightarrow",theoryWorld_2());
        addObject(forwardArrow, 700, 60);
    }
}
