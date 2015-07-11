package uk.co.stest.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellGridTest {

    private CellGrid defaultGrid;

    @Before
    public void setup() {
        defaultGrid = new CellGrid(3,3);
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
        assertThat(defaultGrid.getCell(1, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(1, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(1, 3).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 3).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 3).isAlive()).isFalse();
    }

    @Test
    public void canBirthSpecificCells() {
        defaultGrid.birthCell(2, 2);

        assertThat(defaultGrid.getCell(1, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 1).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(1, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 2).isAlive()).isTrue();
        assertThat(defaultGrid.getCell(3, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(1, 3).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(2, 3).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 3).isAlive()).isFalse();
    }

    @Test
    public void canKillSpecificCells() {
        defaultGrid.birthCell(1, 1);
        defaultGrid.birthCell(2, 2);
        defaultGrid.birthCell(3, 2);

        defaultGrid.killCell(2, 2);

        assertThat(defaultGrid.getCell(1, 1).isAlive()).isTrue();
        assertThat(defaultGrid.getCell(2, 2).isAlive()).isFalse();
        assertThat(defaultGrid.getCell(3, 2).isAlive()).isTrue();
    }

    @Test
    public void canCountLivingRelativesOfCellEmpty() {
        assertThat(defaultGrid.neighbours(1, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(3, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(1, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(3, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(1, 3)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 3)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(3, 3)).isEqualTo(0);
    }

    @Test
    public void canCountLivingRelativesOfCellCorner() {
        defaultGrid.birthCell(1, 1);

        assertThat(defaultGrid.neighbours(1, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 1)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(3, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(1, 2)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(2, 2)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(3, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(1, 3)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 3)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(3, 3)).isEqualTo(0);
    }

    @Test
    public void canCountLivingRelativesOfCellWall() {
        defaultGrid.birthCell(3, 2);

        assertThat(defaultGrid.neighbours(1, 1)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 1)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(3, 1)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(1, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 2)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(3, 2)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(1, 3)).isEqualTo(0);
        assertThat(defaultGrid.neighbours(2, 3)).isEqualTo(1);
        assertThat(defaultGrid.neighbours(3, 3)).isEqualTo(1);
    }
}
