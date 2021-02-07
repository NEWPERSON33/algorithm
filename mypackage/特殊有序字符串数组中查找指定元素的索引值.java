package mypackage;

public class 特殊有序字符串数组中查找指定元素的索引值 {
    public static void main(String[] arr){
        String arrs[] = {"a" , "" , "ab" , "" , "" , "ad" , "adc"} ;
        int n = Index(arrs , "d") ;
        System.out.println(n) ;

    }

    public static int Index(String[] arr , String target){
        int begin = 0 ;
        int end = arr.length - 1 ;
        while(begin <= end){
            int mid = begin + ((end - begin)>>1) ;
            while(arr[mid].equals("")){
                if(mid > end)
                    return -1 ;
                mid++ ;
            }
            if(arr[mid].compareTo(target) > 0){
                end = mid - 1 ;
            }
            else if(arr[mid].compareTo(target) < 0){
                begin = mid + 1 ;
            }
            else{
                return mid ;
            }
        }
        return -1 ;
    }

}
