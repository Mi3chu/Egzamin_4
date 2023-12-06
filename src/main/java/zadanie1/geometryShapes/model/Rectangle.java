package zadanie1.geometryShapes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import zadanie1.geometryShapes.interfaces.Shape;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Rectangle implements Shape {

    private final String type = getClass().getSimpleName().toLowerCase();
    private double length;
    private double width;

    public Rectangle(@JsonProperty("length") double length, @JsonProperty("width") double width) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double countField() {
        return length * width;
    }

    @Override
    public double countCircuit() {
        return (length * 2) + (width * 2);
    }
}
