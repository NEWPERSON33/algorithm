package package2;

public class Case_同时求出数组的最大值和最小值 {
    public static void main(String [] arr){
        int [] find = { 1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10} ;
        for(int x : find_min_max(find)) {
            System.out.println(x);
        }
    }

    public static int [] find_min_max(int [] arr){
        int [] re = new int[2] ;
        int max = arr[0] ;
        int min = arr[0] ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i] ;
            }
            if(arr[i] < min){
                min = arr[i] ;
            }
        }
        re[0] = min ;
        re[1] = max ;
        return re ;
    }

}
