package Enums;

public enum Food {
    CHICKEN("Курица", 5),
    FISH("Рыба", 4),
    CORN("Кукуруза", 3),
    SALAD("Салат", 1);

    private final String food;
    private final int saturation;

    Food(String food, int saturation) {
        this.food = food;
        this.saturation = saturation;
    }

    public String getFood() {
        return food;
    }

    public int getSaturation() {
        return saturation;
    }

    @Override
    public String toString() {
        return food;
    }
}
