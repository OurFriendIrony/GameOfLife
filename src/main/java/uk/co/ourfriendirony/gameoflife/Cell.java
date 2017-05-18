package uk.co.ourfriendirony.gameoflife;

public class Cell {

    private boolean alive = false;

    public boolean isAlive() {
        return alive;
    }

    public void live() {
        alive = true;
    }

    public void die() {
        alive = false;
    }
}
