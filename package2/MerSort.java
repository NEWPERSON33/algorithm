package package2;
/**
 * p44逆序对
 */

import java.util.Arrays;

public class MerSort {
     //static final  int LEN = 15 ;
     //static int [] help = new int[LEN] ;
    static int NI_XU = 0 ;
    private static int [] help ;

    public static void main(String[] arr){
        //System.out.println(help.length);
        int arrs_X_Q_M[] = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        //merge_sort(arrs_X_Q_M , 0 , arr.length - 1) ;
        sort(arrs_X_Q_M);
        for(int x : arrs_X_Q_M){
            System.out.print(x+" ");
        }
        System.out.println("");
        System.out.println(NI_XU) ;
    }

    public static  void merge_sort(int[] arr , int p , int r){
        if(p < r){
            int mid_index = p + (( r - p ) >>1 ) ;
            merge_sort(arr , p , mid_index) ;
            merge_sort(arr , mid_index + 1 , r) ;
            merge(arr , p , mid_index , r) ;
        }
    }

    public static void merge(int [] arr , int p , int mid , int r){
        //copy(arr , p , r) ;
        System.arraycopy(arr , p , help , p , r - p + 1);
        int left = p ;
        int right = mid + 1 ;
        int current = p ;

        while(left <= mid && right <= r){
            if(help[left] <= help[right]){
                arr[current] = help[left] ;
                current++ ;
                left++ ;
            }else{
                NI_XU += mid - left + 1 ;
                arr[current] = help[right] ;
                current++ ;
                right++ ;
            }
        }
        while(left <= mid){
            arr[current] = help[left] ;
            left++ ;
            current++ ;
        }

    }

    //拷贝数组
    //public static void copy(int [] arr  , int p ,int r){
        //for(int i = p ; i <= r ; i++){
         //   help[i] = arr[i] ;
        //}
   // }
    public static void sort(int [] arr){
        help = new int[arr.length] ;
        merge_sort(arr , 0 , arr.length - 1);
    }
}
