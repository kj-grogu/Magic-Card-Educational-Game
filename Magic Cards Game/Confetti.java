import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Confetti here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Confetti extends Actor
{   
    private boolean notSet;
    
    public Confetti()
    {
        setImage(new GreenfootImage("title.png"));
        notSet = true;
    }

    public void act() 
    {
        if (this.getX() != 400)
        {
            move(30);
        }
        else
        {
            AnimationWorld world = (AnimationWorld) getWorld();
            world.setAllDone();
            if (notSet)
            {
                world.setMainCounter();
                notSet = false;
            }
        }
    }    
}
