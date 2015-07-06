package uk.co.stest.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void newCellIsDead() {
        Cell cell = new Cell();
        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void cellCanBeMadeAlive() {
        Cell cell = new Cell();
        cell.live();
        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void cellsCanDie() {
        Cell cell = new Cell();
        cell.live();
        cell.die();
        assertThat(cell.isAlive()).isFalse();
    }
}
