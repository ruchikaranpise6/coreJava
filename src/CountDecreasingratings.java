import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDecreasingratings {
    public static void main(String[] args) {
        Integer[] rating = new Integer[]{4, 4, 2, 3,1};
        System.out.println(countDecreasingRatings(Arrays.asList(rating)));
    }

    public static long countDecreasingRatings(List<Integer> ratings) {
        // Write your code here
        long count = 0;

        for(int i = 0 ; i< ratings.size() ; i++){

            for(int j = i+1 ; j< ratings.size() ; j++){

                if(ratings.get(j) < ratings.get(i)){
                    count ++;
                }else {
                    break;
                }

            }

        }

        return count;

    }

}
