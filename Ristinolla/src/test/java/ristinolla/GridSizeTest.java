package ristinolla;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miklas
 */
public class GridSizeTest {

    Grid kona;

    @Test
    public void validMinGrid() {
        kona = new Grid(-1);
        assertEquals(3, kona.getGridSize());
    }

    @Test
    public void validMaxGrid() {
        kona = new Grid(100000);
        assertEquals(100, kona.getGridSize());
    }

    @Test
    public void testGameState() {
        kona = new Grid(10);
        assertEquals(0, kona.getGameState());
    }

    @Test
    public void TestWinState() {
        kona = new Grid(10);
        kona.setGameToWinState();
        assertEquals(1, kona.getGameState());
    }

    @Test
    public void testGameNotWon() {
        kona = new Grid(10);
        assertEquals("", kona.checkWinner());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
