import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor {
    public Gnomus() {
        setRotation();
    }
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {   
        int random;
        move(5);
        if(atWorldEdge()) {
            move(-5);
            setRotation();
        } else {
            random = Greenfoot.getRandomNumber(100);
            if (random < 2){
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            if (random > 98){
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        lookForActor();
        lookForGarp();
    }
    private boolean atWorldEdge() {
        int x, i, wx, y, wy;
        
        x = getX();
        y = getY();
        i = getImage().getWidth() / 2;
        wx = getWorld().getWidth() - i;
        wy = getWorld().getHeight() - i;
        if(x <= i) {
            return true;
        } else if(y <= i) {
            return true;
        } else {
            if (x >= wx) {
                return true;
            } else {
                return y >= wy;
            }
        }
    }
    protected void setRotation() {
        if(Greenfoot.getRandomNumber(100) < 50) {
            setRotation(getRotation() + Greenfoot.getRandomNumber(180));
        } else {
            setRotation(getRotation() - Greenfoot.getRandomNumber(180));
        }
    }
    protected void lookForActor() {
        Actor actor;
        
        actor = getOneObjectAtOffset(0, 0, Actor.class);
        if((actor != null)) {
            turn(45);
        }
    }
    protected void lookForGarp() {
        Actor garp;
        
        garp = getOneObjectAtOffset(0, 0, Garp.class);
        if(garp != null) {
            Greenfoot.playSound("scream.mp3");
            getWorld().removeObject(garp);
            Greenfoot.stop();
        }
    }
}
