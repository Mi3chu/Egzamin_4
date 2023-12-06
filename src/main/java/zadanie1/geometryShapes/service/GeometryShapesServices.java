package zadanie1.geometryShapes.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import zadanie1.geometryShapes.exceptions.JSONExportException;
import zadanie1.geometryShapes.exceptions.JSONImportException;
import zadanie1.geometryShapes.interfaces.Shape;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class GeometryShapesServices {

    private ObjectMapper objectMapper = new ObjectMapper();

    public Shape findFigureWithLargestArea(List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparing(Shape::countField)).orElse(null);
    }

    public Shape findFigureWithLargestPerimeter(List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparing(Shape::countCircuit)).orElse(null);
    }

    public static void exportShapesToJSON(List<Shape> shapes, String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            String json = gson.toJson(shapes);
            fileWriter.write(json);
        } catch (IOException e) {
            throw new JSONExportException("Error when exporting shapes to JSON file");
        }
    }

    public List<Shape> importShapesFromJSON(String filepath) {
        List<Shape> shapes;
        try {
            shapes = objectMapper.readValue(new File(filepath), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSONImportException("Error when importing shapes from JSON files");
        }
        return shapes;
    }

}