package Model;

public class Spectator extends Person {
    int locSala;
    public Spectator(int id, String nume, String prenume, String mail, String telefon, int locSala) {
        super(id, nume, prenume, mail, telefon);
        this.locSala = locSala;
    }

    public Spectator() {

    }

    public int getLocSala() {
        return locSala;
    }

    public void setLocSala(int locSala) {
        this.locSala = locSala;
    }

    @Override
    public String toString() {
        return this.getNume() + " " + this.getPrenume() + " " +
                this.getMail() + " " + this.getTelefon() + " " + this.getLocSala();
    }
}
