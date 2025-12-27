package Enums;

public enum BodyClothes {
    DRESS("Платье"),
    NIGHTY("Ночнушка"),
    JACKET("Куртка"),
    SHIRT("Рубашка");

    public final String bodyClothes;

    BodyClothes(String bodyClothes) {
        this.bodyClothes = bodyClothes;
    }

    public String getBodyClothes() {
        return bodyClothes;
    }

    @Override
    public String toString() {
        return bodyClothes;
    }
}
