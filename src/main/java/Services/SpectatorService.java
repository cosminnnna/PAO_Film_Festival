package Services;
import Model.Film;
import Model.Spectator;
import java.util.*;

public class SpectatorService {

    private List<Spectator> spectators = new ArrayList<>();
    private static SpectatorService instance;

    public static SpectatorService getInstance(){
        if(instance == null)
            instance = new SpectatorService();
        return instance;
    }

    public List<Spectator> getSpectators() {
        List<Spectator> spectators = new ArrayList<>();
        spectators.addAll(this.spectators);
        return spectators;
    }

    public void updateSpectator(int index, Spectator spectator){
        for (int i =0; i < this.spectators.size(); i++)
            if(this.spectators.get(i).getId() == index){
                this.spectators.remove(i);
                this.spectators.add(i, spectator);
                break;
            }
    }

    public void addSpectator(Spectator spectator){
        this.spectators.add(spectator);
    }

    public void deleteSpectator (Spectator spectator){
        for (int i = 0; i < spectators.size(); i++){
            if (this.spectators.get(i).equals(spectator)){
                this.spectators.remove(i);
                break;
            }
        }
    }

    public void deleteSpectatorById(int index){
        for (int i =0; i < this.spectators.size(); i++)
            if(this.spectators.get(i).getId() == index){
                this.spectators.remove(i);
                break;
            }
    }

    public Spectator readSpectator(){
        Scanner scanner = new Scanner(System.in);
        Spectator spectator = new Spectator();

        int id = maxId() + 1;

        spectator.setId(id);

        System.out.println("Nume: ");
        spectator.setNume(scanner.nextLine());

        System.out.println("Prenume: ");
        spectator.setPrenume(scanner.nextLine());

        System.out.println("Mail: ");
        spectator.setMail(scanner.nextLine());

        System.out.println("Telefon: ");
        spectator.setTelefon(scanner.nextLine());

        System.out.println("Locul pe care l-ai avut in sala: ");
        spectator.setLocSala(Integer.parseInt(scanner.nextLine()));

        return spectator;
    }

    public void prinSpectator(Spectator spectator){
        System.out.println(spectator.toString());
    }

    public int maxId(){
        int max = 0;
        for(int i =0; i < spectators.size(); i++){
            if(spectators.get(i).getId() > max){
                max = spectators.get(i).getId();
            }
        }
        return max;
    }
}
