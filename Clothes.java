import Enums.BodyClothes;
import Enums.Boots;
import Enums.HeadDress;
import Enums.LegsClothes;

public class Clothes {
    HeadDress head;
    BodyClothes body;
    LegsClothes legs;
    Boots boots;


    public Clothes(HeadDress head,
                   BodyClothes body,
                   LegsClothes legs,
                   Boots boots) {
        this.head = head;
        this.body = body;
        this.legs = legs;
        this.boots = boots;
    }

    public Clothes(Clothes clothes) {
        this(clothes.getHead(),clothes.getBody(),clothes.getLegs(),clothes.getBoots());
    }

    @Override
    public String toString() {
        if (head == HeadDress.NONE && boots != Boots.NONE){
            return body+","+legs+","+boots;
        } else if (head == HeadDress.NONE && legs == LegsClothes.NONE) {
            return body + "," + boots;
        }else if (head == HeadDress.NONE && boots == Boots.NONE ){
            return body+","+legs;
        } else {
            return head+","+body+","+legs+","+boots;
        }
    }

    public HeadDress getHead() {
        return head;
    }

    public BodyClothes getBody() {
        return body;
    }

    public LegsClothes getLegs() {
        return legs;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setHead(HeadDress head) {
        this.head = head;
    }

    public void setBody(BodyClothes body) {
        this.body = body;
    }

    public void setLegs(LegsClothes legs) {
        this.legs = legs;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }


}
