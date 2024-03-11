package Services;
import Model.Employee;
import Model.Film;
import Model.Manager;
import java.util.*;
public class ManagerService {
    private List<Manager> managers = new ArrayList<>();
    private static ManagerService instance;

    public static ManagerService getInstance(){
        if(instance == null)
            instance = new ManagerService();
        return instance;
    }

    public List<Manager> getManagers() {
        List<Manager> managers1 = new ArrayList<>();
        managers1.addAll(this.managers);
        return managers1;
    }

    public void updateManager(int index, Manager manager){
        for (int i =0; i < this.managers.size(); i++)
            if(this.managers.get(i).getId() == index){
                this.managers.remove(i);
                this.managers.add(i, manager);
                break;
            }
    }

    public void addManager(Manager manager){
        this.managers.add(manager);
    }

    public void deleteManager(int index){
        for (int i =0; i < this.managers.size(); i++)
            if(this.managers.get(i).getId() == index){
                this.managers.remove(i);
                break;
            }
    }
    public void printManager(Manager manager){
        System.out.println(manager.toString());
    }

    public Manager readManager(){
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        int id = maxId() + 1;

        manager.setId(id);

        System.out.println("Nume: ");
        manager.setNume(scanner.nextLine());

        System.out.println("Prenume: ");
        manager.setPrenume(scanner.nextLine());

        System.out.println("Mail: ");
        manager.setMail(scanner.nextLine());

        System.out.println("Telefon: ");
        manager.setTelefon(scanner.nextLine());

        System.out.println("Salariu: ");
        manager.setSalariu(Integer.parseInt(scanner.nextLine()));

        System.out.println("Job Title: ");
        manager.setJobTitle(scanner.nextLine());

        System.out.println("Departament: ");
        manager.setDepartament(scanner.nextLine());

        return manager;
    }

    public int maxId(){
        int max = 0;
        for(int i =0; i< managers.size(); i++){
            if(managers.get(i).getId() > max){
                max = managers.get(i).getId();
            }
        }
        return max;
    }
}
