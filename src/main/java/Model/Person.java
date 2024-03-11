package Model;

public class Person {
    int id;
    private String nume;
    private String prenume;
    private String mail;
    private String telefon;

    public Person(int id, String nume, String prenume, String mail, String telefon) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
    }

    public Person(){

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

    public String getPrenume() {
        return prenume;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

//    @Override
//    public String toString() {
//        return nume + ' ' + prenume + ' ' +
//                mail + ' ' + telefon + " ";
//    }
}

