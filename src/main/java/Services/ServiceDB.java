package Services;
import CRUD.ActorCRUD;
import CRUD.FilmCRUD;
import CRUD.ReviewCRUD;
import CRUD.SpectatorCRUD;
import Model.*;
import Services.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import Configuration.DatabaseConnection;

import javax.swing.plaf.PanelUI;
import javax.xml.crypto.Data;

public class ServiceDB {
    public static List<Film> films = new ArrayList<>();
    public static List<Review> reviews = new ArrayList<>();
    public static List<Actor> actors = new ArrayList<>();
    public static List<Spectator> spectators = new ArrayList<>();

    FilmCRUD filmCRUD = FilmCRUD.getInstance();
    ReviewCRUD reviewCRUD = ReviewCRUD.getInstance();
    ActorCRUD actorCRUD = ActorCRUD.getInstance();
    SpectatorCRUD spectatorCRUD = SpectatorCRUD.getInstance();
    AuditService auditService = AuditService.getInstance();

    // functie ca incarca datele din fisierele csv
    // in array-uri la inceputul programului
    public void loadData()
    {
        // salveaza din CSV in liste de obiecte
        films = ReadWrite.readFilm();
        reviews = ReadWrite.readReview();
        actors = ReadWrite.readActor();
        spectators = ReadWrite.readSpectator();

        // salveaza din CSV in baza de date
        // daca aceasta este goala
        filmCRUD.addData();
        reviewCRUD.addData();
        actorCRUD.addData();
        spectatorCRUD.addData();

        try
        {
            auditService.logAction("load data");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void configureTables()
    {
        filmCRUD.createTable();
        reviewCRUD.createTable();
        actorCRUD.createTable();
        spectatorCRUD.createTable();
        try
        {
            auditService.logAction("configure tables");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addFilm()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Film ID: ");
        int filmId;
        while(true)
        {
            try
            {
                filmId = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Film ID: ");
            }
        }

        System.out.print("Name of the film: ");
        String nume = reader.nextLine().toUpperCase();

        int anAparitie;
        System.out.print("An aparitie film: ");
        while(true)
        {
            try
            {
                anAparitie = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("An aparitie film: ");
            }
        }

        films.add(new Film(filmId, nume, anAparitie));
        ReadWrite.writeFilm(filmId, nume, anAparitie);
        filmCRUD.addFilm(filmId, nume, anAparitie);

        try
        {
            auditService.logAction("add film");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void printFilms() {
        filmCRUD.displayFilms();

        try
        {
            auditService.logAction("print films");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public void addReview()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Review ID: ");
        int reviewId;
        while(true)
        {
            try
            {
                reviewId = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Review ID: ");
            }
        }

        System.out.print("Write your review: ");
        String text = reader.nextLine().toUpperCase();

        int nota;
        System.out.print("Nota Festivalului: ");
        while(true)
        {
            try
            {
                nota = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Nota Festivalului: ");
            }
        }

        reviews.add(new Review(reviewId, text, nota));
        ReadWrite.writeReview(reviewId, text, nota);
        reviewCRUD.addReview(reviewId, text, nota);

        try
        {
            auditService.logAction("add actor");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printReviews() {
        reviewCRUD.displayReviews();
        try
        {
            auditService.logAction("print reviews");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }





    public void addActor()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Actor ID: ");
        int actorId;
        while(true)
        {
            try
            {
                actorId = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Actor ID: ");
            }
        }

        System.out.print("Nume Actor: ");
        String nume = reader.nextLine().toUpperCase();

        int anDebut;
        System.out.print("Anul de Debut: ");
        while(true)
        {
            try
            {
                anDebut = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Nota Festivalului: ");
            }
        }


        actors.add(new Actor(actorId, nume, anDebut));
        ReadWrite.writeActor(actorId, nume, anDebut);
        actorCRUD.addActor(actorId, nume, anDebut);

        try
        {
            auditService.logAction("add actor");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printActors() {
        actorCRUD.displayActors();
        try
        {
            auditService.logAction("print actors");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public void addSpectator()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Spectator ID: ");
        int spectatorId;
        while(true)
        {
            try
            {
                spectatorId = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Spectator ID: ");
            }
        }

        System.out.print("Nume Spectator: ");
        String nume = reader.nextLine().toUpperCase();

        System.out.print("Prenume Spectator: ");
        String prenume = reader.nextLine().toUpperCase();

        System.out.print("Mail Spectator: ");
        String mail = reader.nextLine().toUpperCase();

        System.out.print("Telefon Spectator: ");
        String telefon = reader.nextLine().toUpperCase();



        int locSala;
        System.out.print("Locul in sala: ");
        while(true)
        {
            try
            {
                locSala = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Locul in sala: ");
            }
        }

        spectators.add(new Spectator(spectatorId, nume, prenume, mail, telefon, locSala));
        ReadWrite.writeSpectator(spectatorId, nume, prenume, mail, telefon, locSala);
        spectatorCRUD.addSpectator(spectatorId, nume, prenume, mail, telefon, locSala);

        try
        {
            auditService.logAction("add spectator");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printSpectators() {
        spectatorCRUD.displaySpectators();
        try
        {
            auditService.logAction("print spectators");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void closeConnection()
    {
        DatabaseConnection.closeDatabaseConnection();

        try
        {
            auditService.logAction("Close connection with database.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
