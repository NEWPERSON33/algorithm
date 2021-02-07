package package2;

public class Case_寻找数组中超过一半的数 {
    public static void main(String [] arr){

        int arr_C [] = {1 , 3  ,1 ,1 , 4 , 1 } ;
        System.out.println(find_M_H(arr_C));

    }

    public static int find_M_H(int [] arr){
        int now_vual = arr[0] ;
        int ntimes = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(ntimes == 0){
                now_vual = arr[i] ;
                ntimes = 1 ;
                continue;
            }

            if(now_vual == arr[i]){
                ntimes++ ;
            }else{
                ntimes-- ;
            }
        }
        return now_vual ;
    }

}
