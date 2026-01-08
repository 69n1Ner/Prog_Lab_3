import Enums.EventName;
import Enums.Nature;

import java.util.Arrays;
import java.util.Objects;

public record Event(EventName evName,
                    Person[] evPersons,
                    Nature evNature,
                    Place place) {
    @Override
    public String toString() {
        return evName.getEventName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return evName == event.evName && Objects.deepEquals(evPersons, event.evPersons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evName, Arrays.hashCode(evPersons));
    }
}
