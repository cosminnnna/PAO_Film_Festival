package CRUD;

import Model.*;
import Services.*;
import java.sql.*;
import java.util.*;
import Configuration.DatabaseConnection;
public class FilmCRUD {
    private static FilmCRUD filmCRUD;
    private FilmCRUD() { }

    public static FilmCRUD getInstance()
    {
        if (filmCRUD == null)
            filmCRUD = new FilmCRUD();

        return filmCRUD;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS FILM " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(40), " +
                "anAparitie int);";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            stmt.execute(createTableSql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addData()
    {
        String selectSql = "SELECT * FROM FILM;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            ResultSet resultSet = stmt.executeQuery(selectSql);

            // daca tabelul este gol se vor adauga date din CSV
            if (!resultSet.next())
            {
                List<Film> films = ReadWrite.readFilm();

                for (Film film : films)
                {
                    addFilm(film.getId(), film.getNume(), film.getAnAparitie());
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addFilm(int id, String nume, int anAparitie)
    {

        String insertDomainSql = "INSERT INTO FILM(id, nume, anAparitie) VALUES('" + id + "', '" + nume + "', '" + anAparitie + "');";


        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            stmt.executeUpdate(insertDomainSql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void displayFilms()
    {
        String selectSql = "SELECT * FROM FILM;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Nume Film: " + resultSet.getString(2));
                System.out.println("Anul aparitiei: " + resultSet.getInt(3));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing films!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}