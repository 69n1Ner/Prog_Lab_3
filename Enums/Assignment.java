package Enums;

public enum Assignment {
    COOK_CHICKEN("Приготовить курицу"),
    COOK_FISH("Приготовить рыбу"),
    COOK_CORN("Приготовить кукурузу"),
    COOK_SALAD("Приготовить салат"),
    DO_HOME_THINGS("Сделать дела по дому");

    public final String assignment;

    Assignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAssignment() {
        return assignment;
    }

    @Override
    public String toString() {
        return assignment;
    }
}
