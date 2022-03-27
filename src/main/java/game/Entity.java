package game;
import java.awt.Graphics;

public abstract class Entity {

    private float x = 0;
    private float y = 0;
    private int health = 100;
    private int speed = 1;

    public void render(Graphics g) {
        g.drawRect((int) x-10, (int) y-10, 20, 20);
    }
    
    public void update() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setPos(float x, float y) {
        setX(x);
        setY(y);
    }

    public void moveDown()
    {
        y += speed;
    }
    public void moveUp()
    {
        y -= speed;
    }
    public void moveRight()
    {
        x += speed;
    }
    public void moveLeft()
    {
        x -= speed;
    }

}
