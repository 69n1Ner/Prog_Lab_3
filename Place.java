import Enums.Food;
import Enums.PlaceObject;
import Enums.PlaceType;
import Enums.Profession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Place {
    ArrayList<PlaceObject> placeObjects;
    PlaceType placeType;
    ArrayList<Food> foods;
    ArrayList<Person> persons;
    ArrayList<Horse> horses;

    public Place(PlaceType placeType) {
        this.placeType = placeType;
        this.foods = new ArrayList<>();
        this.persons = new ArrayList<>();
        this.placeObjects = new ArrayList<>();
        this.horses = new ArrayList<>();

        if (placeType == PlaceType.BLOOD_HOUSE || placeType == PlaceType.LORD_HOUSE) {
            this.placeObjects.add(PlaceObject.DOOR);
            this.placeObjects.add(PlaceObject.WINDOW);
            this.placeObjects.add(PlaceObject.TABLE);

        }
    }

    @Override
    public String toString() {
        return placeType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(placeType, place.placeType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placeObjects);
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void addHorse(Horse horses) {
        this.horses.add(horses);
    }

    public void remHorse(Horse horse){
        this.horses.remove(horse);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void addPerson (Person person) {
        this.persons.add(person);
        person.setPlace(this);
    }

    public void remPerson(Person person){
        this.persons.remove(person);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

     public void addFood(Food food,Person whoPut) {
        if (whoPut.getProfession() == Profession.HOSTESS){
            this.foods.add(food);

        }else {
            throw new IllegalArgumentException(whoPut+" не может так");
        }

    }

    public ArrayList<PlaceObject> getPlaceObjects() {
        return placeObjects;
    }

    public void setPlaceObjects(ArrayList<PlaceObject> placeObjects) {
        this.placeObjects = placeObjects;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }
}
