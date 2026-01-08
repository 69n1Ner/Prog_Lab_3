public interface MovablePerson extends Movable{
    void goTo(Place place, Horse horse);
    void askToGoTo(Place place, MovablePerson person, Horse horse);
    void askToGoTo(Place place, MovablePerson person);
    default boolean isReady(){
        return true;
    };
}
