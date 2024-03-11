package CRUD;

import Configuration.DatabaseConnection;
import Model.*;
import Services.*;
import java.sql.*;
import java.util.*;

public class ReviewCRUD {

    private static ReviewCRUD reviewCRUD;
    private ReviewCRUD() { }

    public static ReviewCRUD getInstance()
    {
        if (reviewCRUD == null)
            reviewCRUD = new ReviewCRUD();

        return reviewCRUD;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS REVIEW " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "text varchar(40), " +
                "nota int);";

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
        String selectSql = "SELECT * FROM REVIEW;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            ResultSet resultSet = stmt.executeQuery(selectSql);

            // daca tabelul este gol se vor adauga date din CSV
            if (!resultSet.next())
            {
                List<Review> reviews = ReadWrite.readReview();

                for (Review review : reviews)
                {
                    addReview(review.getId(), review.getText(), review.getNota());
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addReview(int id, String text, int nota)
    {
        String insertDomainSql ="INSERT INTO REVIEW(id, text, nota) VALUES('" + id + "', '" + text + "', " + nota + ");";


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

    public void displayReviews()
    {
        String selectSql = "SELECT * FROM REVIEW;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Reviwe Festival: " + resultSet.getString(2));
                System.out.println("Nota festival: " + resultSet.getInt(3));
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
