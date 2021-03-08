package package_09;

import java.util.ArrayList;

public class Test_SetofStacks {
    public static void main(String[] args) {
        int [][]ope = {
                {1,2},
                {1,3},
                {1,4},
                {2,2},
                {2,2}
        };
        int size = 2 ;
        System.out.println(Solution(ope , size));

    }

    public static ArrayList<ArrayList<Integer>> Solution(int [][] arr , int size){
        ArrayList<ArrayList<Integer>>re = new ArrayList<>();
        ArrayList<Integer>cur = new ArrayList<>(size);
        re.add(cur);
        for (int [] temp:arr) {
            int op = temp[0];
            int value = temp[1];
            if(op == 1){
                if(cur.size() == size){
                    cur = new ArrayList<Integer>();
                    re.add(cur);
                }
                cur.add(value);
            }else {
                if(cur.size() == 0){
                    re.remove(cur);
                    cur = re.get(re.size() - 1);
                }
                cur.remove(cur.size() - 1);
            }
        }
        return re;
    }

}
