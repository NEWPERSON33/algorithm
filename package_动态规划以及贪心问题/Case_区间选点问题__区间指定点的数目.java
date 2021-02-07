package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_区间选点问题__区间指定点的数目 {
    static int N = 5;
    public static void main(String[] args) {
        int [] from = {3,8,6,1,10} ;//待定
        int [] to = {7,10,8,3,11} ;//待定
        int [] cnt = {3,3,1,1,1} ;//待定
        span [] sp = new span[N] ;
        for (int i = 0; i < N; i++) {
            sp[i] = new span(from[i] , to[i] , cnt[i]);
        }

        Arrays.sort(sp);


        int [] Axis = new int[sp[N-1].value+1];

        for (int i = 0; i < N; i++) {
            int c = sp[i].c ;
            c-= sum(Axis , sp[i].key , sp[i].value);
            int t = sp[i].value ;
            while(c>0 && t >= sp[i].key){
                if(Axis[t] == 0){
                    Axis[t] = 1;
                    c--;
                    t--;
                }else{
                    t--;
                }
            }
        }
        int c_nt = 0 ;
        for (int x:Axis) {
            if(x == 1){
                c_nt++;
            }
        }
        System.out.println(c_nt);
        //System.out.println(((~29)+1)&29);
        Solution_2(sp[N-1].value);

    }

    private static int sum(int[] axis, int key, int value) {
        int cnt = 0 ;
        for (int i = key; i <= value ; i++) {
            if(axis[i] == 1){
                cnt++ ;
            }
        }
        return cnt ;
    }

    /**
     * 区间选点问题：树状数组区间求和
     * lowbit操作：两个数组建立树状映射，可高效解决区间求和复杂度高的问题(i-=(i&-i))/(i+=(i&-i))
     * @param Max_value
     */

    public static void Solution_2(int Max_value){
        int [] t = new int[Max_value+1];
        int [] a = new int[Max_value+1];

        int [] from = {3,8,6,1,10} ;//待定
        int [] to = {7,10,8,3,11} ;//待定
        int [] cnt = {3,3,1,1,1} ;//待定
        span [] sp = new span[N] ;
        for (int i = 0; i < N; i++) {
            sp[i] = new span(from[i] , to[i] , cnt[i]);
        }

        Arrays.sort(sp);

        for (int i = 0; i < N; i++) {
            int C = sp[i].c;
            C-=sum_update(t , sp[i].key , sp[i].value);
            int T = sp[i].value;
            while(C>0 && T >=sp[i].key){
                if(a[T] == 0){
                    setValue(t , T , 1);
                    a[T] = 1 ;
                    C--;
                    T--;
                }else{
                    T--;
                }
            }
        }
        System.out.println(sum_update(t , 1 , Max_value));
    }

    private static void setValue( int[] t, int index , int value) {
        for (int i = index; i < t.length; i+= (i & -i)) {
            t[i]+=value;
        }
    }

    private static int sum_update(int[] t, int begin, int end) {
        int ans_be = 0 ;
        int ans_end = 0;
        for (int i = (begin-1); i >0 ; i-= (i&-i)) {
            ans_be+=t[i];
        }
        for (int i = end; i > 0; i-= (i & -i)) {
            ans_end+=t[i];
        }
        return ans_end - ans_be ;
    }

}

class span implements Comparable<span>{
    int key ;
    int value;
    int c ;

    public span(int x, int y , int z) {
        key = x ;
        value = y ;
        c = z ;
    }

    public int compareTo(span o){
        int x = this.value - o.value ;
        if(x == 0)
            return this.key - o.key ;
        return x ;
    }
}
