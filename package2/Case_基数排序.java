package package2;
import java.util.ArrayList;

import static package2.Case_计数排序.find_max ;
import static package2.Case_计数排序.find_min ;
import static package2.Case_高效地求a的n次方.pow_1 ;

public class Case_基数排序 {

    public static ArrayList [] bucket = new ArrayList[10] ;

    static{
        for(int i = 0 ; i < bucket.length ; i++) {
            bucket[i] = new ArrayList();
        }
    }


    public static void main(String []arr){
        int [] b_ucket = { 1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10} ;
        bucket_sort(b_ucket);
        for(int x : b_ucket){
            System.out.println(x);
        }
    }

    public static void bucket_sort(int [] arr ) {
        int max = find_max(arr) ;
        int min = find_min(arr) ;
        int Nbit = 1;
        while (max / 10 != 0) {
            Nbit++;
            max /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] -= min;

        }
           for(int i = 1 ; i <= Nbit ; i++ ) {
                sort(arr, i , min);
           }

    }

    public static void sort(int [] arr , int i , int min) {
        int current = 0 ;
        for (int j = 0; j < arr.length; j++) {
            int pos = (arr[j] / (int) pow_1(10, i - 1)) % 10;
            bucket[pos].add(arr[j] + min);
        }

        for(int j = 0 ; j < bucket.length ; j++){
            for(Object m : bucket[j]) {
                arr[current++] = (Integer) m;
            }
        }
        clear_all();
    }

    public static void clear_all(){
        for(ArrayList b : bucket){
            b.clear();
        }
    }

}
