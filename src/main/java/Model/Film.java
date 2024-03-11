package Model;

public class Film {

    private int id;
    private String nume;
    private int anAparitie;

    public Film(int id, String nume, int anAparitie) {
        this.id = id;
        this.nume = nume;
        this.anAparitie = anAparitie;
    }

    public Film() {}

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

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    @Override
    public String toString() {
        return this.getNume() + " " + this.getAnAparitie();
    }
}
