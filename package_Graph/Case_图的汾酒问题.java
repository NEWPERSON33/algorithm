package package_Graph;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.*;

public class Case_图的汾酒问题 {
    public static void main(String[] args) {
//        int [] arr = {1,1,2} ;
//        String str = new String("") ;
//        for (int i = 0; i < arr.length; i++) {
//            str += arr[i] ;
//        }
//
//        System.out.println(str);
        Set<String >set = new HashSet<>() ;
        System.out.println(Solution(set , "6003" , "9000"));
    }

    private static void add(Node node , Set<String>set , Queue<Node> queue){
        if(!set.contains(node.val)){
            set.add(node.val) ;
            queue.add(node) ;
        }
    }

    private static int Solution(Set<String > set , String target ,String begin){
        //需要完成查重操作
        Node node = new Node(begin , 0) ;
        Queue<Node>queue = new LinkedList<>();
        queue.add(node) ;
        set.add(node.val);
        while (!queue.isEmpty()){//队列不为空执行操作
            Node temp = queue.poll();
            if(temp.val.equals(target))return temp.depth ;
            int [] temparr = temp.getState();
            for (int i = 0; i < temp.val.length(); i++) {
                if(temp.val.charAt(i) != '0'){//arr[i]为此时操作的对象
                    int temparri = temparr[i] ;
                    for (int j = 0; j < temparr.length; j++) {
                        if(j != i){

                            int temparrj = temparr[j] ;
                            if(temparr[j] + temparr[i] >= flag[j]){
                                temparr[j] = flag[j];
                                temparr[i] = temparrj + temparr[i] - flag[j] ;
                            }else {
                                temparr[j] = temparr[j] + temparr[i] ;
                                temparr[i] = 0 ;
                            }

                            String str = new String("") ;
                            for (int k = 0; k < temparr.length; k++) {
                                str+=temparr[k] ;
                            }
                            add(new Node(str , temp.depth+1) , set , queue) ;
                            temparr[j] = temparrj ;
                            temparr[i] = temparri ;
                        }
                    }
                }
            }
        }
        return -1 ;
    }
    static int [] flag = {9 , 7 , 4 ,2} ;

    static class Node {
        String val;//9,0,0,0
        int depth;//深度，或者说到达这个状态需要的操作次数

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, int depth) {
            this.val = val;
            this.depth = depth;
        }

        //把状态字符串转成四个杯子的存量，方便运算
        public int[] getState() {
            //String[] arr = val.split(",");
            int[] res = new int[val.length()];
            for (int i = 0; i < val.length(); i++) {
                res[i] = val.charAt(i)-48 ;
            }
            return res;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Node node = (Node) o;
//
//            return val.equals(node.val);
//        }

        @Override
        public int hashCode() {
            return val.hashCode();
        }
    }

}


