package package2;

import java.util.Scanner ;
import static package2.Case_将数组堆化.minheap_fix;
import static package2.Case_将数组堆化.min_heap ;


public class Case_小顶堆与寻找最大的k个数 {
    static int k ;
    static int [] heap ;
    static int index = 0 ;
    public static void main(String [] arr){
        Scanner sc = new Scanner(System.in) ;
        k = sc.nextInt() ;
        heap = new int[k] ;
        int x = sc.nextInt() ;
        while(x != -1){
            deal(x) ;
            x = sc.nextInt() ;
        }
    }
    public static void deal(int x){
        if(index < k){
            heap[index] = x ;
            index++ ;
        }
        if(index == k){
            min_heap(heap , k);
            printsc(heap);
            index++ ;
        }else if(index > k){
            if(x > heap[0]){
                heap[0] = x ;
                printsc(heap);
                minheap_fix(heap , 0 , heap.length);

            }else{
                printsc(heap);
            }
        }

    }

    public static void printsc(int [] arr){
        System.out.print("[");
        for(int x : arr){
            System.out.print(x+",") ;
        }
        System.out.println("]");
    }
}
