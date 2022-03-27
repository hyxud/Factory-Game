package game;

public class Player extends Entity {
    private boolean up, down, left, right = false;
    
    public void move() {
        if (down) {
            moveDown();
        }
        if (up) {
            moveUp();
        }
        if (right) {
            moveRight();
        }
        if (left) {
            moveLeft();
        }
    }

    @Override
    public void update() {
        move();
        super.update();
    }


    public boolean isUp() {
        return up;
    }


    public void setUp(boolean up) {
        this.up = up;
    }


    public boolean isDown() {
        return down;
    }


    public void setDown(boolean down) {
        this.down = down;
    }


    public boolean isLeft() {
        return left;
    }


    public void setLeft(boolean left) {
        this.left = left;
    }


    public boolean isRight() {
        return right;
    }


    public void setRight(boolean right) {
        this.right = right;
    }
}
