package Services;
import Model.Director;
import Model.Film;

import java.util.*;
public class DirectorService {

    private List<Director> directors = new ArrayList<>();
    private static DirectorService instance;

    public static DirectorService getInstance(){
        if(instance == null)
            instance = new DirectorService();
        return instance;
    }

    public List<Director> getDirectors() {
        List<Director> directors = new ArrayList<>();
        directors.addAll(this.directors);
        return directors;
    }

    public void updateDirector(int index, Director director){
        for (int i =0; i < this.directors.size(); i++)
            if(this.directors.get(i).getId() == index){
                this.directors.remove(i);
                this.directors.add(i, director);
                break;
            }
    }

    public void addDirector(Director director){
        this.directors.add(director);
    }

    public void deleteDirector(int index){
        for (int i =0; i < this.directors.size(); i++)
            if(this.directors.get(i).getId() == index){
                this.directors.remove(i);
                break;
            }
    }
    public void printDirector(Director director){
        System.out.println(director.toString());
    }

    public Director readDirector(){
        Scanner scanner = new Scanner(System.in);
        Director director = new Director();

        int id = maxId() + 1;

        director.setId(id);

        System.out.println("Nume: ");
        director.setNume(scanner.nextLine());

        System.out.println("An Debut: ");
        director.setAnDebut(Integer.parseInt(scanner.nextLine()));

        System.out.println("Cast Number: ");
        director.setCastNumber(Integer.parseInt(scanner.nextLine()));

        return director;
    }

    public int maxId(){
        int max = 0;
        for(int i =0; i< directors.size(); i++){
            if(directors.get(i).getId() > max){
                max = directors.get(i).getId();
            }
        }
        return max;
    }

}
