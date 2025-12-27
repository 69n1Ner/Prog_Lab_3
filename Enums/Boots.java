package Enums;

public enum Boots {
    SHOES("Туфли"),
    NONE("Ничего"),
    SANDALS("Сандалии");

    public final String boots;

    Boots(String boots) {
        this.boots = boots;
    }

    public String getBoots() {
        return boots;
    }

    @Override
    public String toString() {
        return boots;
    }
}
