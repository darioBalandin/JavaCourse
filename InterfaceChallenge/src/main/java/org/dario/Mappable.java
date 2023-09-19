package org.dario;

enum GeometryType {POINT, LINE, POLYGON}



public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}""";

    String getLabel();

    GeometryType getShape();

    String getMarker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(),getLabel(),getMarker());
    }

    static void printProperties(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));

    }
}
