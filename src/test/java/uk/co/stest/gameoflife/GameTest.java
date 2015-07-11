package uk.co.stest.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private SpyGrid grid;
    private Game game;

    @Test
    public void deadCellWithNoNeighboursStaysDead() {
        grid = new SpyGrid(false, 0);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1));
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isFalse();
    }

    //    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    //    Any live cell with two or three live neighbours lives on to the next generation.
    //    Any live cell with more than three live neighbours dies, as if by overcrowding.
    //    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    private class SpyGrid implements Grid {

        private final int neighbours;
        public boolean cellKilled = false;
        public boolean cellBirthed = false;
        private boolean state;

        SpyGrid(boolean state, int neighbours) {
            this.state = state;
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
        public boolean cellIsAlive(int x, int y) {
            return state;
        }

        @Override
        public void birthCell(int x, int y) {
            state = true;
            cellBirthed = true;
        }

        @Override
        public void killCell(int x, int y) {
            state = false;
            cellKilled = true;
        }

        @Override
        public int neighbours(int col, int row) {
            return neighbours;
        }
    }

}