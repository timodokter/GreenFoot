import greenfoot.*;
import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.World;
import java.awt.*;

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpsWorld extends World {
    public static int score = 0;
    private GreenfootSound sound;
    private EndScore endScore;
    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld() {    
        super(700, 500, 1); 
        populateTheWorld();
    }
    public void act() {
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
        setPaintOrder(Text.class, EndScore.class, Garp.class, Gnomus.class, Diamant.class, Bomb.class, Rock.class);
        addObject(new Text(), 50, 475);
        repaint();
    }
    public void started() {
        sound.playLoop();
        endScore = new EndScore();
        repaint();
    }
    public void stopped() {
        endScore.setEndImage();
        addObject(endScore, getWidth() / 2, getHeight() / 2);
        sound.stop();
        score = 0;
        if (score == 10) {
            Greenfoot.stop();
            removeObject(new Text());
        }
    }
    public int getscore() {
        return this.score;
    }
}
