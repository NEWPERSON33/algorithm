package package2;

public class Case_去掉字符串中连续出现k次的0 {
    public static void main(String []arr){
        System.out.println(remove("AB" , 3));
    }

    public static String remove(String src , int k){
        int count = 0 ;
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0 ; i < src.length() ; i++){
            char c = src.charAt(i) ;
            if(c == '0'){
                count++ ;
                continue;
            }else{
                for(int j = 0 ; j < count % k ; j++){
                    sb.append('0');
                }
            }
//            if(c != '0'){
//                sb.append(c) ;
//                count = 0 ;
//            }
            sb.append(c) ;
            count = 0 ;
        }
        for(int j = 0 ; j < count % k ; j++) {
            sb.append('0');
        }
        return sb.toString() ;
    }

}
