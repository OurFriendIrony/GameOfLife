package uk.co.stest.gameoflife;

public class CellGrid {

    private Cell[][] cells;

    public CellGrid() {
        this(3, 3);
    }

    public CellGrid(int height, int width) {

        cells = new Cell[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                cells[i][j] = new Cell();
    }

    public int getWidth() {
        return cells[0].length;
    }

    public int getHeight() {
        return cells.length;
    }

    public Cell getCell(int x, int y) {
        return cells[x - 1][y - 1];
    }

    public void birthCell(int x, int y) {
        cells[x - 1][y - 1].live();
    }

    public void killCell(int x, int y) {
        cells[x - 1][y - 1].die();
    }
}
