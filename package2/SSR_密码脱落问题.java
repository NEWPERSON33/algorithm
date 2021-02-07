package package2;

import java.util.Scanner;

public class SSR_密码脱落问题 {
        private static int count;
//        private static int count;

         public static void main(String[] args) {
               Scanner sc=new Scanner(System.in);
               String temp=sc.next();
               count=temp.length();
               int num=0;
               check(0,temp.length()-1,temp,num);
               System.out.println("最终结果"+count);

             }

             private static void check(int left, int right, String temp, int num) {
                 // TODO 自动生成的方法存根
                 if(left>=right)
                     {
                         if(num<count)
                             {
                                 count=num;
                             }
                     }else {
                         //判断相等 继续下两个数
                         if(temp.charAt(left)==temp.charAt(right))
                             {
                              check(left+1,right-1,temp,num);
                             }else {
                                 //one  复制第二位，生成123(2)1；这样就可以继续读1231的第三位和倒数二位   即判断3 因为添加了数字2所以num+1
                                check(left+1,right,temp,num+1);
                                //two  复制倒数第二位，生成1(3)231；这样就可以继续读1231的第二位和倒数三位 即判断2  因为添加了数字3所以num+1
                                check(left,right-1,temp,num+1);
                            }
                     }

             }
}
