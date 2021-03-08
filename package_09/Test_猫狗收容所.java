package package_09;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 第一种为直接收养所有动物中最早进入收容所的，
 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。

 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式(最早)，
 若为1，则指定收养狗，若为-1则指定收养猫。
 请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 测试样例：

 [[1,1],[1,-1],[2,0],[2,-1]]

 返回：[1,-1]

 * @author zhengwei
 */

public class Test_猫狗收容所 {//运用两个队列
    public static void main(String[] args) {
        int [][] ope ={{1, 1}, {1, -1},{2, 0}, {2, -1}};
       System.out.println( Solution(ope));
    }

    public static int cnt = 0 ;
    private static ArrayList<Integer> Solution(int[][] ope) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Animal> cats = new LinkedList<>();
        Queue<Animal> dogs = new LinkedList<>();
        for (int [] opr:ope) {
            int op = opr[0];
            int value = opr[1];
            if(op == 1){
                if(value > 0){
                    dogs.add(new Animal(value , cnt++));
                }else {
                    cats.add(new Animal(value , cnt++));
                }
            }else if(op == 2){
                if(cats.size() == 0 && dogs.size() == 0){
                    continue;
                }else if(cats.size() == 0){
                    if(value == -1)continue;
                    res.add(dogs.poll().type);
                }else if(dogs.size() == 0){
                    if(value == 1)continue;
                    res.add(cats.poll().type);
                }else {
                    if(value == 0){
                        if(dogs.peek().time < cats.peek().time){
                            res.add(dogs.poll().type);
                        }else{
                            res.add(cats.poll().type);
                        }
                    }else if(value == -1){
                        res.add(cats.poll().type);
                    }else if(value == 1){
                        res.add(dogs.poll().type);
                    }
                }
            }
        }
        return res ;
    }

}

class Animal{
    int type ;
    int time ;
    public Animal(int type , int time){
        this.type = type ;
        this.time = time ;
    }
}
