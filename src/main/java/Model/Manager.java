package Model;

import java.util.*;
public class Manager extends Employee {

    private String departament;
    public Manager(int id, String nume, String prenume, String mail, String telefon, int salariu, String jobTitle, String departament) {
        super(id, nume, prenume, mail, telefon, salariu, jobTitle);
        this.departament = departament;
    }

    public Manager() {

    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return this.getNume() + " " + this.getPrenume() + " " +
                this.getMail() + " " + this.getTelefon() + " " + this.getDepartament();
    }
}
