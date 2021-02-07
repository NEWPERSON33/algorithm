package package2;

public class Case_压缩字符串 {
    public static void main(String []arr){
        System.out.println(ZIP_String("abc"));
    }

    public static String ZIP_String(String src){
        StringBuilder sb = new StringBuilder() ;
        int count = 0 ;
        char last = '0' ;
        for(int i = 0 ; i < src.length() ; i++){
            char char_AT = src.charAt(i) ;
            if(sb.length() == 0){
                sb.append(char_AT) ;
                count = 1 ;
            }else{
                if(last == char_AT){
                    count++ ;
                }else{
                    sb.append(count).append(char_AT) ;
                    count = 1 ;
                }
            }
            last = char_AT ;
        }
        if(count >= 1){
            sb.append(count) ;
        }
        if(sb.length() >= src.length())
            return src ;
        return sb.toString() ;
    }

}
