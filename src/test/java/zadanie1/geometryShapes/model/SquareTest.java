package zadanie1.geometryShapes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    private Square testSquare;

    @Before
    public void init() {
        testSquare = new Square(2.0);
    }

    @Test
    public void shouldReturn8OnCountCircuit() {
        assertEquals(8.0, testSquare.countCircuit(), 0.001);
    }

    @Test
    public void shuldReturn4OnCountCircuit() {
        assertEquals(4.0, testSquare.countField(), 0.001);
    }

    @Test
    public void SquaresShuldHaveSameHashCode() {
        Square square1 = new Square(5.0);
        Square square2 = new Square(5.0);

        assertEquals(square1.hashCode(), square2.hashCode());
    }

    @Test
    public void SquaresShuldDontHaveSameHashCode() {
        Square square1 = new Square(5.0);
        Square square3 = new Square(3.0);

        assertNotEquals(square1.hashCode(), square3.hashCode());
    }
}
