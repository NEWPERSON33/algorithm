package package2;

public class Case_计数排序 {
    public static void main(String [] arr){
        int [] CS = {12 , -4 , -4 , 3} ;
        count_sort(CS);
        for(int x : CS){
            System.out.println(x);
        }
    }

    public static int find_max(int [] arr){
        int max = arr[0] ;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i] ;
            }
        }
        return max ;
    }

    public static int find_min(int [] arr){
        int min = arr[0] ;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] < min){
                min = arr[i] ;
            }
        }
        return min ;
    }

    public static void count_sort(int [] arr){
        int end = find_max(arr) ;
        int begin = find_min(arr) ;
        int current = 0 ;
        int [] helper = new int[end - begin + 1] ;
        for(int i = 0 ; i < arr.length ; i++){
                helper[arr[i] - begin]++ ;
        }
        for(int i = 0 ; i < end - begin + 1 ; i++){
            while(helper[i] > 0){
                arr[current++] = i + begin ;
                helper[i]-- ;
            }
        }
    }

}
