package uk.co.ourfriendirony.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private SpyGrid grid;
    private Game game;

    @Test
    public void deadCellWithZeroNeighboursStaysDead() {
        grid = new SpyGrid(false, 0);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isFalse();
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isFalse();
    }

    @Test
    public void deadCellWithThreeNeighboursIsBirthed() {
        grid = new SpyGrid(false, 3);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isTrue();
        assertThat(grid.cellBirthed).isTrue();
        assertThat(grid.cellKilled).isFalse();
    }

    @Test
    public void livingCellWithZeroNeighboursIsKilled() {
        grid = new SpyGrid(true, 0);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isFalse();
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isTrue();
    }

    @Test
    public void livingCellWithTwoNeighboursStaysAlive() {
        grid = new SpyGrid(true, 2);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isTrue();
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isFalse();
    }

    @Test
    public void livingCellWithThreeNeighboursStaysAlive() {
        grid = new SpyGrid(true, 3);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isTrue();
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isFalse();
    }

    @Test
    public void livingCellWithFourNeighboursIsKilled() {
        grid = new SpyGrid(true, 4);
        game = new Game(grid);

        game.process(1, 1);

        assertThat(grid.cellIsAlive(1, 1)).isFalse();
        assertThat(grid.cellBirthed).isFalse();
        assertThat(grid.cellKilled).isTrue();
    }

    //    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    //    Any live cell with two or three live neighbours lives on to the next generation.
    //    Any live cell with more than three live neighbours dies, as if by overcrowding.
    //    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    private class SpyGrid implements Grid {

        private final int neighbours;
        public boolean cellKilled = false;
        public boolean cellBirthed = false;
        private boolean alive;

        SpyGrid(boolean alive, int neighbours) {
            this.alive = alive;
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
            return alive;
        }

        @Override
        public void birthCell(int x, int y) {
            alive = true;
            cellBirthed = true;
        }

        @Override
        public void killCell(int x, int y) {
            alive = false;
            cellKilled = true;
        }

        @Override
        public int neighbours(int col, int row) {
            return neighbours;
        }
    }

}