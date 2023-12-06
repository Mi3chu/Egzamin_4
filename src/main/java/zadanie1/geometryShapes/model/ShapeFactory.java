package zadanie1.geometryShapes.model;

import zadanie1.geometryShapes.exceptions.ValueCanNotBeZeroOrNegativeException;
import zadanie1.geometryShapes.interfaces.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private Map<String, Shape> shapeCache = new HashMap<>();

    public ShapeFactory() {
    }

    public Shape createCircle(double radius) {
        if (radius > 0) {
            String key = "circle_" + radius;
            return shapeCache.computeIfAbsent(key, k -> {
                Circle circle = new Circle(radius);
                return circle;
            });
        } else {
            throw new ValueCanNotBeZeroOrNegativeException();
        }
    }

    public Shape createSquare(double side) {
        if (side > 0) {
            String key = "square_" + side;
            return shapeCache.computeIfAbsent(key, k -> {
                Square square = new Square(side);
                return square;
            });
        } else {
            throw new ValueCanNotBeZeroOrNegativeException();
        }
    }

    public Shape createRectangle(double length, double width) {
        if (length > 0 && width > 0) {
            String key = "rectangle_" + length + "_" + width;
            return shapeCache.computeIfAbsent(key, k -> {
                Rectangle rectangle = new Rectangle(length, width);
                return rectangle;
            });
        } else {
            throw new ValueCanNotBeZeroOrNegativeException();
        }
    }
}
