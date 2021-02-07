package package2;

public class Case_字符串匹配之RabinKarp {

    final static int seed = 31 ;

    public static void main(String []arr){
        System.out.println(Rb(new String("shuangzeng") , new String("zg")));
    }

    public static int Rb(String src , String p){
        long hash_p = hash(p);
        for(int i = 0 ; i <= src.length() - p.length() ; i++){
            long hash_i = hash(src.substring(i , i+p.length())) ;
            if(hash_i == hash_p){
                return i ;
            }
        }
        return -1 ;
    }



    public static long hash(String s){
        int hash = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            hash = hash * seed + s.charAt(i) ;
        }
        return hash%Long.MAX_VALUE ;
    }

}
