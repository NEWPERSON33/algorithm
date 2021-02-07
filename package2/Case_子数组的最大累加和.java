package package2;

public class Case_子数组的最大累加和 {
    public static void main(String [] arr){
        int A_1 [] = {-1 , 0 , -1} ;
        System.out.println(find_array_max_sum_ps(A_1));
    }

    public static int find_array_max_sum(int []arr){
        int N = arr.length ;
        int max  = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        int sum ;
        for(int i = 0 ; i < N - 1 ; i++){
            sum = arr[i] ;
            for(int j = i + 1 ; j < N ; j++){
                sum += arr[j] ;
                if(sum > max){
                    max = sum ;
                }
                if(sum < 0 && j != N - 1){
                    i = j+1 ;
                    break;
                }

            }
        }
        return  max ;

    }

    public static int find_array_max_sum_ps(int[]arr){
        int N = arr.length ;
        int sum = arr[0] ;
        int max = sum ;
        int left = 0 ;
        int right = 0 ;
        for(int j = 1 ; j < N ; j++){
            if(sum >= 0){
                sum += arr[j] ;
            }else{
                sum = arr[j] ;
                left = j ;
            }
            if(sum > max){
                max = sum ;
                right = j ;
            }
        }
        return max ;
    }

}
