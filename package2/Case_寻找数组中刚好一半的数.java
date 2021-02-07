package package2;

public class Case_寻找数组中刚好一半的数 {
    public static void main(String [] arr){
        int arr_H[] = {1 , 3 , 1 , 1 , 4 , 6} ;
        System.out.println(find_H(arr_H)) ;
    }

    public static int find_H(int [] arr){
        int now_vual = arr[0] ;
        int ntimes = 0 ;
        int final_vual_time = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == arr[arr.length - 1]){
                final_vual_time++ ;
            }

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
        if(final_vual_time == arr.length / 2){
            return arr[arr.length - 1] ;
        }else{
            return now_vual ;
        }
    }

}
