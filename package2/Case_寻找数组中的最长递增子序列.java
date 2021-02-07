package package2;

public class Case_寻找数组中的最长递增子序列 {
    public static void main(String[] arr){
        int arrs_X[] = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        Find(arrs_X);

    }

    public static void Find(int[] arr){
        int front = 0 ;
        int rear = 0 ;
        int count = 1 ;
        int res = 0 ;
        int F = 0 ;
        int R = 0 ;
        for( ; rear < arr.length - 1 ;){
            if(arr[rear] < arr[rear + 1]){
                rear++ ;
                count++ ;
            }
            else if(arr[rear] >= arr[rear + 1]){
                if(count > res){
                    res = count ;
                    F = front ;
                    R = rear ;
                    //front = rear = rear + 1 ;
                }
                count = 1 ;
                front = rear = rear + 1 ;
            }

            //else{
                //rear++ ;
                //count++ ;
            //}

        }

        while(F <= R){
            System.out.print(arr[F++]+" ") ;
        }
        System.out.println("") ;

    }

}
