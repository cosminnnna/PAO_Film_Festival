package Services;

import Model.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Service {

    private FilmService filmService = FilmService.getInstance();
    private ActorService actorService = ActorService.getInstance();
    private DirectorService directorService = DirectorService.getInstance();
    private EmployeeService employeeService = EmployeeService.getInstance();
    private ManagerService managerService = ManagerService.getInstance();
    private ReviewService reviewService = ReviewService.getInstance();
    private SpectatorService spectatorService = SpectatorService.getInstance();

    private static Service instance;

    private Scanner scanner = new Scanner(System.in);

    private Service(){}

    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    public void menu() throws ParseException, IOException{
        System.out.println("Bine ai venit. Urmeaza sa te inregistrezi ca spectator sau ca organizator?");
        String caz = scanner.nextLine();
        int op;

        if(caz.equals("organizator"))
            op = 1;
        else
            op = 0;

        if(op == 1){
            //crud pe obiecte
            while (true){
                printMenu(op);
                int opt;
                while (true) {
                    String line = scanner.nextLine();
                    try {
                        opt = Integer.parseInt(line);
                        if (opt >= 1 && opt <= 6) {
                            break;
                        }
                        else
                            System.out.println("Enter a valid number.");
                    } catch (Exception e){
                        System.out.println("Enter a valid number.");
                    }
                }

                if(opt == 1){
                    //add actor
                    //System.out.println("Aici e Add Actor.");
                    Actor actor = actorService.readActor();
                    actorService.addActor(actor);
                    actorService.printActor(actor);
                }

                else if (opt == 2) {
                    //add director
                    //System.out.println("Aici e Add Director.");
                    Director director = directorService.readDirector();
                    directorService.addDirector(director);
                    directorService.printDirector(director);
                }
                else if (opt == 3){
                    //add employee
                    //System.out.println("Aici e Add Employee.");
                    Employee employee = employeeService.readEmployee();
                    employeeService.addEmployee(employee);
                    employeeService.printEmployee(employee);
                }
                else if (opt == 4){
                    //add manager
                    //System.out.println("Aici e Add Manager.");
                    Manager manager = managerService.readManager();
                    managerService.addManager(manager);
                    managerService.printManager(manager);
                }
                else if (opt == 5)
                    filmMenu();
                else if (opt == 6)
                    break;
            }
        }

        else
        {
            //aici se inregsireaza spectator
            //alege daca vrea sa lase un review
            int info = 0;
            System.out.println("Inregistreaza-te: ");
            while (info == 0){
                Spectator spectator = spectatorService.readSpectator();
                spectatorService.addSpectator(spectator);
                spectatorService.prinSpectator(spectator);
                System.out.println("\n Informatiile sunt corecte? (da/nu) \n");
                String ok = scanner.nextLine();
                if(ok.equals("da"))
                    info = 1;
                else {
                    spectatorService.deleteSpectator(spectator);
                    System.out.println("Informatiile dvs s-au sters. Inregistreaza-te din nou.");
                }
            }
            System.out.println("\n Doresti sa lasi un review pentru festival? (da/nu) \n");
            String ok = scanner.nextLine();
            if(ok.equals("da")) {
                Review review = reviewService.readReview();
                reviewService.addReview(review);
                System.out.println("\n  Acesta e review-ul: \n");
                reviewService.prinReview(review);
                System.out.println("\n  Multumim pentru feedback! \n");
            }
        }
    }


    public void filmMenu(){
        while (true){
            printFilmMenu();
            int opt;
            while (true) {
                String line = scanner.nextLine();
                try {
                    opt = Integer.parseInt(line);
                    if (opt >= 1 && opt <= 7) {
                        break;
                    }
                    else
                        System.out.println("Enter a valid number.");
                } catch (Exception e){
                    System.out.println("Enter a valid number");
                }
            }

            Film film;

            if(opt == 1) {
                //read
                film = filmService.readFilm();
                filmService.addFilm(film);
            }
            else if (opt == 2) {
                //update
                System.out.println("Scrie numele filmului caruia vrei sa-i faci update.");
                String nume = scanner.nextLine();
                try {
                    film = filmService.getFilmByName(nume);
                    filmService.updateFilm(film);
                } catch (FilmService.FilmNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
            else if (opt == 3) {
                //delete
                System.out.println("Scrie numele filmului pe care vrei sa l stergi.");
                String nume = scanner.nextLine();
                try {
                    film = filmService.getFilmByName(nume);
                    filmService.deleteFilm(film);
                } catch (FilmService.FilmNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
            else if (opt == 4) {
                //delete by name ??
                System.out.println("Aici e DeleteByName Film.");

            }
            else if (opt == 5) {
                //delete by id ??
                System.out.println("Aici e DeleteById Film.");

            }
            else if (opt == 6) {
                //print
                if(filmService.getFilms().size() == 0){
                    System.out.println("No films.");
                }
                else {
                    System.out.println("Filmele adaugate pana acum sunt: ");
                    for(int i = 0; i < filmService.getFilms().size(); i++) {
                        filmService.printFilm(filmService.getFilms().get(i));
                    }
                }
            }
            else if (opt == 7)
                break;
        }
    }

    public void printFilmMenu(){
        System.out.println("Film Menu Options: \n 1. Citeste film. \n 2. Update film. \n 3. Delete film. \n 4. Delete film by name. \n 5. Delete film by id. \n 6. Print film. \n 7. Exit.");
    }

    public void printMenu(int caz){
        if (caz == 1)
            System.out.println("Tasteaza numarul comezii pe care doresti sa o efectuezi: \n 1. Adauga Actor. \n 2. Adauga Director. \n 3. Adauga Employee. \n 4. Adauga Mamager. \n " +
                    "5. Comenzi pentru Film. \n 6. Exit.");
    }
}
