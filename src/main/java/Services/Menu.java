package Services;
import java.util.Scanner;
public class Menu {

    private static Menu menu = null;
    private static final ServiceDB service = new ServiceDB();

    // private constructor
    private Menu()
    {
        service.configureTables();
        service.loadData();
    }


    public static Menu getInstance()
    {
        if (menu == null) menu = new Menu();

        return menu;
    }

    private void showMenu()
    {
        System.out.println("Choose an action.");
        System.out.println("1: Add new film");
        System.out.println("2: Print all films");
        System.out.println("3: Add new review");
        System.out.println("4: Print all reviews");
        System.out.println("5: Add new actor");
        System.out.println("6: Print all actors");
        System.out.println("7: Add new high spectator");
        System.out.println("8: Print all high spectators");
        System.out.println("0: Exit");
    }

    public void runMenu()
    {
        showMenu();

        Scanner reader = new Scanner(System.in);
        int option;
        String check;

        do
        {
            option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 0 -> {
                    service.closeConnection();
                    System.out.println("Exiting program..");
                }
                case 1 -> {
                    service.addFilm();
                    System.out.println("-----------------------------------");
                }
                case 2 -> {
                    service.printFilms();
                    System.out.println("-----------------------------------");
                }
                case 3 -> {
                    service.addReview();
                    System.out.println("-----------------------------------");
                }
                case 4 -> {
                    service.printReviews();
                    System.out.println("-----------------------------------");
                }
                case 5 -> {
                    service.addActor();
                    System.out.println("-----------------------------------");
                }
                case 6 -> {
                    service.printActors();
                    System.out.println("-----------------------------------");
                }
                case 7 -> {
                    service.addSpectator();
                    System.out.println("-----------------------------------");
                }
                case 8 -> {
                    service.printSpectators();
                    System.out.println("-----------------------------------");
                }
                default -> System.out.println("Invalid option. Try again.");
            }

            if (option != 0)
            {
                System.out.println("Do you want another action? yes/no");
                check = reader.nextLine();
                check = check.toLowerCase();

                if (check.equals("yes")) showMenu();
                else {
                    option = 0;
                    service.closeConnection();
                    System.out.println("Exiting program...");
                }
            }

        } while (option != 0);

        reader.close();
    }

}
