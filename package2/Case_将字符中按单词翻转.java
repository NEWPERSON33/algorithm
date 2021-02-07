package package2;

public class Case_将字符中按单词翻转 {
    public static void main(String []arr){
        System.out.println(sum_word(" world"));
        System.out.println(reverse("how are you"));
    }

    public static int sum_word(String src){
        int count = 0 ;
        int time = 0 ;
        for(int i = 0 ; i < src.length() ; i++){
            if(src.charAt(i) != ' ' ){
                if(time == 0){
                    time = 1 ;
                    count++;
                }

            }else{
                if(time == 1){
                    //count++ ;
                    time = 0 ;
                }
            }
        }
        return count ;
        //char [][]ch = new int[]
    }

    public static String reverseString(String src){
        StringBuilder sb =new StringBuilder() ;
        for(int i = src.length() - 1 ; i > -1 ; i--){
            sb.append(src.charAt(i)) ;
        }
        return sb.toString() ;
    }

    public static String reverse(String src){
        String s1 = reverseString(src) ;
        StringBuilder sb = new StringBuilder();
        String [] words = s1.split("\\s") ;
        for(int i = 0 ; i < words.length ; i++){
            sb.append(reverseString(words[i]) + " ") ;
        }
        return sb.delete(sb.length() - 1 , sb.length()).toString();
    }

}
