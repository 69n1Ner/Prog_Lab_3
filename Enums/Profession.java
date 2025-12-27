package Enums;

public enum Profession {

    DOCTOR("Врач"),
    HOSTESS("Хозяка отеля"),
    SKIPPER("Капитан корабля"),
    LORD("Лорд"),
    DUKE("Герцог"),
    WORKER("Рабочий");

    private final String profesion;

    Profession(String profesion) {
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    @Override
    public String toString() {
        return profesion;
    }
}
