package Enums;

public enum PlaceObject {
    DOOR("Дверь"),
    TABLE("Стол"),
    WINDOW("Окно");

    private final String placeObject;

    PlaceObject(String placeObject) {
        this.placeObject = placeObject;
    }

    public String getPlaceObject() {
        return placeObject;
    }

    @Override
    public String toString() {
        return placeObject;
    }
}
