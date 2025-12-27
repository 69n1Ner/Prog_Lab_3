package Enums;

public enum Action {
    DENY_GESTURE("Отказаться жестом"),
    AGREE_GESTURE("Согласится жестом"),
    EVADE("Уклониться"),
    EXTEND_HANDS("Протянуть руки");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return action;
    }
}
