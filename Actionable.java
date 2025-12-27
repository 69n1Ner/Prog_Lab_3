import Enums.Action;

import java.util.ArrayList;
import java.util.List;

public interface Actionable {
    boolean doActionTo(Action action, Actionable person);
}
