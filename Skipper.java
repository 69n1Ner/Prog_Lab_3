import Enums.*;

import java.util.Objects;
import java.util.Random;

public class Skipper extends Person implements Actionable{
    public Skipper(String name,
                   Place place,
                   Mood mood,
                   int hunger,
                   Profession profession,
                   Clothes clothes,
                   Gender gender) {
        super(name,place, mood, hunger, profession, clothes, gender);
    }

    public Skipper() {
        this(
                "Jeremy",
                TimeLine.getPlace(new Place(PlaceType.OUTSIDE)),
                Mood.WORRIED,
                50,
                Profession.SKIPPER,
                new Clothes(
                        HeadDress.TRICORNE,
                        BodyClothes.JACKET,
                        LegsClothes.SHORTS,
                        Boots.SANDALS),
                Gender.MALE);
    }

    public void knockToDoor(Place place) {

        if (this.getPlace().getPlaceType() == PlaceType.OUTSIDE) {

            //TODO мб добавить другие места для стука
            String knockable = " ";
            for (PlaceObject o : place.getPlaceObjects()) {
                if (o == PlaceObject.DOOR) {
                    knockable = "Дверь";
                    break;
                }
            }
            System.out.println(this + " стучит в " + knockable + "!");
            Event doorKnock = new Event(
                    EventName.HELP_ME,
                    new Person[]{TimeLine.getPe(new Lord())},
                    Nature.BAD,
                    TimeLine.getPlace(new Place(PlaceType.LORD_HOUSE))
            );

            TimeLine.addEv(doorKnock);
            for (Person pe: place.getPersons()){
                    pe.setMood(Mood.WORRIED);
                    pe.addEvent(doorKnock);
            };
            String atHome = String.join(", ",
                    place.getPersons()
                    .stream()
                    .map(Person::getName)
                    .toArray(String[]::new)
            );
            System.out.println(atHome + " в "+place+" обеспокоены!");
        }

    }

    public boolean doActionTo(Action action,Actionable person) {
        //TODO изменить рандом
        if (new Random().nextInt(11) < 10) {
            if (action == Action.EXTEND_HANDS){
                System.out.println(this + " " + action);
                person.doActionTo(Action.EVADE,this);
                return true;
            }

            System.out.println(this + " " + action);
            return true;
        } else {
            System.out.println(this + " не " + action);
            return false;
        }
    }
}
