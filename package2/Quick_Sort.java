package package2;

public class Quick_Sort {
    public static void main(String[] arr){
        int arrs_X_Q[] = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        //Insort(arrs_X_Q , 0 ,14);
        quick_sort(arrs_X_Q , 0 , 14);
        for(int x : arrs_X_Q)
            System.out.print(x+"  ") ;
        System.out.println("") ;
    }

    public static void quick_sort(int [] arr , int p , int r) {
        if (p < r) {
            int q = partition_A(arr, p, r);
            //int [] arr2 = partition_3(arr , p , r) ;
            quick_sort(arr, p , q - 1);
            quick_sort(arr, q + 1 , r);
        }
    }

    public static int partition(int [] arr , int p , int r){//快排之单向扫描分区法
        int b_pos = p + 1 ;
        int end = r ;
        int target = arr[p] ;
        while(b_pos <= end){
            if(arr[b_pos] <= target)
                b_pos++ ;
            else{
                swap(arr , b_pos , end);
                end-- ;
            }

        }

        swap(arr , p , end);

        return end ;
    }

    public static int partition_2(int [] arr , int p , int r ){//快排之双向扫描分区法(三点中值法优化)

        int midIndex = p + ((r - p))>>1 ;
        int midVual = -1 ;
        if((arr[p] >= arr[midIndex] && arr[midIndex] >= arr[r]) || (arr[r] >= arr[midIndex] && arr[midIndex] >= arr[p])){
            midVual = midIndex ;
        }else if((arr[midIndex] >= arr[p] && arr[p] >= arr[r]) || (arr[r] >= arr[p] && arr[p] >= arr[midIndex])){
            midVual = p ;
        }else{
            midVual = r ;
        }

        swap(arr , p , midVual);

        int left = p + 1 ;
        int right = r ;
        while(left <= right){
            while(left<= right && arr[left] <= arr[p])left++ ;
            while(left<=right && arr[right] > arr[p])right-- ;
            if(right > left)
                swap(arr , left , right);
        }
        swap(arr , p , right);

        return right ;
    }


    public static int partition_A(int [] arr , int p , int r){//快排（绝对中值法）
        int length = (r - p + 1) % 5 == 0 ? (r - p + 1) / 5 : ((r - p + 1) / 5 ) + 1 ;
        int [] arr_x = new int[length] ;
        int index = 0 ;
        int index_vual = -1 ;
        for(int i = 0 ; i < length ; i++ ){//!!!!!!
            if( i != length - 1){
                Insort(arr , p + 5 * i , p + 5 * i * 2);
                arr_x[index++] = arr[ (p + 5 * i) + 2 ];
            }else{
                Insort(arr , p + 5 * i , r);
                arr_x[index] =arr[ (p + 5 * i) + (r - (p + 5 * i)) >> 1 ];
            }
        }
        Insort(arr_x , 0 , arr_x.length - 1);
        index_vual = arr_x[length>>1] ;
        for(int i = p ; i <= r ; i++){
            if(arr[i] == index_vual){
                swap(arr , p , i);
                break ;
            }
        }

        int left = p + 1 ;
        int right = r ;
        while(left <= right){
            while(left<= right && arr[left] <= arr[p])left++ ;
            while(left<=right && arr[right] > arr[p])right-- ;
            if(right > left)
                swap(arr , left , right);
        }
        swap(arr , p , right);

        return right ;

    }

    public  static int [] partition_3(int [] arr , int p , int r){////快排之三分区扫描法
        int s = p + 1 ;
        int e = p + 1 ;
        int bigger = r ;
        int times = 0 ;
        int [] as ={ -1 , -1} ;
        while(s <= bigger){
            if(arr[p] > arr[s]){
                if(times == 1){
                    swap(arr , s , e);
                    e++ ;
                }
                s++ ;
            }
            else if(arr[p] == arr[s]){
                if(times == 0){
                    e = s ;
                    s++ ;
                    times = 1 ;
                }else{
                    s++ ;
                }
            }
            else{
                swap(arr , s ,bigger);
                bigger-- ;
            }
        }
        if(e != p + 1){
            swap(arr , e - 1 , p);
            as[0] = e ;
            as[1] = bigger ;
            return as ;
        }else{
            swap(arr ,  bigger , p);
            as[0] = bigger ;
            as[1] = bigger ;
            return as ;
        }
    }

    public static  void swap(int [] arr , int one , int two){
        int  n  = 0 ;
        n = arr[one] ;
        arr[one] = arr[two] ;
        arr[two] = n ;
    }

    public static void Insort(int [] arr , int p , int r) {
        for (int i = p + 1; i <= r; i++) {
            int index_vual =arr[i];
            int in = i - 1;

            while (in > -1 && index_vual < arr[in]) {
                arr[in + 1] = arr[in];
                in--;
            }
            arr[in + 1] = index_vual;
        }
    }
}