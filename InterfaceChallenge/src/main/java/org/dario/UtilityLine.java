package org.dario;


enum UtilityType {ELECTRICAL, FIBER_OPTIC}

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public GeometryType getShape() {
        return GeometryType.LINE;
    }

    @Override
    public String getMarker() {
        return "";
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s" , "type": "%s"  """.formatted(name,type);
    }
}
