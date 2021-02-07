package package_dfs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Case_括号生成 {
    public static void main(String []args){
        System.out.println(Create_up(4));
        System.out.println(parenthesis1(4));

    }
//递归解法
    public static Set<String> Create(int n){
        Set<String>new_Set = new HashSet<>() ;
        if(n <= 1){
            new_Set.add("()") ;
            return new_Set ;
        }
        Set<String>old_Set = Create(n - 1) ;
        for(String o_s : old_Set){
            new_Set.add("()"+o_s) ;
            new_Set.add(o_s+"()") ;
            new_Set.add("("+o_s+")") ;
            for(int i = 0 ; i < o_s.length() ; i++){
                if(o_s.charAt(i) == '('){
                    new_Set.add(o_s.substring(0 , i+1) + "()"+o_s.substring(i+1));
                }
            }
        }
        return new_Set ;
    }
    //递推解法
    public static Set<String> Create_up(int n){
        if(n < 1){
            return new HashSet<>() ;
        }
        Set<String>old_set = new HashSet<>() ;
        old_set.add("()") ;
        if(n == 1){
            return old_set ;
        }
        for(int i = 2 ; i <= n ;i++){
            Set<String>new_set = new HashSet<>() ;
            for(String e : old_set){
                new_set.add(e + "()");
                new_set.add("()" + e);
                new_set.add("(" + e + ")");
                for(int j = 0 ; j < e.length() ; j++){
                    if(e.charAt(j) == '('){
                        new_set.add(e.substring(0,j+1)+"()"+e.substring(j+1));
                    }
                }
            }
            old_set = new_set ;
        }
        return old_set;
    }


//样例递推方法
    public static Set<String> parenthesis1(int n) {
        Set<String> res = new HashSet<>();//保存上次迭代的状态
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> res_new = new HashSet<>();

            for (String e : res) {
                res_new.add(e + "()");
                res_new.add("()" + e);
                res_new.add("(" + e + ")");
                  //更正：在内部也可以添加
                 for (int j = 0; j < e.length(); j++) {
                   char c = e.charAt(j);//每一个字符
                   if (c=='(')//只要这个字符是左括号，我们就可以在其后插入一对括号
                     res_new.add(e.substring(0,j+1)+"()"+e.substring(j+1));
                 }
            }
            res = res_new;
        }
        return res;
    }

}
