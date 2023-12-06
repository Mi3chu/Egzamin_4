package zadanie1.geometryShapes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import zadanie1.geometryShapes.interfaces.Shape;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Square implements Shape {

    private final String type = getClass().getSimpleName().toLowerCase();
    private double side;

    public Square(@JsonProperty("side") double side) {
        this.side = side;
    }

    @Override
    public double countField() {
        return side * side;
    }

    @Override
    public double countCircuit() {
        return side * 4;
    }
}
