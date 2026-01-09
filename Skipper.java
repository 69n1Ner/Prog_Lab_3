import Enums.*;

import java.util.Objects;
import java.util.Random;

public class Skipper extends Rider implements Actionable{

    public Skipper(String name,
                   Place place,
                   Mood mood,
                   int hunger,
                   Profession profession,
                   Clothes clothes,
                   Gender gender,
                   Horse horse) {
        super(name,place, mood, hunger, profession, clothes, gender,horse);
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
                Gender.MALE,
                null);
    }

    public void knockToDoor(Place place) {
        if (this.getPlace().getPlaceType() == PlaceType.OUTSIDE) {

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
            this.addEvent(doorKnock);
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
        if (new Random().nextInt(11) < 5) {
            if (action == Action.EXTEND_HANDS){
                System.out.println(this + " " + action+" к "+person+" чтобы он быстрее вышел");
                if (!person.doActionTo(Action.EVADE,this)){
                    Person pers =  (Person) person;
                    System.out.println(this+" забирает "+ person + ". Они собираются в " +TimeLine.getEv(EventName.HELP_ME).place().getPlaceType());
                    System.out.println(person+" даже не оделся и не собрал вещи! На нем сейчас "+ pers.getClothes());
                    if (pers instanceof Rider) {
                        Rider rider = (Rider) pers;
                        pers.goTo(this.getPlace());
                        this.toHorse(TimeLine.getPlace(this.getPlace()).getHorses().get(0));
                        rider.toHorse(this.getHorse());
                        this.goTo(TimeLine.getEv(EventName.HELP_ME).place(),this.getHorse());
                    } else {
                        this.goTo(TimeLine.getEv(EventName.HELP_ME).place());
                        pers.goTo(TimeLine.getEv(EventName.HELP_ME).place());
                    }
                }
                return true;
            }

            System.out.println(this + " " + action);
            return true;
        } else {
            return false;
        }
    }
}
