package Enums;

public enum EventName {
    FIGHT("Битва!"),
    WORRIED_CROWD("Взволнованная толпа!"),
    HELP_ME("На помощь!");

    private final String eventName;

    EventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
