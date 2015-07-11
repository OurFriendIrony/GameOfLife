package uk.co.stest.gameoflife;

public class Game {

    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void process(int col, int row) {
        if (underPopulated(col, row))
            grid.killCell(col, row);

        if (overPopulated(col, row))
            grid.killCell(col,row);

        if (repoductivelyIdeal(col, row))
            grid.birthCell(col, row);
    }

    private boolean underPopulated(int col, int row) {
        return grid.cellIsAlive(col, row) && grid.neighbours(col, row) < 2;
    }

    private boolean overPopulated(int col, int row) {
        return grid.cellIsAlive(col,row) && grid.neighbours(col, row) > 3;
    }

    private boolean repoductivelyIdeal(int col, int row) {
        return !grid.cellIsAlive(col, row) && grid.neighbours(col, row) == 3;
    }
}
