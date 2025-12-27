package Enums;

public enum Mood {
    CALM("Спокойный"),
    WORRIED("Взволнованный"),
    SAD("Грустный");

    private final String mood;

    Mood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return mood;
    }
}