package Enums;

public enum MoveType {
    ON_LEGS("На своих ногах"),
    ON_HORSE("На лошади");

    private final String moveType;

    MoveType(String moveType){
        this.moveType = moveType;
    }

    public String getMoveType() {
        return moveType;
    }

    @Override
    public String toString() {
        return moveType;
    }
}
