import Enums.*;

import java.util.Random;

public class Citizen extends Person implements Actionable{
    public Citizen(String name,
                   Place place,
                   Mood mood,
                   int hunger,
                   Profession profession,
                   Clothes clothes,
                   Gender gender) {
        super(name, place, mood, hunger, profession, clothes, gender);
    }

    public Citizen(String name){
        this(
                name,
                null,
                Mood.CALM,
                80,
                Profession.WORKER,
                new Clothes(
                        HeadDress.NONE,
                        BodyClothes.DRESS,
                        LegsClothes.NONE,
                        Boots.NONE),
                Gender.FEMALE
        );
    }

    @Override
    public String toString() {
        return getName();
    }
}
