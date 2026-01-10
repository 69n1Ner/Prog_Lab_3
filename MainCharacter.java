import Enums.*;

import java.util.Random;

public class MainCharacter extends Rider implements Actionable{
    private Tool tool;

    public MainCharacter(String name,
                         Place place,
                         Mood mood,
                         int hunger,
                         Profession profession,
                         Clothes clothes,
                         Gender gender,
                         Horse horse) {
        super(name, place,mood, hunger, profession, clothes, gender,horse);
    }

    public MainCharacter() {
        this(
                "Peter",
                null,
                Mood.CALM,
                30,
                Profession.DOCTOR,
                new Clothes(
                        HeadDress.NONE,
                        BodyClothes.NIGHTY,
                        LegsClothes.SHORTS,
                        Boots.NONE),
                Gender.MALE,
                null
        );
    }

    public void assignmentTo(Assignment assignment,Assignable person){
        System.out.println(this+" поручает "+person +" "+ assignment);
        person.doAssignment(assignment);
    }

    public void searchForClothes(Place place, Clothes clothes) {
        System.out.print(this + " ищет " +
                clothes.getBody() + " " +
                clothes.getLegs() + " " +
                clothes.getBoots() + " в " + place);
        if (place.getPlaceType() == this.getPlace().getPlaceType()) {
            this.addClothesToInv(clothes);
            System.out.println(" и находит!");
        } else {
            System.out.println(" и ничего находит(");
        }
    }

    public void searchForTools(Place place, Tool tools) {
        System.out.print(this + " ищет " + tools + " в " + place);
        if (place.getPlaceType() == this.getPlace().getPlaceType()) {
            this.tool = tools;
            System.out.println(" и находит!");
            System.out.println(this+" берет "+tools+" с собой");
        } else {
            System.out.println(" и ничего находит(");
        }
    }

    public Tool getTool(){
        return tool;
    }

    @Override
    public boolean isReady(){
        if (
                this.getClothes().getBody() != BodyClothes.NIGHTY &&
                this.getClothes().getBoots() != Boots.NONE &&
                this.getClothes().getLegs() !=  LegsClothes.NONE &&
                this.getTool() != null
        ){
           return true;
        }
        System.out.println(this+" не готов(");
        return false;
    }
}
