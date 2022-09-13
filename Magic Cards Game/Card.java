import greenfoot.*;
import java.util.Random;
import java.awt.Color;
public class Card extends Actor
{
    protected final int imageX = 30;
    protected final int imageY  = 30;
    protected GreenfootImage image;
    private boolean flipped;
    protected boolean faceup;  
    private boolean isSelected = false;
    public int col;
    public int row;
    
    public Card(){
        Random r = new Random();
        this.faceup = r.nextBoolean();
        this.flipped = false;
        System.out.println("at creation faceup "+this.faceup);
        updateCard();
    }
    public Card(int row,int col){
       // Random r = new Random();
        this.faceup = false;//r.nextBoolean();
        this.flipped = false;
        this.col = col;
        this.row = row;
        System.out.println("at creation faceup "+this.faceup);
        updateCard();
    }
    
    
      public void flipCard(){
   //     if(!this.flipped){
            this.faceup = !this.faceup;
            this.flipped = true;
            System.out.println("at flip IsFaceUp "+faceup);
            updateCard();
    //    }
        
    }
  
    protected void updateCard(){
         if(this.faceup){
             this.image = new GreenfootImage("red.png");
        }
        else{
            this.image = new GreenfootImage("blackspade.png");
        }
        setImage(this.image);
    }
    
    public boolean isFacingUp(){
        return this.faceup;
    }
    
    public void updateExtraCard(){
        this.faceup = false;
        image = new GreenfootImage("blackspade.png");
        setImage(image);
    }
    
    public void selectCard(){
        if(this.faceup){
             image = new GreenfootImage("karo-highlight.png");
        }
        else{
            image = new GreenfootImage("pik-highlight.png");
        }
        setImage(image);
        isSelected = true;
    }
    public void unselectCard(){
        if(this.faceup){
             image = new GreenfootImage("red.png");
        }
        else{
            image = new GreenfootImage("blackspade.png");
        }
        setImage(image);
        isSelected =false;
    }
    
    public boolean isFlipped(){
        return this.flipped;
    }
    
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void circleit(){
        getImage().setColor(Color.black);
        getImage().drawOval(1,1,47,47);
         getImage().drawOval(2,2,45,45);
          getImage().drawOval(3,3,43,43);
          getImage().drawOval(4,4,41,41);
    }
    public void act() 
    {
            
    }    
}