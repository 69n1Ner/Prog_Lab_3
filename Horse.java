import Enums.MoveType;
import Enums.PlaceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse implements Movable{
    private String name;
    private List<Person> personList;
    private Place place;

    public Horse(String name,Place place, List<Person> personList) {
        this.name = name;
        this.personList = personList;
        this.place = place;
    }

    public Horse(String name,Place place){
        this(name,place, new ArrayList<>());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void goToBy(Place place, MoveType moveType) {
        for (Person pe: this.getPersonList()){
            this.getPlace().remPerson(pe);
            pe.setPlace(place);
            place.addPerson(pe);
        }
        this.remPlToPlace(this.getPlace(),place);


        String riders = String.join(", ",
                this.getPersonList().stream()
                        .map(Person::getName)
                        .toArray(String[]::new)
        );

        System.out.println(this + " едет с " + riders + " в " + place);
    }

    @Override
    public void askToGoToBy(Place place, Movable person,MoveType moveType){
        throw new IllegalArgumentException("Лошадь не может упрашивать человека");
    }

    @Override
    public boolean ansToGo(Movable movable){
        if (movable instanceof Horse){
            throw new IllegalArgumentException("Лошадь не может отвечать лошади");
        }
        if (this.personList.contains(movable)) {
            return true;
        }
        System.out.println(movable + " не сидит на "+this);
        return false;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addToPersonList(Person person) {
        if (person.getPlace() == this.getPlace()) {
            this.personList.add(person);
        } else {
            System.out.println(person + " не находится в " + this.getPlace());
        }
    }

    public void setPlace(Place place){
        this.place = place;
    }

    protected void remPlToPlace(Place pl,Place place){
        pl.remHorse(this);
        place.addHorse(this);
        this.setPlace(place);
    }

    public Place getPlace() {
        return place;
    }
}
