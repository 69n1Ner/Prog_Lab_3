package Enums;
// TODO переделать, добавить класс Place, в котором есть PlaceType и ObjectPlace
public enum PlaceType {
    BLOOD_HOUSE("Дом Питера Блада"),
    OUTSIDE("Улица"),
    LORD_HOUSE("Дом Гилдоя");

    public final String place;
    public int accessCounter;

    PlaceType(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return place;
    }
}
