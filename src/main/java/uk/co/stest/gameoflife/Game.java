package uk.co.stest.gameoflife;

public class Game {

    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void process(int col, int row) {
        //grid.neighbours(col,row);
        grid.killCell(col, row);
    }
}
