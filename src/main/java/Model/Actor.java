package Model;

public class Actor {

    private int id;
    private String nume;
    private int anDebut;


    public Actor(int id, String nume, int anDebut) {
        this.nume = nume;
        this.anDebut = anDebut;
        this.id = id;
    }

    public Actor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAnDebut() {
        return anDebut;
    }

    public void setAnDebut(int anDebut) {
        this.anDebut = anDebut;
    }

    @Override
    public String toString() {
        return "Actor = { nume = " + this.nume + ", an debut = " + this.anDebut + "}";
    }
}
