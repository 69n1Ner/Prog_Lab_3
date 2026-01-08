import java.util.ArrayList;
import java.util.List;

public class Horse implements Movable{
    private String name;
    private ArrayList<MovablePerson> personList;
    private Place place;

    public Horse(String name,Place place, ArrayList<MovablePerson> personList) {
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
    public void goTo(Place place){
        
    }

    public ArrayList<MovablePerson> getPersons(){
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
