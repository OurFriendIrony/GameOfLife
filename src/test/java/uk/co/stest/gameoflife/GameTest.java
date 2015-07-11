package uk.co.stest.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    //    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    //    Any live cell with two or three live neighbours lives on to the next generation.
    //    Any live cell with more than three live neighbours dies, as if by overcrowding.
    //    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    @Test
    public void cellWithNoNeighboursIsKilled() {
        SpyGrid grid = new SpyGrid(0);
        Game game = new Game(grid);
        game.process(1, 1);
        assertThat(grid.cellKilled).isTrue();
    }

    private class SpyGrid implements Grid {

        private final int neighbours;
        public boolean cellKilled = false;
        public boolean cellBirthed = false;

        SpyGrid(int neighbours) {
            this.neighbours = neighbours;
        }

        @Override
        public int getHeight() {
            return 0;
        }

        @Override
        public int getWidth() {
            return 0;
        }

        @Override
        public Cell getCell(int x, int y) {
            return null;
        }

        @Override
        public void birthCell(int x, int y) {
            cellBirthed = true;
        }

        @Override
        public void killCell(int x, int y) {
            cellKilled = true;
        }

        @Override
        public int neighbours(int col, int row) {
            return neighbours;
        }
    }

}