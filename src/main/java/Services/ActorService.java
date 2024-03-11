package Services;
import Model.Actor;
import Model.Film;

import java.util.*;
public class ActorService {

    private List<Actor> actors = new ArrayList<>();
    private static ActorService instance;
    public static ActorService getInstance(){
        if(instance == null)
            instance = new ActorService();
        return instance;
    }

    public List<Actor> getActors() {
        List<Actor> actors = new ArrayList<>();
        actors.addAll(this.actors);
        return actors;
    }

    public void updateActor(int index, Actor actor){
        for (int i =0; i < this.actors.size(); i++)
            if(this.actors.get(i).getId() == index){
                this.actors.remove(i);
                this.actors.add(i, actor);
                break;
            }
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void deleteActor(int index){
        for (int i =0; i < this.actors.size(); i++)
            if(this.actors.get(i).getId() == index){
                this.actors.remove(i);
                break;
            }
    }
    public void printActor(Actor actor){
        System.out.println(actor.toString());
    }

    public Actor readActor(){
        Scanner scanner = new Scanner(System.in);
        Actor actor = new Actor();

        int id = maxId() + 1;

        actor.setId(id);

        System.out.println("Nume: ");
        actor.setNume(scanner.nextLine());

        System.out.println("An Debut: ");
        actor.setAnDebut(Integer.parseInt(scanner.nextLine()));

        return actor;
    }

    public int maxId(){
        int max = 0;
        for(int i =0; i< actors.size(); i++){
            if(actors.get(i).getId() > max){
                max = actors.get(i).getId();
            }
        }
        return max;
    }
}
