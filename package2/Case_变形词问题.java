package package2;

public class Case_变形词问题 {
    public static void main(String []arr){
        System.out.println(cheak("124" , "132"));
    }

    static int[]help = new int[256];

    public static boolean cheak(String s1 , String s2){
        if(s1.length() != s2.length()){
            return false ;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            help[(int)s1.charAt(i)]++ ;
        }
        for(int i = 0 ; i < s2.length() ; i++){
            help[(int)s2.charAt(i)]-- ;
            if(help[(int)s2.charAt(i)] < 0){
                return false ;
            }
        }
        return true ;
    }

}
