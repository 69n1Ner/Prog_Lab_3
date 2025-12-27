package Enums;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
