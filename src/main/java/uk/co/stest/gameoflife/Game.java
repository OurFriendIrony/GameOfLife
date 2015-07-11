package uk.co.stest.gameoflife;

public class Game {

    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void process(int col, int row) {
        if (grid.cellIsAlive(col, row) && grid.neighbours(col, row) <= 2)
            grid.killCell(col, row);

        if (grid.neighbours(col, row) == 3)
            grid.birthCell(col, row);
    }
}
