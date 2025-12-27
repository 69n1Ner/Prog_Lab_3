import Enums.MoveType;

public interface Movable {
    void goToBy(Place place, MoveType moveType);
    void askToGoToBy(Place place, Movable person,MoveType moveType);
    boolean ansToGo(Movable whoAnswered);
}
