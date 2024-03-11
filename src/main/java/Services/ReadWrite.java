package Services;

import Model.*;
import Services.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ReadWrite {

    public static void writeFilm(int id, String nume, int anAparitie){

        String file = "src\\main\\java\\Files\\films.csv";
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String subjectString = id + "," + nume + "," + anAparitie;
            pw.println(subjectString);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static List<Film> readFilm()
    {
        List<Film> films = new ArrayList<>();
        String file = "src\\main\\java\\Files\\films.csv";
        BufferedReader reader;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String nume = row[1];
                int anAparitie = Integer.parseInt(row[2]);

                films.add(new Film( id, nume, anAparitie));
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return films;
    }


    public static void writeReview(int id, String text, int nota){

        String file = "src\\main\\java\\Files\\reviews.csv";
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String subjectString = id + "," + text + "," + nota;
            pw.println(subjectString);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static List<Review> readReview()
    {
        List<Review> reviews = new ArrayList<>();
        String file = "src\\main\\java\\Files\\reviews.csv";
        BufferedReader reader;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String text = row[1];
                int nota = Integer.parseInt(row[2]);

                reviews.add(new Review( id, text, nota));
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return reviews;
    }



    public static void writeSpectator(int id, String nume, String prenume, String mail, String telefon, int locSala){

        String file = "src\\main\\java\\Files\\spectators.csv";
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String subjectString = id + "," + nume + "," + prenume + "," + mail + "," + telefon + "," + locSala;
            pw.println(subjectString);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static List<Spectator> readSpectator()
    {
        List<Spectator> spectators = new ArrayList<>();
        String file = "src\\main\\java\\Files\\spectators.csv";
        BufferedReader reader;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String nume = row[1];
                String prenume = row[2];
                String mail = row[3];
                String telefon = row[4];
                int locSala = Integer.parseInt(row[5]);

                spectators.add(new Spectator( id, nume, prenume, mail, telefon, locSala));
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return spectators;
    }

    public static void writeActor(int id, String nume, int anDebut) {

        String file = "src\\main\\java\\Files\\actors.csv";
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String subjectString = id + "," + nume + "," + anDebut;
            pw.println(subjectString);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static List<Actor> readActor()
    {
        List<Actor> actors = new ArrayList<>();
        String file = "src\\main\\java\\Files\\actors.csv";
        BufferedReader reader;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String nume = row[1];
                int anDebut = Integer.parseInt(row[2]);

                actors.add(new Actor( id, nume, anDebut));
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return actors;
    }

}
