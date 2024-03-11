package Services;

import Model.Film;
import Model.Review;
import java.util.*;
public class ReviewService{

    private Queue<Review> recenzii = new LinkedList<>();

    private static ReviewService instance;

    public static ReviewService getInstance(){
        if (instance == null)
            instance = new ReviewService();
        return instance;
    }

    public List<Review> getReview(){
        List<Review> reviews = new ArrayList<>();
        reviews.addAll(this.recenzii);
        return reviews;
    }

//    public void updateReview (int index, Review review){
//        for (int i = 0; i < this.recenzii.size(); i++)
//            if(this.recenzii.element().getId() == index) {
//                this.recenzii.remove(i);
//                this.recenzii.add(i, review);
//                break;
//            }
//    }

    public void addReview (Review review){
        this.recenzii.offer(review);
    }

    public void deleteReview (Review review){
        for(int i = 0; i < this.recenzii.size(); i++)
            if (this.recenzii.element() == review){
                this.recenzii.remove(i);
                break;
            }
    }

    public Review readReview(){
        Scanner scanner = new Scanner(System.in);
        Review review = new Review();

        System.out.println("Text: ");
        review.setText(scanner.nextLine());

        System.out.println("Nota: ");
        review.setNota(Integer.parseInt(scanner.nextLine()));

        return review;
    }

    public void prinReview(Review review){
        System.out.println(review.toString());
    }

//    public  int maxId(){
//        int max = 0;
//        for(int i =0; i< recenzii.size(); i++){
//            if(recenzii.get(i).getId() > max){
//                max = recenzii.get(i).getId();
//            }
//        }
//        return max;
//    }

}
