import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class TheoryWorld extends World
{   
    protected static ArrayList<TheoryWorld> worlds= new ArrayList();
    protected World previousworld;
    protected Main menuworld = Main.getInstance();
    public TheoryWorld()
    {    
        super(800, 500, 1); 
        System.out.println(this.getClass().toString());
        worlds.add(this);
    }
    
    public TheoryWorld(World w)
    {    
        super(800, 500, 1); 
        previousworld = w;
        System.out.println(this.getClass().toString());
        worlds.add(this);
    }
    
    public void act()
    {
        
    }
    public static TheoryWorld getInstance(){
          System.out.print("Theory World "); 
          System.out.println(worlds.size()) ;      
          if(worlds.isEmpty()){
            new TheoryWorld_1();
        }
           return worlds.get(0);
    }
    
}
