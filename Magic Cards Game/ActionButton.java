import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionButton extends Actor
{
    /**
     * Act - do whatever the ActionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage image;
    protected GreenfootImage hoverImage;
    protected GreenfootImage onPressImage;
    protected void mouseAction() 
    {
        // Add your action code here.
        if(Greenfoot.mouseMoved(this)){
            setImage(this.hoverImage);
        }else{
            setImage(this.image);
        }
        if(Greenfoot.mousePressed(this)){
             setImage(this.onPressImage);
        }
        
    }
    public ActionButton withSize(int width, int height){
        getImage().scale(width,height);
        return this;
    }
}
