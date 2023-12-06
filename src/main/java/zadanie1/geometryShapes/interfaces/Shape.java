package zadanie1.geometryShapes.interfaces;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import zadanie1.geometryShapes.model.Circle;
import zadanie1.geometryShapes.model.Rectangle;
import zadanie1.geometryShapes.model.Square;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")
})
public interface Shape {
    double countField();

    double countCircuit();
}
