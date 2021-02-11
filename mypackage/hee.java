package mypackage;

import java.util.Scanner;

public class hee {
    public static void main(String[ ] args){
        System.out.println("hello world!");
        int arr[] = {5 , 2 ,3 , 4} ;
        //InsertSort(arr, 3);
        //Change(arr , 3);
        //ShellSort(arr);
        //for(int x:arr)
        //    System.out.print(x+",");
       // System.out.println("");

       //int Turn_min_n = Turn_min(arr) ;
        //System.out.println(Turn_min_n);

        //int n = binarySearch(arr , 0 , 3 , 5) ;
        //System.out.println(n);

        //printHanoitower(5 , "A" , "B" , "C");
        //int n = Fibonacci(5) ;
        //System.out.println(n) ;
        Scanner sc = new Scanner(System.in) ;
        while(true){
            int n = sc.nextInt();
            int res = Climb(n) ;
            System.out.println(res) ;
        }
    }

    static void InsertSort(int []arr , int k){//插入排序的递归形式
        if(k == 0)
            return;
        InsertSort(arr , k - 1);
        int index = k - 1 ;
        int n = arr[k] ;
        while(index > -1 && n < arr[index]){
            arr[index + 1] = arr[index] ;
            index-- ;
        }
        arr[index+1] = n ;
    }

    public static void printHanoitower(int N , String from , String to , String help){
        if(N == 1){
            System.out.println("move " + N + " from" +from+ " to " + to) ;
            return;
        }
        printHanoitower(N - 1 , from , help , to);
        System.out.println("move "+N+" from "+from+" to "+to);
        printHanoitower(N -1 , help , to , from);
    }

    public static int binarySearch(int[] arr , int low , int high , int key){
        int Mid = (low + high)>>1 ;
        int MidVal = arr[Mid] ;
        if(low > high){
            return -1 ;
        }
        else if(key > MidVal){
            return binarySearch(arr , Mid + 1 , high , key);
        }
        else if(key < MidVal){
            return binarySearch(arr , low , Mid - 1 , key) ;
        }
        else if(key == MidVal){
            return Mid ;
        }
        return -1;
    }

    public static void Change(int[] arr , int end){
        for(int i = 0 ; i < (end + 1)>>1 ; i++){
            int num ;
            num = arr[i] ;
            arr[i] = arr[end - i] ;
            arr[end - i] = num ;
        }
    }

    public static void ShellSort(int[] arr){//希尔排序
        for(int interval = arr.length / 2 ; interval > 0 ; interval /= 2){
            for(int i = interval ; i < arr.length ; i++){
                int n = i - interval ;
                int num = arr[i] ;
                while(n > -1 && num < arr[n]){
                    arr[n + interval] = arr[n] ;
                    n -= interval ;
                }
                arr[n + interval] = num ;
            }
        }
    }

    public static int Fibonacci(int n){

        int first = 1 , second = 1 , temp ;

        for(int i = 0 ; i < n - 2 ; i++){
            temp = second ;
            second = first + second ;
            first = temp ;
        }
        return second ;
    }

    public static int Climb(int n ){//小白上楼梯
        if(n == 1)
            return 1 ;
        else if(n == 2)
            return 2 ;
        //else if(n == 3)
            //return 4 ;
        else if(n == 0)
            return 1 ;
        return Climb(n - 1 ) + Climb(n - 2) + Climb(n - 3) ;
    }

    public static int Turn_min(int[] arr){//增量旋转数组输出最小值 ps: {3 , 4 , 5 , 1 , 2 }
        int end = arr.length - 1 ;
        int begin = 0 ;
        if(arr[begin] < arr[end]){
            return arr[begin] ;
        }
        while(begin < end - 1){
            int mid = begin + ((end - begin)>>1) ;
            if(arr[mid] == arr[begin] && arr[mid] == arr[end]){
                //{1 , 1 , 0 , 1 }
            }
            else if(arr[mid] >= arr[begin]){
                begin = mid ;
            }
            else
                end = mid ;
        }
        return arr[end] ;
    }

}

