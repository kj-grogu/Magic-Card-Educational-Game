import greenfoot.*; 
import java.util.ArrayList;

public class Stars extends Actor implements StarComponent
{
    private ArrayList<StarComponent> fiveStars;
    private int[][] location = { {700, 550}, {700, 420}, {650, 300}, {550, 200}, {400, 150}, 
            {250, 200}, {150, 300}, };

    public Stars()
    {
        fiveStars = new ArrayList<StarComponent>();
    }

    public void act() 
    {

    }   

    public void starsMove()
    {
        for (int i = 0; i < 7; i++)
        {
            int n = i;
            for (StarComponent c : fiveStars)
            {
                if (n >= 0 && n <=6)
                {
                    c.starMove(location[n][0], location[n][1]);                     
                } 
                n--;
            }
            Greenfoot.delay(20);
        }
        AnimationWorld world = (AnimationWorld) getWorld();
        world.setPlayed();
        world.setStarsMoveDone();
    }

    public void starMove(int x, int y)
    {
        //do nothing
    }

    public void addStar(StarComponent c)
    {
        fiveStars.add(c);
    }
}
