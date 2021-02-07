package package2;

public class Find_K {
    public static void main(String [] arr){
        int arrs_F[] = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        System.out.println(find_kk(arrs_F , 0 , arrs_F.length - 1 , 10));
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
