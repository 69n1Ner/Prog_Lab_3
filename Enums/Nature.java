package Enums;

public enum Nature {
    GOOD("Хорошо"),
    BAD("Плохо"),
    NEUTRAL("Не имеет значения");

    private final String nature;

    Nature(String nature) {
        this.nature = nature;
    }

    public String getNature() {
        return nature;
    }

    @Override
    public String toString() {
        return nature;
    }
}
