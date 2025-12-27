package Enums;

public enum ERelationship {
    FRIENDS("Друзья"),
    ENEMIES("Враги"),
    FAMILIAR("Знакомые"),
    COLLEAGUE("Коллеги");

    public final String relationship;

    ERelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return relationship;
    }
}

