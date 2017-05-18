package uk.co.ourfriendirony.gameoflife;

public class CellGrid implements Grid {

    private Cell[][] cells;

    public CellGrid(int height, int width) {
        cells = new Cell[height][width];
        populateGrid(height, width);
    }

    private void populateGrid(int height, int width) {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                cells[i][j] = new Cell();
    }

    public int getHeight() {
        return cells.length;
    }

    public int getWidth() {
        return cells[0].length;
    }

    public boolean cellIsAlive(int x, int y){
        return cells[x - 1][y - 1].isAlive();
    }

    public void birthCell(int x, int y) {
        cells[x - 1][y - 1].live();
    }

    public void killCell(int x, int y) {
        cells[x - 1][y - 1].die();
    }

    public int neighbours(int col, int row) {
        int ct = 0;

        int toRow = row + 1;
        int fromRow = row - 1;
        int fromCol = col - 1;
        int toCol = col + 1;

        for (int r = fromRow; r <= toRow; r++) {
            for (int c = fromCol; c <= toCol; c++) {
                if (notMe(col, row, c, r) && neighbourIsAlive(c, r))
                    ct++;
            }
        }
        return ct;
    }

    private boolean notMe(int col, int row, int c, int r) {
        if (col != c || row != r)
            return true;
        return false;
    }

    private boolean neighbourIsAlive(int c, int r) {
        if (withinBoundaries(c, r) && cellIsAlive(c, r))
            return true;
        return false;
    }

    private boolean withinBoundaries(int x, int y) {
        try {
            cellIsAlive(x, y);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}
