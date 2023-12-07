package zadanie1;

import zadanie1.geometryShapes.interfaces.Shape;
import zadanie1.geometryShapes.model.ShapeFactory;
import zadanie1.geometryShapes.service.GeometryShapesServices;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        GeometryShapesServices geometryShapesServices = new GeometryShapesServices();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.createCircle(2));
        shapes.add(shapeFactory.createCircle(15));
        shapes.add(shapeFactory.createRectangle(1, 3.0));
        shapes.add(shapeFactory.createRectangle(4, 2));
        shapes.add(shapeFactory.createRectangle(12, 10));
        shapes.add(shapeFactory.createSquare(4));
        shapes.add(shapeFactory.createSquare(7));
        shapes.add(shapeFactory.createSquare(1));


        geometryShapesServices.exportShapesToJSON(shapes, "listOfShapes.json");

        System.out.println(geometryShapesServices.importShapesFromJSON("listOfShapes.json"));
    }
}
