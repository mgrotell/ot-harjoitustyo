/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ristinolla.Grid;

/**
 *
 * @author miklas
 */
public class GridSizeTest {

    Grid kona = new Grid(3);

    @Test
    public void validMinGrid() {
        Grid wrong = new Grid(-1);
        assertEquals(2, wrong.getGridSize());
    }

    @Test
    public void validMaxGrid() {
        Grid wrong = new Grid(100000);
        assertEquals(200, wrong.getGridSize());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
