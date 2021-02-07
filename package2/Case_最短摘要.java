package package2 ;


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays ;


/*
*注释部分代码存在逻辑上的无法修改的巨大bug
*且暂无能力修改
*来日方长
 */
/*
这是一个大问题 ， 这是一个大问题WARNING!!!  WARNING!!!
 */



public class Case_最短摘要{
//    public static void main(String []arr){
//        solve(new String[]{"1","2","0","3","1","3"} , new String[]{"0","1","3"});
//        solve(new String[]{"a","b","c","d","e","f","d","c"} , new String[]{"e" , "c"}) ;
//        solve(new String[]{"a", "b", "c", "seed", "c", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{ "c", "e", "f"});
//        solve(new String[]{"a", "b", "a", "a", "b", "c", "d", "h", "e", "f", "f"}, new String[]{"b", "c", "d"});
//    }
//
//    public static void solve(String []src , String []keys){
//        int begin = -1 ;
//        int end = -1 ;
//        int p2 = -1 ;
//        int minlen = Integer.MAX_VALUE ;
//        int[]key_found = new int[keys.length] ;
//        int j = -1 ;
//
//        for(int i = 0 ; i < src.length ; i++){
//            //Arrays.fill(key_found , 0) ;
//            String word = src[i] ;
//            int index = indexof(keys , word) ;
//            if(-1 == index){
//                continue;
//            }else {
//                key_found[index] = 1;
//            }
//                if(p2 != -1){
//                     j = p2 ;
//                }else{
//                    j = i + 1 ;
//                }
//                for(;j < src.length ; j++){
//                    word = src[j] ;
//                    index = indexof(keys , word) ;
//                    if(-1 == index || key_found[index] == 1){
//                        continue;
//                    }else{
//                        key_found[index] = 1 ;
//                        if(sum(key_found) == keys.length){
//                            p2 = j ;
//                            if(j - i + 1 < minlen){
//                                begin = i ;
//                                end = j ;
//                                minlen = j - i + 1 ;
//                            }
//                        }
//                        break ;
//                    }
//                    //break;
//                }
//
//        }
//        print(src , begin ,end) ;
//    }
//
//    public static int indexof(String []key , String word){
//        for(int i = 0 ; i < key.length ; i++){
//            if(word.equals(key[i])){
//                return i ;
//            }
//        }
//        return -1 ;
//    }
//
//    public static int sum(int[]arr){
//        int sum = 0;
//        for(int x : arr){
//            sum+=x ;
//        }
//        return sum ;
//    }
//    public static void print(String []src , int begin , int end){
//        for(int i = begin ; i <=end ; i++){
//            System.out.print(src[i]+" ");
//        }
//        System.out.println(" ");
//    }

    public static void main(String []arr){
        Find_summary(new String[]{"1","2","0","3","1","3"} , new String[]{"0","1","3"});
        Find_summary(new String[]{"a","b","c","d","e","f","d","c"} , new String[]{"e" , "c"}); ;
        Find_summary(new String[]{"a", "b", "c", "seed", "c", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{ "c", "e", "f"});
        Find_summary(new String[]{"a", "b", "a", "a", "b", "c", "d", "h", "e", "f", "f"}, new String[]{"b", "c", "d"});
        Find_summary(new String[]{"a", "b", "c", "seed", "c", "e", "f", "c", "c", "seed", "e", "f", "seed", "c"}, new String[]{"c", "c", "e", "f"});
        Find_summary(new String[]{"a", "b", "a", "a", "b", "c", "d", "h", "e", "f", "f"}, new String[]{"b", "c", "d"});
    }


    public static void Find_summary(String[] words , String[] keywords) {
        Arrays.sort(keywords);
        int begin = -1;
        int end = -1;
        int j = -1;
//      int p2 = -1;
        int minlen = Integer.MAX_VALUE;

        for (int i = 0; i < words.length ; i++) {
            String word = words[i] ;
            int index = Arrays.binarySearch(keywords , word) ;
            if( -1 == index){
                continue;
            }else{
                if(j >= i && j < words.length && Cheak(keywords , words , i , j)){
                    if(j - i + 1 < minlen){
                        minlen = j - i + 1 ;
                        begin = i ;
                        end = j ;

                    }
                    continue;
                }
            }
            if(-1 == j) {
                j = i + 1;
            }
                while(j < words.length){
                    String word2 = words[j];
                    int index1 = Arrays.binarySearch(keywords , word2) ;
                    if(index1 == -1){
                        j++ ;
                        continue;
                    }else{
                        if(Cheak(keywords , words , i , j)) {
                            if (j - i + 1 < minlen) {
                                minlen = j - i + 1 ;
                                begin = i;
                                end = j;
                            }
                            break;
                        }
                    }
                    j++;
                }
            }
            print(words , begin , end);
    }

    public static boolean Cheak(String[] keywords , String[] words , int begin , int end){
        Map<String , Integer>map = new HashMap<>();
        for(int i = 0 ; i < keywords.length ; i++){
            String word = keywords[i] ;
            if(map.get(word) == null){
                map.put(word , 1);
            }else{
                map.put(word , map.get(word)+1);
            }
        }
        Map<String , Integer>map2 = new HashMap<>();
        for(int i = begin ; i <=end ; i++){
            String word = words[i];
            if(map2.get(word) == null){
                map2.put(word , 1);
            }else{
                map2.put(word , map2.get(word)+1);
            }
        }
//        for(int i = 0 ; i < keywords.length ; i++){
//            String word = keywords[i] ;
//            if(map2.get(word)==null || map2.get(word) < map.get(word)){
//                return false ;
//            }
//        }

        for (Map.Entry<String, Integer> e :
                map.entrySet()) {
            if (map2.get(e.getKey()) == null || map2.get(e.getKey()) < e.getValue()) {
                return false;
            }
        }
        return true ;
    }

    public static void print(String []words , int begin , int end){
        if(begin > end || begin == -1 || end == -1){
            return;
        }
        System.out.println(begin + "  " + end);
        for(int i = begin ; i < end+1 ; i++){
            System.out.print(words[i]+" ");
        }
        System.out.println("");
    }

//    public static int Indexof(String[]keywords , String word){
//        for(int i = 0 ; i < keywords.length ; i++){
//            if(keywords[i].equals(word)){
//                return i ;
//            }
//        }
//        return -1 ;
//    }

}

/*
4 7
c e f c
4 6
b c d
2 4
0 3 1
2 4
c d e
4 6
c e f
4 6
b c d
 */
