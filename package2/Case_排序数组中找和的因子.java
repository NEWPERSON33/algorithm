package package2;

public class Case_排序数组中找和的因子 {
    public static void main(String [] arr){
        int a_s[] = {-8 , -4 , -3 , 0 , 2 , 4 , 5 , 8 , 9 , 10} ;
        long startTime = System.currentTimeMillis();
        find_triads(a_s , 10);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    public static void find_triads(int [] arr , int target){
        for(int i = 0 ; i < arr.length - 2 ; i++){
            int temp_target = target - arr[i] ;
            int left = i + 1 ;
            int right = arr.length - 1 ;
            while(left < right){
                if(arr[left] + arr[right] == temp_target){
                    System.out.println("(" + arr[i] + "," + arr[left] + "," + arr[right] + ")") ;
                    left++ ;
                    right-- ;
                }else if(arr[left] + arr[right] < temp_target){
                    left++ ;
                }else{
                    right-- ;
                }
            }
        }
    }

}


