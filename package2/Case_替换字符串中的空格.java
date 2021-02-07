package package2;

public class Case_替换字符串中的空格 {
    public static void main(String []arr){
        System.out.println(replaceSpace("we are only one!00000000000000000000".toCharArray() , 16));
    }

    public static String replaceSpace(char [] string , int length){
        int count = length ;
        for(int i = 0 ; i < length ; i++){
            if(string[i] == ' ')
                count+=2 ;
        }
        int p1 = length - 1 ;
        int p2 = count - 1 ;
        while(p1 > -1){
            if(string[p1] == ' '){
                string[p2--] = '0' ;
                string[p2--] = '2' ;
                string[p2--] = '%' ;
            }else{
                string[p2--] = string[p1] ;
            }
            p1-- ;
        }
        return new String(string , 0 , count) ;
    }

}
