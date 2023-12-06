package zadanie1.geometryShapes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {
    private Circle testCircle;

    @Before
    public void init() {
        testCircle = new Circle(2);
    }

    @Test
    public void shouldReturn13OnCountCircuit() {
        assertEquals(13, testCircle.countCircuit(), 1);
    }

    @Test
    public void shuldReturn13nCountField() {
        assertEquals(13, testCircle.countField(), 1);
    }

    @Test
    public void CirclesShuldHaveSameHashCode() {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);

        assertEquals(circle1.hashCode(), circle2.hashCode());
    }

    @Test
    public void CirclesShuldDontHaveSameHashCode() {
        Circle circle1 = new Circle(5.0);
        Circle circle3 = new Circle(3.0);

        assertNotEquals(circle1.hashCode(), circle3.hashCode());
    }
}