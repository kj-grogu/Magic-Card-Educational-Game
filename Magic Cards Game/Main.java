import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main extends World
{
    public static ArrayList<Main> menuworlds = new ArrayList();

    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(800, 600, 1);
       setBackground(new GreenfootImage("background5.jpg"));
        this.menuworlds.add(this);  
        System.out.println(menuworlds.size());
        addObject(new WorldSwitchButton("Play",new WaitingWorld()),385,330);
        addObject(new WorldSwitchButton("Theory",TheoryWorld.getInstance()),385,430);
    }
    
        public static Main getInstance() {
          System.out.print("Menuworld ");  
          System.out.println( menuworlds.size());
          if(menuworlds.isEmpty())
            new Main();
           return menuworlds.get(0);

     }
    
   
}
