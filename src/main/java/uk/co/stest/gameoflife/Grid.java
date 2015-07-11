package uk.co.stest.gameoflife;

public interface Grid {

    int getHeight();
    int getWidth();
    boolean cellIsAlive(int x, int y);
    void birthCell(int x, int y);
    void killCell(int x, int y);
    int neighbours(int col, int row);

}
