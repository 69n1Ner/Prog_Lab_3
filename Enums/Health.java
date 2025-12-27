package Enums;

public enum Health {
    GOOD("Хорошее"),
    INJURY("Ранен");
    private final String health;

    Health(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return health;
    }
}
