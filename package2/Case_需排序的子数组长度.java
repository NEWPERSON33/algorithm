package package2;

public class Case_需排序的子数组长度 {
    public static void main(String [] arr){
        int Cas[] = {2,8,7,10,9} ;
        int [] a = findsegment(Cas , Cas.length) ;
        System.out.println("["+a[0] + "," + a[1] + "]");
    }

    public static int [] findsegment(int [] arr , int n){
        int p1 = -1 ;
        int p2 = -1 ;
        int max = arr[0] ;
        int min = arr[n - 1] ;
        int p1_1 = -1 ;
        int p2_1 = -1 ;
        int min_1 = arr[0] ;
        int max_1 = arr[n - 1] ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > max){
                max = arr[i] ;
            }
            if(arr[i] < max){
                p2 = i ;
            }
            if(arr[i] < min_1){
                min_1 = arr[i] ;
            }
            if(arr[i] > min_1){
                p2_1 = i ;
            }
        }
        for(int i = n - 1 ; i > -1 ; i--){
            if(arr[i] < min){
                min = arr[i] ;
            }
            if(arr[i] > min){
                p1 = i ;
            }
            if(arr[i] > max_1){
                max_1 = arr[i] ;
            }
            if(arr[i] < max_1){
                p1_1 = i ;
            }
        }
//        int p1_1 = -1 ;
//        int p2_1 = -1 ;
//        int min_1 = arr[0] ;
//        int max_1 = arr[n - 1] ;
//        for(int i = 0 ; i < n ; i++){
//            if(arr[i] < min_1){
//                min_1 = arr[i] ;
//            }
//            if(arr[i] > min_1){
//                p2_1 = i ;
//            }
//        }
//        for(int i = n - 1 ; i > -1 ; i--){
//            if(arr[i] > max_1){
//                max_1 = arr[i] ;
//            }
//            if(arr[i] < max_1){
//                p1_1 = i ;
//            }
//        }
        return ((p2 - p1) < (p2_1 - p1_1)) ? new int[]{p1 , p2} : new int[]{p1_1 , p2_1} ;
    }

}
