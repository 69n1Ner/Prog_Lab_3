import Enums.Action;

import java.util.Random;


public interface Actionable {
    default boolean doActionTo(Action action, Actionable person){
        if (new Random().nextInt(11) < 5) {
            System.out.println(this + " " + action);
            return true;
        } else {
            return false;
        }
    }
}
