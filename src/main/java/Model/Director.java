package Model;

public class Director extends Actor {

    int castNumber; //nr de actori pe care ii coordoneaza
    public Director(int id, String nume, int anDebut, int castNumber){
        super(id, nume, anDebut);
        this.castNumber = castNumber;
    }

    public Director() {

    }

    public int getCastNumber() {
        return castNumber;
    }

    public void setCastNumber(int castNumber) {
        this.castNumber = castNumber;
    }

    @Override
    public String toString() {
        return this.getNume() + " " + this.getAnDebut()
                + " " + this.getCastNumber();

    }
}
