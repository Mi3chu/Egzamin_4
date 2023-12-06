package zadanie1.geometryShapes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle testRectlange;

    @Before
    public void init() {
        testRectlange = new Rectangle(2, 4);
    }

    @Test
    public void shouldReturn12OnCountCircuit() {
        assertEquals(12, testRectlange.countCircuit(), 0.001);
    }

    @Test
    public void shuldReturn8nCountField() {
        assertEquals(8, testRectlange.countField(), 0.001);
    }

    @Test
    public void RectlanglesShuldHaveSameHashCode() {
        Rectangle rectangle1 = new Rectangle(5.0, 5.0);
        Rectangle rectangle2 = new Rectangle(5.0, 5.0);

        assertEquals(rectangle1.hashCode(), rectangle2.hashCode());
    }

    @Test
    public void RectanglesShuldDontHaveSameHashCode() {
        Rectangle rectangle1 = new Rectangle(5.0, 2.0);
        Rectangle rectangle3 = new Rectangle(3.0, 6.0);

        assertNotEquals(rectangle1.hashCode(), rectangle3.hashCode());
    }
}