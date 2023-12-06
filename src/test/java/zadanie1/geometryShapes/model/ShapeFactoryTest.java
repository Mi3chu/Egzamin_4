package zadanie1.geometryShapes.model;

import zadanie1.geometryShapes.exceptions.ValueCanNotBeZeroOrNegativeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ShapeFactoryTest {
    private ShapeFactory shapeFactory;

    @Before
    public void init() {
        this.shapeFactory = new ShapeFactory();
    }

    @Test
    public void shouldCreateTwoSameSquare() {
        Square square1 = (Square) this.shapeFactory.createSquare(10.0);
        Square square2 = (Square) this.shapeFactory.createSquare(10.0);
        Assert.assertSame(square1, square2);
    }

    @Test
    public void shouldCreateTwoSameCircle() {
        Circle circle1 = (Circle) this.shapeFactory.createCircle(10.0);
        Circle circle2 = (Circle) this.shapeFactory.createCircle(10.0);
        Assert.assertSame(circle1, circle2);
    }

    @Test
    public void shouldCreateTwoSameRectangle() {
        Rectangle rectangle1 = (Rectangle) this.shapeFactory.createRectangle(10.0, 20.0);
        Rectangle rectangle2 = (Rectangle) this.shapeFactory.createRectangle(10.0, 20.0);
        Assert.assertSame(rectangle1, rectangle2);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfRadiusIs0() {
        shapeFactory.createCircle(0);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfRadiusIsNegative() {
        shapeFactory.createCircle(-0.1);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfSideIs0() {
        shapeFactory.createSquare(0);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfSideIsNegative() {
        shapeFactory.createSquare(-0.1);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfWidthIs0() {
        shapeFactory.createRectangle(1, 0);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfLengthIs0() {
        shapeFactory.createRectangle(0, 1);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfWidthIsNegative() {
        shapeFactory.createRectangle(1, -0.1);
    }

    @Test(expected = ValueCanNotBeZeroOrNegativeException.class)
    public void throwValueCanNotBeZeroOrNegativeExceptionIfLengthIsNegative() {
        shapeFactory.createRectangle(-0.1, 1);
    }
}