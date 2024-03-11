package CRUD;

import Configuration.DatabaseConnection;
import Model.*;
import Services.*;
import java.sql.*;
import java.util.*;
public class ActorCRUD {

    private static ActorCRUD actorCRUD;
    private ActorCRUD() { }

    public static ActorCRUD getInstance()
    {
        if (actorCRUD == null)
            actorCRUD = new ActorCRUD();

        return actorCRUD;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS ACTOR " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(40), " +
                "anDebut int);";

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
        String selectSql = "SELECT * FROM ACTOR;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            ResultSet resultSet = stmt.executeQuery(selectSql);

            // daca tabelul este gol se vor adauga date din CSV
            if (!resultSet.next())
            {
                List<Actor> actors = ReadWrite.readActor();

                for (Actor actor : actors)
                {
                    addActor(actor.getId(), actor.getNume(), actor.getAnDebut());
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addActor(int id, String nume, int anDebut)
    {
        String insertDomainSql = "INSERT INTO ACTOR(id, nume, anDebut) VALUES('" + id + "', '" +  nume + "', " + anDebut + ");";

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

    public void displayActors()
    {
        String selectSql = "SELECT * FROM ACTOR;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Nume Actor: " + resultSet.getString(2));
                System.out.println("Anul Debut Actor: " + resultSet.getInt(3));
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
