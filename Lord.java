import Enums.*;

import java.util.ArrayList;
import java.util.List;

public class Lord extends Person{
    private Health health = Health.GOOD;

    public Lord(String name,
                Place place,
                Mood mood,
                int hunger,
                Profession profession,
                Clothes clothes,
                Gender gender) {
        super(name, place,mood, hunger, profession, clothes, gender);
    }

    public Lord(){
        this(
                "Gildow",
                TimeLine.getPlace(new Place(PlaceType.LORD_HOUSE)),
                Mood.SAD,
                40,
                Profession.LORD,
                new Clothes(
                        HeadDress.NONE,
                        BodyClothes.JACKET,
                        LegsClothes.PANTS,
                        Boots.SHOES),
                Gender.MALE
        );
    }



    public void getInjury(){
        if (this.health!=Health.INJURY){
            this.health = Health.INJURY;
            this.setMood(Mood.SAD);
            System.out.println(this + " получает ранение!");
        }
    }

    public void setHealthBy(Health health,Person person){
        if (person.getProfession() == Profession.DOCTOR){
            this.health = health;
        }
    }

    public Health getHealth() {
        return health;
    }


}
