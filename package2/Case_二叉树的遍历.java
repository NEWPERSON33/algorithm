package package2;

public class Case_二叉树的遍历 {
    public static void main(String [] arr ){
        int [] arr_DD = { 0,1,2,3,4,5,6,7};
        head_tree(arr_DD , 0);
        System.out.println("");
        mid_tree(arr_DD , 0);
        System.out.println("");
        rear_tree(arr_DD , 0);
    }

    public static void head_tree(int [] arr , int index){
        if(index >= arr.length){
            return ;
        }
        System.out.print(arr[index] + "   ");
        head_tree(arr , index * 2 + 1) ;
        //System.out.print("@");
        head_tree(arr , index * 2 + 2) ;
        //System.out.print("+");
    }

    public static void mid_tree(int [] arr , int index){
        if(index >= arr.length){
            return ;
        }
        mid_tree(arr , index * 2 + 1);
        System.out.print(arr[index]+"   ");
        mid_tree(arr , index * 2 + 2);
    }

    public static void rear_tree(int [] arr , int index){
        if(index >= arr.length){
            return;
        }
        rear_tree(arr , index * 2 + 1);
        rear_tree(arr , index * 2 + 2);
        System.out.print(arr[index] + "   ");
    }

}
