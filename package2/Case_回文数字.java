package package2;

public class Case_回文数字 {
    public static void main(String[]arr){
        prin_t();
    }

    public static void prin_t(){
        for(int i = 1 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                System.out.println(i+""+j+""+j+""+i);
            }
        }
    }

}
