import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerWorldButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWorldButton extends ActionButton
{
    private TimerActor t;
    private String stage;
    public PlayerWorldButton(TimerActor t){
        this.t = t;
        this.image = this.hoverImage = onPressImage = new GreenfootImage("rocket.png");
        this.stage = "game start";
        setImage(image);
    }
    public void act() 
    {
        mouseAction();
        if(stage =="wait for player")
        {
            //do nothing but wait for the game start
        }
        else if(stage == "game start"){
            //display instruction and expending grid --> move stage to "grid expend"
           if (Greenfoot.mouseClicked(this)){
            stage = "grid expend";
            System.out.println("  butttons is gerttign preseed ");
            PlayWorld  playWorld = (PlayWorld) getWorld();
            Magician magician =  playWorld.getMagician();
            magician.operateGrid();
       
            getWorld().addObject(t,100,100);
           // getWorld().setPaintOrder(TimerActor.class,Card.class,ActionButton.class, FrontCurtain.class, BackCurtain.class);
            System.out.println(stage);
            //t.start();
            //stage = "guess stage";
           }
        }
       else if(stage == "grid expend"){
            //curtain down and flip the card
        }
       else if(stage == "guess stage"){
            //player make a guess when click button to
             if(Greenfoot.mouseClicked(this)){
                 System.out.println(this.getClass().toString() +"clicked");
                 if(t.getStatus() == false){
                     t.start();
                    }else{
                        t.stopTimer();
                         System.out.println(t.getElapseTime());
                        System.out.println(Player.object.toString());
                        Player.object.setScore(t.getElapseTime());
                        stage = "complete guess";
                        System.out.print("username:"+ Player.object.getName()+"\nscore:");
                        System.out.println (Player.object.getScore());
               ///setImage(new GreenfootImage(new Integer(t.getElapseTime()).toString(), 25, null,null));
                   }
         
               }
        }
       
    }
   public void setStage(String stage){
       if(stage == "guess stage"){
           t.start();
        }
       this.stage = stage;
    }
   public String getStage(){
       return this.stage;
    }
}
