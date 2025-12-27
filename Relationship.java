import Enums.ERelationship;

public class Relationship {
    private ERelationship relationship;
    private Person relWith;
    private Person relWho;

    Relationship(Person relWith,Person relWho,ERelationship relationship) {
        this.relWho = relWho;
        this.relWith = relWith;
        this.relationship = relationship;
    }

    public void setRelationship(ERelationship relationship) {
        this.relationship = relationship;
    }

    public Person getRelWho() {
        return relWho;
    }

    public void setRelWho(Person relWho) {
        this.relWho = relWho;
    }

    public Person getRelWith() {
        return relWith;
    }

    public void setRelWith(Person relWith) {
        this.relWith = relWith;
    }

    public ERelationship getRelationship(){
        return relationship;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "relWho='" + relWho + '\'' +
                "relWith='" + relWith + '\'' +
                "relationship='" + relationship + '\'' +
                '}';
    }
}
