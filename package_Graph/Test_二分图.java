package package_Graph;

public class Test_二分图 {

    public static void main(String[] args) {
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);

        n1.add(n2);
        n1.add(n4);

        n2.add(n1);
        n2.add(n3);


        n3.add(n2);
        n3.add(n4);

        n4.add(n1);
        n4.add(n3);

        n2.add(n4);
        n4.add(n2);

        //System.out.println(Solution(n1 , 1));
        System.out.println(dfs2(n1 , 1));
    }

    private static void dfs(MyNode node , int color){
        if(node.color == -color){
            flag = false ;
            return ;
        }
        if(node.color == 0){
            node.color = color ;
            for (int i = 0; i < node.size(); i++) {
                dfs((MyNode) node.getNeighbor(i) , -color) ;
            }
        }


        return;
    }

    private static boolean dfs2(MyNode node , int color){
        if(node.color == -color){
            return false ;
        }
        if(node.color == 0){
            node.color = color ;
            for (int i = 0; i < node.size(); i++) {
                boolean choice = dfs2((MyNode) node.getNeighbor(i) , -color) ;
                if(!choice){
                    return false ;
                }
            }
        }
        return true ;
    }

    public static boolean flag = true ;
    private static boolean Solution(MyNode node , int color ){
        flag = true ;
        dfs(node , color);
        return flag ;
    }

}

class MyNode extends GraphNode_AL {
    int color ;

    public MyNode(int val){
        super(val);
    }
    public MyNode(int val , int color) {
        super(val);
        this.color = color ;
    }
}
