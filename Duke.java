import Enums.*;

public class Duke extends Person {
    private int famous = 1;

    public Duke(String name,
                Place place,
                Mood mood,
                int hunger,
                Profession profession,
                Clothes clothes,
                Gender gender) {
        super(name,place, mood, hunger, profession, clothes, gender);
    }

    public Duke(){
        this(
                "James",
                TimeLine.getPlace(new Place(PlaceType.OUTSIDE)),
                Mood.SAD,
                50,
                Profession.DUKE,
                new Clothes(HeadDress.HAT,
                        BodyClothes.SHIRT,
                        LegsClothes.PANTS,
                        Boots.SHOES),
                Gender.MALE);
    }

    public int getFamous() {
        return famous;
    }

    public void setFamous(int famous) {
        this.famous = famous;
    }
}
