import greenfoot.*;  

public class Star extends Actor implements StarComponent
{   
    public Star()
    {
        setImage(new GreenfootImage("star.png"));
    }

    public void act() 
    {        
        turn(100);
    }  

    public void starsMove()
    {
        //do nothing
    }
    
    public void starMove(int x, int y)
    {
        setLocation(x, y);
    }
    
    public void addStar(StarComponent c)
    {
        //do nothing
    }
}

