package Model;

public class Review {

    int id;
    private String text;
    private int nota;

    public Review(int id, String text, int nota) {
        this.text = text;
        this.nota = nota;
        this.id = id;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return this.getText() + " " + this.getNota();
    }
}
