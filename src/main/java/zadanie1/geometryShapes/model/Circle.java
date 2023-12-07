package zadanie1.geometryShapes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import zadanie1.geometryShapes.interfaces.Shape;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Circle implements Shape {

    @Getter
    private final String type = getClass().getSimpleName().toLowerCase();
    private double radius;

    public Circle(@JsonProperty("radius") double radius) {
        this.radius = radius;
    }

    public double countField() {
        return Math.PI * (radius * radius);
    }

    public double countCircuit() {
        return 2 * Math.PI * radius;
    }

}
