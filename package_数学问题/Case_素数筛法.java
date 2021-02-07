package package_数学问题;

/**
 * 素数定理：
 * n个数内素数的个数大约为：
 * n/ln(n)
 */
public class Case_素数筛法 {

    final static int N =100000 ;
    public static void main(String []args){
        Find_N_prime(N) ;
        m1(N);
    }

    public static long Find_N_prime(int N) {
        int n = 2;
        while (n / Math.log(n) < N) {
            n++;
        }

        int[] num = new int[n];
        num[0] = num[1] = -1;


        for (int i = 2; i < n ; i++) {
            if (num[i] == -1) {
                //i++;
                continue;
            }
            for (int k = 2; k * i < n; k++) {
                num[i * k] = -1;
            }
        }


//        int x = 2;
//        while (x < n) {
//            //标记过了，继续下一个
//            if (num[x] != 0) {
//                x++;
//                continue;
//            }
//
//            int k = 2;
//            //对每个x，我们从2倍开始，对x的k倍，全部标记为-1
//            while (x * k < n) {
//                num[x * k] = -1;
//                k++;
//            }
//            x++;
//        }

        int sum = 0;
        int res = -1;
        for(int i = 2 ; i < num.length ; i++){
            if(num[i] == 0){
                sum++ ;
            }
            if(sum == N){
                res = i ;
                System.out.println(i);
                break;
            }
        }
        return res ;

    }



    private static void m1(int N) {
        //N是第N个素数
        //已知在整数X内大概有X/log(X)个素数
        //现在我们要逆推：要想求第N个素数，我们的整数范围是什么
        //length就是整数范围
        int n = 2;
        while (n / Math.log(n) < N) {
            n++;
        }
        //开辟一个数组，下标是自然数，值是标记
        //基本思路是筛选法，把非素数标记出来
        int[] arr = new int[n];
        int x = 2;
        while (x < n) {
            //标记过了，继续下一个
            if (arr[x] != 0) {
                x++;
                continue;
            }

            int k = 2;
            //对每个x，我们从2倍开始，对x的k倍，全部标记为-1
            while (x * k < n) {
                arr[x * k] = -1;
                k++;
            }
            x++;
        }
        // System.out.println(arr);
        //筛完之后，这个很长的数组里面非素数下标对应的值都是-1
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            //是素数，计数+1
            if (arr[i] == 0) {
                // System.out.println(i);
                sum++;
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
    }


}
