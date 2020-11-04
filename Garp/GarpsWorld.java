import greenfoot.*;
import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.World;

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpsWorld extends World {
    public static int score = 0;
    private GreenfootSound sound;
    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        populateTheWorld();
    }
    public void act() {     
        showText("Score: " + score, 50, 475);
    }
    protected void populateTheWorld() {
        addObject(new Garp(),350,250);
        addObject(new Gnomus(),Greenfoot.getRandomNumber(670) + 15,Greenfoot.getRandomNumber(470) + 15);
        sound = new GreenfootSound("Zelda.mp3");
        for(int teller = 0; teller < 4; teller++) {
            addObject(new Bomb(),Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
        for(int teller = 0; teller < 6; teller++) {
            addObject(new Rock(),Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
        for(int teller = 0; teller < 10; teller++) {
            addObject(new Diamant(),Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
    }
    public void started() {
        sound.playLoop();
    }
    public void stopped() {
        sound.stop();
        score = 0;
    }
}
