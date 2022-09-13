import greenfoot.*; 

/**
 * Class BackCurtain will control the back curtain, which moves up or down
 * if the corresponding button hitted.
 * 
 * @author (Chen Shi) 
 * @version 1.0
 */
public class BackCurtain extends Actor
{
    private GreenfootSound mySound = new GreenfootSound("music.mp3");
    private GreenfootImage[] images = new GreenfootImage[7];
    private int imageNumber;
    private int counter;
    private boolean direction;   

    public BackCurtain(Grid grid)
    {
        for(int i = 0; i < images.length; i++) 
        {
            images[i] = new GreenfootImage("" + i + ".png");
        }
        // Counter for Animation
        counter = 0;
        direction = true;
        imageNumber = 0;
        setImage(images[1]);
    }

    public void act()
    {       
        PlayWorld playWorld = (PlayWorld) getWorld();
        PlayerWorldButton nextButton = playWorld.getButton();
        if (playWorld.getGrid().isExpanded() &&nextButton.getStage()=="grid expend")
        {
            if (direction)
            {
                animationDown();
                //System.out.println("Animating down....");
            }
            else
            {
                animationUp();
                //startTimerForGame();
            }
            counter++;
        }
    }
    
    // public void startTimerForGame()
    // {
        // PlayWorld theCurtainScenario = (PlayWorld) getWorld();
        // //theCurtainScenario.startTimerForGame();
    // }

    //the animation to make the back curtain move down
    public void animationDown()
    {
        if (counter % 20 == 0)
        {
            mySound.play();
            imageNumber = (imageNumber + 1) % images.length;
            setImage(images[imageNumber]);
            
            System.out.println("curtain close #" + imageNumber); 
            if (imageNumber == images.length - 1)
            {
                direction = false;
                PlayWorld theCurtainScenario = (PlayWorld) getWorld();
                Grid theGrid = theCurtainScenario.getGrid();
                System.out.println("--- flipping from back curtain ---");
                Greenfoot.delay(25);
                System.out.println("--- ask to flip ---");
                theGrid.flipRandomly();
            }
            //Greenfoot.delay(50);
        }
    }

    //the animation to make the back curtain move up
    public void animationUp()
    {
        PlayWorld theCurtainScenario = (PlayWorld) getWorld();
        PlayerWorldButton nextButton = theCurtainScenario.getButton();
        if (counter % 20 == 0)
        {
            imageNumber = (imageNumber + 1) % images.length;
            setImage(images[ 6 - imageNumber]);
            System.out.println("curtain open #" + (6 - imageNumber)); 
            
            if (imageNumber == 6)
            {
                
                direction = true;
                nextButton.setStage("guess stage");

                getWorld().setPaintOrder(TimerActor.class,Message.class,Card.class,ActionButton.class, FrontCurtain.class, BackCurtain.class);

            }
        }        
    }
}
