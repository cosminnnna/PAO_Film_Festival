import Services.*;
import java.io.*;
import java.text.*;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
//        Service service = Service.getInstance();
//        service.menu();

        Menu m = Menu.getInstance();
        m.runMenu();
    }
}
