import Enums.*;

import java.util.ArrayList;
import java.util.List;

public class Hostess extends Person implements Assignable{
    private List<Food> foodInventory;

    public Hostess(String name,
                   Place place,
                   Mood mood,
                   int hunger,
                   Profession profession,
                   Clothes clothes,
                   Gender gender) {
        super(name,place, mood, hunger, profession, clothes, gender);
        this.foodInventory = new ArrayList<>();
    }

    public Hostess(){
        this(
                "Mrs Barlow",
                TimeLine.getPlace(new Place(PlaceType.BLOOD_HOUSE)),
                Mood.CALM,
                80,
                Profession.HOSTESS,
                new Clothes(
                        HeadDress.NONE,
                        BodyClothes.DRESS,
                        LegsClothes.NONE,
                        Boots.SANDALS),
                Gender.FEMALE
        );
        this.foodInventory = new ArrayList<>();
    }

    public void grumbleBecauseOfEvent(Event event){
        System.out.println(this+" кудахчет из-за "+ event);
    }

    public void cook(Food food){
        if (this.getPlace().getPlaceType() == PlaceType.BLOOD_HOUSE){
            this.putToInv(food);
            System.out.println(this+" готовит "+food);
        }else {
            System.out.println(this + " не дома(");
        }
    }

    public void putToInv(Food food){
        this.foodInventory.add(food);
    }

    public void putOnTable(Food food){
        if (this.getPlace().placeObjects.contains(PlaceObject.TABLE)
        && this.foodInventory.contains(food)){
            this.getPlace().addFood(this.getOneFoodInv(food),this);
            System.out.println(this+" накрывает на стол "+food);
        }

    }

    public Food getOneFoodInv(Food food){
        if (this.foodInventory.contains(food)){
            this.foodInventory.remove(food);
            return food;
        }
        System.out.println(food+ " нет у "+this);
        return null;
    }

    public List<Food> getFoodInventory() {
        return foodInventory;
    }

    @Override
    public void doAssignment(Assignment assignment) {
        switch (assignment){
            case COOK_CHICKEN -> this.cook(Food.CHICKEN);
            case COOK_FISH -> this.cook(Food.FISH);
            case COOK_CORN -> this.cook(Food.CORN);
            case COOK_SALAD -> this.cook(Food.SALAD);
            default -> System.out.println(this+" занимается "+assignment);
        }
    }
}
