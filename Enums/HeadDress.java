package Enums;

public enum HeadDress {
    HAT("Шляпа"),
    NONE("Ничего"),
    TRICORNE("Треуголка");

    public final String headDress;

    HeadDress(String headDress) {
        this.headDress = headDress;
    }

    public String getHeadDress() {
        return headDress;
    }

    @Override
    public String toString() {
        return headDress;
    }
}
