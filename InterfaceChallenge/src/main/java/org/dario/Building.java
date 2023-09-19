package org.dario;

enum BuildingType {BUSINESS, ENTERTAINMENT}

public class Building implements Mappable {

    private String name;
    private BuildingType type;

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public GeometryType getShape() {
        return GeometryType.POINT;
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
