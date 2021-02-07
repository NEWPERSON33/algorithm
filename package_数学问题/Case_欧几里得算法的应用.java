package package_数学问题;

public class Case_欧几里得算法的应用 {
    public static void main(String []args){
        point p1 = new point(1 , 2) ;
        point p2 = new point(5 , 6) ;
        System.out.println(find(p1.x - p2.x , p1.y - p2.y) - 1);
    }

    //计算两整数坐标之间的整数隔点
    public static int find(int m , int n){
        return n == 0 ? m : (find(n , m%n)) ;
    }

}

class point{
    public int x ;
    public int y ;

    public point(int _x , int _y){
        x = _x ;
        y = _y ;
    }
}
