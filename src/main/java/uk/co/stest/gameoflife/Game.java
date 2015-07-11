package uk.co.stest.gameoflife;

public class Game {

    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void process(int col, int row) {
        if (underPopulated(col, row))
            grid.killCell(col, row);

        if (repoductivelyIdeal(col, row))
            grid.birthCell(col, row);
    }

    private boolean repoductivelyIdeal(int col, int row) {
        return !grid.cellIsAlive(col, row) && grid.neighbours(col, row) == 3;
    }

    private boolean underPopulated(int col, int row) {
        return grid.cellIsAlive(col, row) && grid.neighbours(col, row) < 2;
    }
}
