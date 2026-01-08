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
                System.out.println(this + " " + action+" к "+person+" чтобы быстрее он быстрее вышел");
                if (!person.doActionTo(Action.EVADE,this)){
                    Person pers =  (Person) person;
                    System.out.println(this+" забирает "+ pers + ". Они собираются в " +TimeLine.getEv(EventName.HELP_ME).place().getPlaceType());
                    System.out.println(pers+" даже не оделся и не собрал вещи! На нем сейчас "+pers.getClothes());
                    pers.goToBy(TimeLine.getPlace(this.getPlace()),MoveType.ON_LEGS);
                    pers.onHorse(TimeLine.getPlace(this.getPlace()).getHorses().get(0));
                    this.onHorse(TimeLine.getPlace(this.getPlace()).getHorses().get(0));
                    TimeLine.getPlace(this.getPlace()).getHorses().get(0).goToBy(TimeLine.getEv(EventName.HELP_ME).place(),MoveType.ON_LEGS);
                };
                return true;
            }

            System.out.println(this + " " + action);
            return true;
        } else {
            return false;
        }
    }
}
