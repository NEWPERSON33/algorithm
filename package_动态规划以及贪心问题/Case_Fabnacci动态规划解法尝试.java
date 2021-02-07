package package_动态规划以及贪心问题;

public class Case_Fabnacci动态规划解法尝试 {
    static int N = 46;
    public static void main(String[] args) {
        long [] re = new long[N+1];
        for (int i = 0; i < re.length; i++) {
            re[i] = -1 ;
        }
        System.out.println(FabnacciPlus(N,re));
        System.out.println(Fabnacci(N));
    }
    private static long Fabnacci(int n){//正常递归
        if(n == 0)return 0;
        if(n == 1)return 1;
        return Fabnacci(n-1)+Fabnacci(n-2);
    }
//4595025300ns


    private static long FabnacciPlus(int n , long [] re){//动态规划
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(re[n] >= 0)return re[n];
        long num= Fabnacci(n-1)+Fabnacci(n-2);
        re[n] = num ;
        return num;
    }
}
//    long startTime=System.nanoTime();   //获取开始时间
//
//    doSomeThing(); //测试的代码段
//
//    long endTime=System.nanoTime(); //获取结束时间
//
//System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
//
