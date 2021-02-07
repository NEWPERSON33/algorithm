package package2;

public class Case_寻找最小可用ID {
    public static void main(String [] arr){
        int [] arr_i = { 1 , 4, 3 , 4} ;
        System.out.println(find_ID_g(arr_i , 0 , arr_i.length - 1)) ;

    }

    public static int find_ID(int [] arr){
        int n = arr.length + 1 ;
        boolean [] arr_F = new boolean[n] ;
        for(int i = 0 ; i < n - 1 ; i++){
            if(arr[i] < n ){
                arr_F[arr[i]] = true ;
            }
        }
        for(int i = 1 ; i < n ; i++){
            if(arr_F[i] != true){
                return i ;
            }
        }
        return n  ;
    }

    public static int find_ID_g(int [] arr , int p , int r){
        if(p > r){
            return p + 1 ;
        }
        int mid = p + ((r - p)>>1) ;
        int mid_vual = find_kk(arr , p , r , mid - p + 1) ;
        if(mid_vual == mid + 1){
             return find_ID_g(arr , mid + 1 , r);
        }else{
             return find_ID_g(arr , p , mid - 1) ;
        }
    }

    public static int find_kk(int [] arr , int p , int r ,int key){
        int q = qartition(arr , p , r) ;
        int kq = q - p + 1 ;
        if(kq == key){
            return arr[q] ;
        }else if(kq > key){
            return find_kk(arr , p , q - 1 , key);
        }else{
            return find_kk(arr , q + 1 , r , key - kq) ;
        }
    }

    public static int qartition(int [] arr , int p , int r){
        int left = p + 1 ;
        int right = r ;
        int target = arr[p] ;
        while(right >= left){
            if(arr[left] <= target){
                left++ ;
            }else{
                swap(arr , left , right);
                right-- ;
            }
        }
        swap(arr , p , right);
        return right ;
    }



    public static  void swap(int [] arr , int one , int two){
        int  n  = 0 ;
        n = arr[one] ;
        arr[one] = arr[two] ;
        arr[two] = n ;
    }

}
