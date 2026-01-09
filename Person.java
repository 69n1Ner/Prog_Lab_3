import Enums.*;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Person implements MovablePerson {
    private Mood mood;
    private ArrayList<Relationship> relationships;
    private int hunger;
    private Place place;
    private Profession profession;
    private Clothes clothes;
    private String name;
    private Gender gender;
    private ArrayList<Event> events;
    private ArrayList<Clothes> clothesInventory;

    public Person(String name,
                  Place place,
                  Mood mood,
                  int hunger,
                  Profession profession,
                  Clothes clothes,
                  Gender gender) {
        this.mood = mood;
        this.place = place;
        this.hunger = hunger;
        this.profession = profession;
        this.clothes = clothes;
        this.name = name;
        this.gender = gender;

        this.relationships = new ArrayList<>();
        this.events = new ArrayList<>();
        this.clothesInventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void goTo(Place place) {
        if (this.isReady()){
            this.remPlToPlace(this.getPlace(),place);
            System.out.println(this + " идет в "+ place);
        } else {
            System.out.println(this + " не готов идти: "); // TODO добавить причины
        }

    }

    @Override
    public void askToGoTo(Place place, MovablePerson person){
        System.out.println(this + " предлагает " + person + " отправится в " + place);
        if (this.isReady() && person.isReady()) {
            System.out.println("Все готовы!");
        }
        else {
            System.out.println("Кто то не готов(");
        }
    }

    private void tellAboutEvTo(Event event) {
        if (event.evName() == EventName.HELP_ME) {
            String victims = "";
            for (Person pe : event.evPersons()) {
                victims += pe + " ";
            }
            if (victims.isEmpty()) {
                victims = "никого";
            }


            System.out.println("В " + event.place() +
                    " были ранены: " + victims +
                    "\nЭто " + event.evNature()
            );
        }

        if (event.evName() == EventName.FIGHT) {
            String fighters = "";
            for (Person pe : event.evPersons()) {
                fighters += pe + " ";
            }
            if (fighters.isEmpty()) {
                fighters = "никого";
            }


            System.out.println("В " + event.place() +
                    " произошла " + event.evName() +
                    "в ней были: " + fighters +
                    "\nЭто " + event.evNature());

        }

        if (event.evName() == EventName.WORRIED_CROWD) {
            String crowd = "";
            for (Person pe : event.evPersons()) {
                crowd += pe + " ";
            }
            if (crowd.isEmpty()) {
                crowd = "никого";
            }

            System.out.println("В " + event.place() +
                    " произошла " + event.evName() +
                    "в ней были: " + crowd +
                    "\nЭто " + event.evNature());
        }
    }

    public void askAboutEvTo(Event event, Person person) {
        if (this.getPlace().getPlaceType() == person.getPlace().getPlaceType() ||
                person.getPlace().getPlaceType() == PlaceType.OUTSIDE) {
            System.out.println(person + " говорит " +
                    this + " о событии " + event.evName());
            person.tellAboutEvTo(event);

            if (event.evNature() == Nature.BAD) {
                this.setMood(Mood.SAD);
                System.out.println(event.evName() + " влияет на " + this + ". Его настроение стало " + Mood.SAD);
            }
        }
    }

    public void heal(Lord patient) {
        if (this.getProfession() != Profession.DOCTOR && this.getPlace().equals(patient.getPlace())) {
            System.out.println(this + " не врач!");
            return;
        }

        if (patient.getHealth() == Health.GOOD) {
            System.out.println(patient + " итак здоров");
            return;
        }
        System.out.println(this + " лечит " + patient);
        patient.setHealthBy(Health.GOOD, this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public void eat(Food food) {
        if (this.getPlace().getFoods().contains(food)) {
            this.hunger += food.getSaturation();
            System.out.println(this.getName() + " съел " + food);
        } else {
            System.out.println(this + " не имеет " + food + " в " + this.getPlace());
        }

    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public ArrayList<Relationship> getAllRelationships() {
        return relationships;
    }

    public void addRelationship(Person relWith, ERelationship relationship) {
        this.relationships.add(new Relationship(relWith, this, relationship));
        relWith.relationships.add(new Relationship(this, relWith, relationship));
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    private void remPlToPlace(Place current, Place future) {
        current.remPerson(this);
        future.addPerson(this);
        this.setPlace(future);
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Clothes getClothes() {
        return new Clothes(this.clothes);
    }

    public void addClothesToInv(Clothes clothes) {
        this.clothesInventory.add(clothes);
    }

    public void setClothesFromInv(Clothes clothes) {
        this.clothesInventory.add(this.clothes);
        this.clothes = clothesInventory.get(0);
        this.clothesInventory.remove(0);
        System.out.println(this + " переодевается в " + clothes);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}
