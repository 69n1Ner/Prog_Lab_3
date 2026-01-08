import Enums.Action;


public interface Actionable {
    boolean doActionTo(Action action, Actionable person);
}
