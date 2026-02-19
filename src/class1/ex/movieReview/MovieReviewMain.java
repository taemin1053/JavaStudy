package class1.ex.movieReview;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview movieReview1 = new MovieReview();
        movieReview1.title = "체인소맨";
        movieReview1.review = "레제 살려라 띠밤";
        MovieReview movieReview2 = new MovieReview();
        movieReview2.title = "어바웃 타임";
        movieReview2.review = "시간을 얼마나 소중하게 써야하는지 알려주는 영화";

        MovieReview[] movieReviews = {movieReview1, movieReview2};
        for (int i = 0; i < movieReviews.length; i++) {
            System.out.println("영화 제목: " + movieReviews[i].title + " 리뷰: " + movieReviews[i].review);
        }
    }
}
