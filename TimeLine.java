import Enums.*;
import jdk.jfr.EventType;

import java.util.*;

class TimeLine {
    private static final List<Event> EVENTS = new ArrayList<>();
    private static final List<Person> PERSONS = new ArrayList<>();
    private static final List<Place> PLACES = new ArrayList<>();

    private TimeLine() {
    }

    public static void addPlace(Place place) {
        if (place != null && !PLACES.contains(place)) {
            PLACES.add(place);
        }
    }

    public static Place getPlace(Object place){
        for (Place pl: PLACES){
            if (Objects.equals(pl,place)){
                return pl;
            }
        }
        return null;
    }

    public static List<Place> getAllPlace() {
        return new ArrayList<>(PLACES);
    }

    public static void addPe(Person person) {
        if (person != null && !PERSONS.contains(person)) {
            PERSONS.add(person);
        }
    }

    public static Person getPe(Object person){
        for (Person pe: PERSONS){
            if (Objects.equals(pe,person)){
                return pe;
            }
        }
        return null;
    }

    public static List<Person> getAllPe() {
        return new ArrayList<>(PERSONS);
    }

    public static void addEv(Event event) {
        if (event != null) {
            System.out.println("Произошло "+event);
            EVENTS.add(event);
        }
    }

    public static Event getEv(EventName eventName){
        for (Event ev: EVENTS){
            if (ev.evName() == eventName){
                return ev;
            }
        }
        return null;
    }

    public static List<Event> getAllEv() {
        return new ArrayList<>(EVENTS);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Place bloodHouse = new Place(PlaceType.BLOOD_HOUSE);
        Place outside = new Place(PlaceType.OUTSIDE);
        Horse charcoal = new Horse(
                "Charcoal",
                outside
        );
        outside.addHorse(charcoal); //
        TimeLine.addPlace(bloodHouse);
        TimeLine.addPlace(outside);

        MainCharacter peter = new MainCharacter();
        Hostess barlow = new Hostess();
        Lord gildow = new Lord();


        TimeLine.addPe(peter);
        TimeLine.addPe(peter); //repeat
        TimeLine.addPe(barlow);
        TimeLine.addPe(gildow);


        bloodHouse.addPerson(barlow);
        bloodHouse.addPerson(peter);
        //Todo add relationships
        peter.addRelationship(barlow,ERelationship.FRIENDS);

        //todo change random
        if (rand.nextInt(11) < 11){


            //adding places
            Place lordHouse = new Place(PlaceType.LORD_HOUSE);
            TimeLine.addPlace(lordHouse);

            //adding chars
            Skipper jeremy = new Skipper();
            TimeLine.addPe(jeremy);
            Citizen tom = new Citizen("Tom");
            TimeLine.addPe(tom);
            Citizen sam = new Citizen("Sam");
            TimeLine.addPe(sam);
            Citizen bob = new Citizen("Bob");
            TimeLine.addPe(bob);


            //setting chars to places
            outside.addPerson(jeremy);
            outside.addPerson(tom);
            outside.addPerson(sam);
            outside.addPerson(bob);

            //setting relationships
            peter.addRelationship(jeremy,ERelationship.FRIENDS);
            jeremy.addRelationship(gildow,ERelationship.FRIENDS);

            Event fight = new Event(
                    EventName.FIGHT,
                    new Person[]{gildow},
                    Nature.BAD,
                    outside);
            TimeLine.addEv(fight);
            for (Person p: TimeLine.getAllPe()){
                p.addEvent(fight);
            }

            Event crowd = new Event(
                    EventName.WORRIED_CROWD,
                    new Citizen[]{tom,sam,bob},
                    Nature.NEUTRAL,
                    outside);

            //todo добавить действия толпе к джереми через рандом,
            // подвязать туда рассказывание джереми кому либо из толпы, всех людей брать из event

                //  main part

                gildow.getInjury();

                Clothes petersClothes = new Clothes(
                        HeadDress.NONE,
                        BodyClothes.JACKET,
                        LegsClothes.PANTS,
                        Boots.SHOES);

                jeremy.knockToDoor(bloodHouse);
                peter.askAboutEvTo(peter.getEvents().get(peter.getEvents().size()-1), jeremy);
                jeremy.doActionTo(Action.EXTEND_HANDS,peter);
                if (!peter.getPlace().equals(lordHouse)){
                    jeremy.askToGoTo(lordHouse,peter,charcoal);
                    TimeLine.addEv(crowd);
                    boolean flag = false;
                    Person[] crowdPe = TimeLine.getEv(EventName.WORRIED_CROWD).evPersons();
                    for (Person p: crowdPe){
                        if (p instanceof Citizen){
                             if (((Citizen) p).doActionTo(Action.EXTEND_HANDS,jeremy)){
                                 p.askAboutEvTo(fight,jeremy);
                                 flag = true;
                                 break;
                             }
                        }
                    }
                    if (!flag){
                        crowdPe[rand.nextInt(crowdPe.length)].askAboutEvTo(fight,jeremy);
                    }
                    peter.searchForClothes(bloodHouse, petersClothes);
                    peter.setClothesFromInv(petersClothes);
                    peter.searchForTools(bloodHouse,Tool.SYRGERY_TOOLS);
                    peter.assignmentTo(Assignment.COOK_SALAD,barlow);
                    peter.goTo(outside);
                    barlow.goTo(outside);
                    barlow.grumbleBecauseOfEvent(fight);
                    jeremy.toHorse(charcoal);
                    peter.toHorse(charcoal);
                    jeremy.goTo(lordHouse,jeremy.getHorse());
                    jeremy.offHorse();
                    peter.offHorse();
                }
                peter.heal(gildow);

        } else {
            System.out.println(peter+" спокойно просыпается");
            barlow.cook(Food.CHICKEN);
            barlow.putOnTable(Food.CHICKEN);
            peter.eat(Food.CHICKEN);
        }
    }
}
