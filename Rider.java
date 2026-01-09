import Enums.Gender;
import Enums.Mood;
import Enums.Profession;

public abstract class Rider extends Person{
    private Horse horse;

    public Rider(String name,
                 Place place,
                 Mood mood,
                 int hunger,
                 Profession profession,
                 Clothes clothes,
                 Gender gender,
                 Horse horse) {
        super(name, place, mood, hunger, profession, clothes, gender);
        this.horse = horse;
    }
    //tmp
    public void toHorse(Horse horse){
        if (this.getPlace().equals(horse.getPlace())) {
            horse.addToPersonList(this);
            this.setHorse(horse);
            System.out.println(this + " садится на " + horse);
        } else {
            System.out.println(this + " находится в " + this.getPlace()+
                    ", а "+horse + " в "+ horse.getPlace());
        }
    }

     public Horse getHorse(){
            return horse;
        }
    void setHorse(Horse horse){
            this.horse = horse;
        }
    void goTo(Place place, Horse horse){
        if (!this.getPlace().getHorses().isEmpty() && this.getPlace().getHorses().contains(horse)) {
            if (horse.getPersons().contains(this)) {
                if (this.isReady()){
                    this.remPlToPlace(this.getPlace(),place);
                    horse.remPlToPlace(horse.getPlace(),place);
                    System.out.println(this + " едет в "+ place+" на " + horse);
                } else {
                    System.out.println(this + " не готов ехать: "); // TODO добавить причины
                }
            } else {
                System.out.println(this + " не сидит на "+ horse);
            }
        } else {
            System.out.println(this.getPlace() + " не сожержит лошадей, либо только " + horse);
        }
    };
    void askToGoTo(Place place, Rider person, Horse horse){
        System.out.println(this + " предлагает " + person + " отправится в " + place + " на " + horse);
        if (this.isReady() && person.isReady()
                && horse.getPersons().contains(this)
                && horse.getPersons().contains(person)) {
            System.out.println("Все готовы!");
        }
        else {
            System.out.println("Кто то не готов(");
        }
    }

    private void remPlToPlace(Place current, Place future) {
        current.remPerson(this);
        future.addPerson(this);
        this.setPlace(future);
    }

}
