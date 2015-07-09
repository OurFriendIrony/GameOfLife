package uk.co.stest.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellGridTest {

    @Test
    public void cellGridsAreDefaultThreeByThree() {
        CellGrid grid = new CellGrid();

        assertThat(grid.getHeight()).isEqualTo(3);
        assertThat(grid.getWidth()).isEqualTo(3);
    }

    @Test
    public void cellGridsSizeIsDefinedByConstructor() {
        CellGrid grid = new CellGrid(1, 4);

        assertThat(grid.getHeight()).isEqualTo(1);
        assertThat(grid.getWidth()).isEqualTo(4);
    }

    @Test
    public void gridsHaveCells() {
        CellGrid grid = new CellGrid(1, 1);

        assertThat(grid.getCell(1, 1)).isInstanceOf(Cell.class);
    }

    @Test
    public void gridsAreCreatedBarren() {
        CellGrid grid = new CellGrid();

        assertThat(grid.getCell(1, 1).isAlive()).isFalse();
        assertThat(grid.getCell(2, 1).isAlive()).isFalse();
        assertThat(grid.getCell(3, 1).isAlive()).isFalse();
        assertThat(grid.getCell(1, 2).isAlive()).isFalse();
        assertThat(grid.getCell(2, 2).isAlive()).isFalse();
        assertThat(grid.getCell(3, 2).isAlive()).isFalse();
        assertThat(grid.getCell(1, 3).isAlive()).isFalse();
        assertThat(grid.getCell(2, 3).isAlive()).isFalse();
        assertThat(grid.getCell(3, 3).isAlive()).isFalse();
    }

    @Test
    public void canBirthSpecificCells() {
        CellGrid grid = new CellGrid();

        grid.birthCell(2, 2);

        assertThat(grid.getCell(1, 1).isAlive()).isFalse();
        assertThat(grid.getCell(2, 1).isAlive()).isFalse();
        assertThat(grid.getCell(3, 1).isAlive()).isFalse();
        assertThat(grid.getCell(1, 2).isAlive()).isFalse();
        assertThat(grid.getCell(2, 2).isAlive()).isTrue();
        assertThat(grid.getCell(3, 2).isAlive()).isFalse();
        assertThat(grid.getCell(1, 3).isAlive()).isFalse();
        assertThat(grid.getCell(2, 3).isAlive()).isFalse();
        assertThat(grid.getCell(3, 3).isAlive()).isFalse();
    }

    @Test
    public void canKillSpecificCells() {
        CellGrid grid = new CellGrid();

        grid.birthCell(1, 1);
        grid.birthCell(2, 2);
        grid.birthCell(3, 2);

        grid.killCell(2, 2);

        assertThat(grid.getCell(1, 1).isAlive()).isTrue();
        assertThat(grid.getCell(2, 1).isAlive()).isFalse();
        assertThat(grid.getCell(3, 1).isAlive()).isFalse();
        assertThat(grid.getCell(1, 2).isAlive()).isFalse();
        assertThat(grid.getCell(2, 2).isAlive()).isFalse();
        assertThat(grid.getCell(3, 2).isAlive()).isTrue();
        assertThat(grid.getCell(1, 3).isAlive()).isFalse();
        assertThat(grid.getCell(2, 3).isAlive()).isFalse();
        assertThat(grid.getCell(3, 3).isAlive()).isFalse();
    }
}
