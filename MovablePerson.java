public interface MovablePerson extends Movable{
    void askToGoTo(Place place, MovablePerson person);
    default boolean isReady(){
        return true;
    };
}
