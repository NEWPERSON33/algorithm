package package2;

public class Case_高效地求a的n次方 {
    public static  void main(String[] arr){
        System.out.println(pow_0(2 , 17));
        System.out.println(pow_1(2 , 17));
    }

    public static long pow_0(int a , int n){//时间换空间

        int num = 1 ;
        int value = 1 ;
        int value_a = a ;
        if(n == 0 )
            return 1 ;
        while (num<<1 <= n){
            value_a = value_a * value_a ;
            num *= 2 ;
        }
        for(int i = num ; i < n ; i++){
            value *= a ;
        }
        return value * value_a ;
    }

    public static long pow_1(int a , int n){//空间换时间
        int num = 1;
        int value = 1 ;
        int value_a = a ;
        if(n == 0)
            return 1 ;
        while(num<<1 <= n ){
            value_a = value_a * value_a ;
            num <<= 1 ;
        }
        return value_a * pow_1(a , n - num) ;
    }

}
