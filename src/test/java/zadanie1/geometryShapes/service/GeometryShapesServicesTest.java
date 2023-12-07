package zadanie1.geometryShapes.service;

import zadanie1.geometryShapes.interfaces.Shape;
import zadanie1.geometryShapes.model.Circle;
import zadanie1.geometryShapes.model.Rectangle;
import zadanie1.geometryShapes.model.ShapeFactory;
import zadanie1.geometryShapes.model.Square;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class GeometryShapesServicesTest {

    private GeometryShapesServices geometryShapesServices;
    private final ShapeFactory shapeFactory = new ShapeFactory();

    @Before
    public void init() {
        this.geometryShapesServices = new GeometryShapesServices();
    }

    @Test
    public void shouldFindCircleWithLargestArea() {
        Square square = (Square) this.shapeFactory.createSquare(5.0);
        Circle circle = (Circle) this.shapeFactory.createCircle(3.0);
        Shape largestAreaShape = this.geometryShapesServices.findFigureWithLargestArea(Arrays.asList(square, circle));
        assertEquals(circle, largestAreaShape);
    }

    @Test
    public void shouldFindFigureWithLargestPerimeter() {
        Shape square = this.shapeFactory.createSquare(5.0);
        Shape circle = this.shapeFactory.createCircle(3.0);
        Shape largestPerimeterShape = this.geometryShapesServices.findFigureWithLargestPerimeter(Arrays.asList(square, circle));
        assertEquals(square, largestPerimeterShape);
    }

    @Test
    public void returnTrueWhenPossibleToImportListOfShapesFromJSON() {
        String filepath = "listOfShapes.json";
        List<Shape> expectedShapes = createExpectedShapes();

        List<Shape> importedShapes = geometryShapesServices.importShapesFromJSON(filepath);

        assertEquals(expectedShapes, importedShapes);
    }

    private List<Shape> createExpectedShapes() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Circle c1 = (Circle) shapeFactory.createCircle(2.0);
        Circle c2 = (Circle) shapeFactory.createCircle(15.0);
        Rectangle r1 = (Rectangle) shapeFactory.createRectangle(1, 3);
        Rectangle r2 = (Rectangle) shapeFactory.createRectangle(4, 2);
        Rectangle r3 = (Rectangle) shapeFactory.createRectangle(12, 10);
        Square s1 = (Square) shapeFactory.createSquare(4.0);
        Square s2 = (Square) shapeFactory.createSquare(7.0);
        Square s3 = (Square) shapeFactory.createSquare(1.0);

        return List.of(c1, c2, r1, r2, r3, s1, s2, s3);
    }

    @Test
    public void shouldExportCorrectJsonFormat() {
        Circle shape1 = (Circle) shapeFactory.createCircle(1);
        Square shape2 = (Square) shapeFactory.createSquare(3);
        List<Shape> list = new ArrayList<>(Arrays.asList(shape1, shape2));
        String testJsonFormat = "testpath.json";
        String jsonFormat = "";
        String expectedFormat = "[{\"type\":\"circle\",\"radius\":1.0},{\"type\":\"square\",\"side\":3.0}]";
        GeometryShapesServices.exportShapesToJSON(list, testJsonFormat);
        try (BufferedReader reader = new BufferedReader(new FileReader(testJsonFormat))) {
            jsonFormat = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedFormat, jsonFormat);

        File testFile = new File(testJsonFormat);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void shouldImportShapesFromJson() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.createCircle(1));
        shapes.add(shapeFactory.createSquare(3));

        List<Shape> importedShapes = geometryShapesServices.importShapesFromJSON("test.json");

        assertEquals(shapes, importedShapes);
    }
}





