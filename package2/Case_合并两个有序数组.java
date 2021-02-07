package package2;

public class Case_合并两个有序数组 {
    public static void main(String [] arr){
        int arr_1[] = {5 , 7  , 0 , 0 , 0 , 0 , 0 , 0} ;
        int arr_2[] = {1 , 3 , 5} ;
        combine(arr_1 , 2 , arr_1.length , arr_2 , 3);
        for(int x : arr_1){
            System.out.println(x);
        }
    }

    public static void combine(int[] arr1 , int n1 , int arr1_length , int [] arr2 , int n2 ){
        int current = n1 + n2 - 1 ;
        int p1 = n1 - 1 ;
        int p2 = n2 - 1 ;
        while(p1 >= 0 && p2 >= 0){
            if(arr1[p1] >= arr2[p2]){
                arr1[current] = arr1[p1] ;
                current-- ;
                p1-- ;
            }else{
                arr1[current] = arr2[p2] ;
                current-- ;
                p2-- ;
            }
        }
        while(p2 >= 0) {
            arr1[current] = arr2[p2] ;
            p2-- ;
            current-- ;
        }
    }



//    public static  void swap(int [] arr , int one , int two){
//        int  n  = 0 ;
//        n = arr[one] ;
//        arr[one] = arr[two] ;
//        arr[two] = n ;
//    }

}
