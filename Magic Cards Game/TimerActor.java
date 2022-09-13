import greenfoot.*;
import java.awt.*;
public class TimerActor extends Actor {
    private boolean running = false;
    private int millisElapsed = 0;
    private long lastTime = 0;
    
    public TimerActor() {
        updateImage();
    }
    
    public void start() {
        millisElapsed = 0;
        lastTime = 0;
        running = true;
    }
    
    public void gamePaused() {
        lastTime = 0;
    }
    
    public void act() {
        if(running){
        long time = System.currentTimeMillis();
        if(lastTime != 0) {
            long diff = time - lastTime;
            millisElapsed += diff;
        }
        lastTime = time;
        
        updateImage();
       }
    }
    
    public void updateImage() {
        // Calculate minutes & seconds elapsed
        int millis = millisElapsed % 1000;
        int secs = (millisElapsed / 1000) % 60;
        int mins = millisElapsed / 60000;
        // Convert these into text
        String millisText = String.format("%03d", millis);
        String secsText = String.format("%02d", secs);
        String minsText = "" + mins;
        String text = minsText + ":" + secsText + "." + millisText;
        // Update the image
        GreenfootImage img = new GreenfootImage(text, 25, null, Color.white);
        setImage(img);
    }
    public void stopTimer(){
        running = false;
    }
    public int getElapseTime(){
        return millisElapsed;
    }
    public boolean getStatus(){
        return running;
    }
}
