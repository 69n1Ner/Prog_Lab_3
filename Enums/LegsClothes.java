package Enums;

public enum LegsClothes {
    PANTS("Штаны"),
    NONE("Ничего"),
    SHORTS("Шорты");


    public final String legsClothes;

    LegsClothes(String legsClothes) {
        this.legsClothes = legsClothes;
    }

    public String getLegsClothes() {
        return legsClothes;
    }

    @Override
    public String toString() {
        return legsClothes;
    }
}
