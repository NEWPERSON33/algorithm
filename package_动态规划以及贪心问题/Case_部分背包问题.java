package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_部分背包问题 {
    static int N = 10 ;

    public static void main(String[] args) {
        int [] w = {1,2,3,4,5};
        int [] v = {3,4,3,1,4};
        int Max = N ;
        Solution(w , v , Max);
    }

    private static void Solution(int[] w, int[] v, int max) {
        Thing [] obj = new Thing[w.length];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = new Thing(w[i] , v[i]);
        }
        int C = max ;
        double maxValue = 0 ;
        Arrays.sort(obj);
        for (int i = obj.length-1; i >= 0 ; i--) {
            if(C >= obj[i].w){
                maxValue+=obj[i].v;
                C-=obj[i].w;
            }else{
                maxValue+=C*obj[i].GetPrice();
                C = 0;
                break;
            }
        }
        System.out.println(maxValue);
    }
}

class Thing implements Comparable<Thing>{
    int w ;
    int v ;
    public double GetPrice(){
        return v/(double)w ;
    }
    public Thing(int w , int v){
        this.w = w ;
        this.v = v ;
    }


    @Override
    public int compareTo(Thing o) {
        if (this.GetPrice() - o.GetPrice() < 0)
            return -1;
        else if(this.GetPrice() - o.GetPrice() > 0)
            return 1 ;
        else
            return 0;
    }
}
