package package2;

import static package2.Find_K.swap ;

public class Case_将数组堆化 {
    public static void main(String [] arr){
        int [] Case_J = { 9 , 1 , 3 , 2 , 5} ;
        heapsort_minheap(Case_J);
        for(int x : Case_J){
            System.out.print(x + " ") ;
        }

    }

    public static void min_heap(int [] arr ,int length){//小顶堆
        for(int i = length / 2 - 1 ; i >= 0 ; i--){
            minheap_fix(arr , i , length) ;
        }
    }

    public static void minheap_fix(int [] arr , int i , int length){//小顶堆下沉
        int left = 2 * i + 1 ;
        int right = 2 * i + 2 ;
        int min = left ;
         if(left > length - 1){
             return ;
         }
        if(right > length - 1){
            min = left ;
        }else{
            if(arr[right] < arr[left]){
                min = right ;
            }
        }
        if(arr[i] < arr[min]){
            return ;
        }else{
            swap(arr , min , i);
            minheap_fix(arr , min , length);
        }
    }


    public static void max_heap(int [] arr , int length){
        for(int i = length / 2 - 1 ; i >= 0 ; i--){
            maxheap_fix(arr , i , length);
        }
    }

    public static void maxheap_fix(int [] arr , int i , int length){
        int left = i * 2 + 1 ;
        int right = i * 2 + 2 ;
        int max = left ;

        if(left > length - 1){
            return ;
        }

        if(right > length - 1){
            max = left ;
        }else{
            if(arr[right] > arr[left]){
                max = right ;
            }
        }

        if(arr[i] > arr[max]){
            return;
        }else {
            swap(arr , max , i);
            maxheap_fix(arr , max , length);
        }
    }

    public static void heapsort_minheap(int [] arr){
        min_heap(arr , arr.length);
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            swap(arr , 0 , i );
            minheap_fix(arr , 0 , i );
        }
    }

    public static void heapsort_maxheap(int [] arr){
        max_heap(arr , arr.length);
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            swap(arr , 0 , i) ;
            maxheap_fix(arr , 0 , i );
        }
    }

}
