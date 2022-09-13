import greenfoot.*;
import java.util.ArrayList;

public class AnimationWorld extends World
{
    private GreenfootSound mySound = new GreenfootSound("My Song.mp3");
    private GreenfootImage[] images = new GreenfootImage[2];

    private int counter; 
    private int mainCounter;
    private boolean soundHasPlayed;
    private boolean starsMoveDone;
    private boolean notPlayed;
    private boolean allDone;
    private Stars fiveStars;
    
    private Star star1;
    private Star star2;
    private Star star3;
    private Star star4;
    private Star star5;

    private Confetti confetti;

    public AnimationWorld()
    {    
        super(800, 600, 1, false); 

        for(int i = 0; i < images.length; i++) 
        {
            images[i] = new GreenfootImage("H" + i + ".jpg");
        }

        counter = 0;
        soundHasPlayed = false;
        notPlayed = true;
        starsMoveDone = false;
        allDone = false;
       
        star1 = new Star();
        star2 = new Star();
        star3 = new Star();
        star4 = new Star();
        star5 = new Star();
        addObject(star1, 700, 800);
        addObject(star2, 700, 800);
        addObject(star3, 700, 800);
        addObject(star4, 700, 800);
        addObject(star5, 700, 800);

        fiveStars = new Stars();

        fiveStars.addStar(star1);
        fiveStars.addStar(star2);
        fiveStars.addStar(star3);
        fiveStars.addStar(star4);
        fiveStars.addStar(star5);
        addObject(fiveStars, 700, 800);

        confetti = new Confetti();
    }

    public void act()
    {
        backgroundSetup();

        if (notPlayed)
        {
            fiveStars.starsMove();           
        }

        if (starsMoveDone)
        {
            addObject(confetti, -290, 500);
            starsMoveDone = false;
        }

        if (allDone)
        {
            mainCounter++;
            if (mainCounter == 30 )
            {
                Greenfoot.setWorld(new Main());
            }
        }
    }

    public void backgroundSetup()
    {
        if (!soundHasPlayed)
        {
            mySound.play();
            soundHasPlayed = true;
        }

        if (counter%2 == 0) 
        {
            setBackground(images[0]); 
            Greenfoot.delay(12); 
            counter ++;
        }
        else 
        {
            setBackground(images[1]); 
            Greenfoot.delay(12); 
            counter ++;
        }
    }

    public void setPlayed()
    {
        notPlayed = false;
    }

    public void setStarsMoveDone()
    {
        starsMoveDone = true;
    }

    public void setAllDone()
    {
        allDone = true;
    }

    public void setMainCounter()
    {
        mainCounter = 0;
    }
    
}
