package Services;

import Model.Film;

import java.util.*;
public class FilmService {
    private List<Film> films = new ArrayList<>();
    private static FilmService instance;
    public static FilmService getInstance(){
        if (instance == null)
            instance = new FilmService();
        return instance;
    }

    public static class FilmNotFoundException extends Exception{
        public FilmNotFoundException (String message){
            super(message);
        }
    }

    public List<Film> getFilms(){
        List<Film> films = new ArrayList<>();
        films.addAll(this.films);
        return films;
    }

    public Film getFilmByName (String name) throws FilmNotFoundException {
        Film film = new Film();
        boolean ok = false;

        for (int i = 0; i < this.films.size(); i++){
            if(this.films.get(i).getNume().equals(name)){
                film = this.films.get(i);
                ok = true;
            }
        }

        if(ok)
            return film;
        else throw new FilmNotFoundException("Film not found");

    }

    public Film getFilmById (int id) throws FilmNotFoundException {
        Film film = new Film();
        boolean ok = false;

        for (int i = 0; i < this.films.size(); i++){
            if(this.films.get(i).getId() == id){
                film = this.films.get(i);
                ok = true;
            }
        }

        if(ok)
            return film;
        else throw new FilmNotFoundException("Film not found");

    }

    public void updateFilm (Film film){
        for (int i =0; i < this.films.size(); i++)
            if(this.films.get(i).equals(film)){
                this.films.remove(i);
                this.films.add(i, film);
                break;
            }
    }

    public void addFilm (Film film){
        this.films.add(film);
    }

    public void deleteFilm (Film film){
        for (int i = 0; i < films.size(); i++){
            if (this.films.get(i).equals(film)){
                this.films.remove(i);
                break;
            }
        }
    }

    public void deleteFilmById (int id){
        for (int i = 0; i < films.size(); i++){
            if (this.films.get(i).getId() == id){
                this.films.remove(i);
                break;
            }
        }
    }

    public void deleteFilmByName(String name){
        for (int i = 0; i < films.size(); i++){
            if (this.films.get(i).getNume().equals(name)){
                this.films.remove(i);
                break;
            }
        }
    }

    public Film readFilm (){
        Scanner scanner = new Scanner(System.in);
        Film film = new Film();

        int id = maxId() +1;

        film.setId(id);

        System.out.println("Nume Film: ");
        film.setNume(scanner.nextLine());

        System.out.println("An Aparitie Film: ");
        film.setAnAparitie(Integer.parseInt(scanner.nextLine()));

        return film;
    }

    public void printFilm(Film film){
        System.out.println(film.toString());
    }

    public  int maxId(){
        int max = 0;
        for(int i =0; i< films.size(); i++){
            if(films.get(i).getId() > max){
                max = films.get(i).getId();
            }
        }
        return max;
    }


}
