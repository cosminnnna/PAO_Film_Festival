package Model;

public class Employee extends Person {
    private int salariu;
    private String jobTitle;
    public Employee(int id, String nume, String prenume, String mail, String telefon, int salariu, String jobTitle) {
        super(id, nume, prenume, mail, telefon);
        this.salariu = salariu;
        this.jobTitle = jobTitle;

    }

    public Employee() {
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return this.getNume() + " " + this.getPrenume() + " " +
                this.getMail() + " " + this.getTelefon() + " " +
                this.getJobTitle() + " " + this.getSalariu();
    }
}
