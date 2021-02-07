package package2;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static package2.Case_字符串匹配之后缀数组_倍增法.*;

/**
 * 二分枚举+特殊分组
 *好的算法总是那样的令人头秃
 */

/**
 * 用len将height分组,小于组和大于等于组交替
 * 在大于组中更新最大最小原始小标,大转小的时候检查上一个大于组是否满足不重叠
 * 在小于组中,只需持续地将原始下标付给max和min,这样小转大的时候,可以保留小于组最后一个元素的下标
// * @param height
// * @param sa
// * @param len
// * @return
 */


//寻找最长不重叠字符串
public class Case_后缀数组的应用 {
    public static void main(String[]arr){
        System.out.println(enumeration_Half("12341"));
    }


    public static boolean check(int [] height , Suff [] sa , int len) {
        int minIndex = sa[0].index;
        int maxIndex = sa[0].index;
        for (int i = 1; i < height.length; i++) {
            int index = sa[i].index;
            if (height[i] >= len) {//lcp大于len
                minIndex = min(minIndex, index);
                maxIndex = max(maxIndex, index);
            } else {
                if (maxIndex - minIndex >= len) {
                    return true;
                }
                maxIndex = index;
                minIndex = index;
            }
        }
        return false ;
    }

    public static int enumeration_Half(String src){
        Suff rear [] = Create_SuffixArray_multiplier(src) ;
        int [] height = GetHeight(src , rear) ;
        int ans = 0 ;
        int l = 0 ;
        int r = height.length ;
        while(l <= r){
            int mid = l + ((r - l)>>1) ;
//            if(mid == 0)mid = 1 ;
            if(mid == 0){
                Map<Character ,Integer>map = new HashMap<>() ;
                for(int i = 0 ; i < src.length() ; i++){
                    if(map.get(src.charAt(i)) == null){
                        map.put(src.charAt(i) , 1) ;
                    }else{
                        return 1 ;
                    }
                }
                return 0;
            }
            if(mid > height.length/2)return ans ;
            if(check(height , rear , mid)){
                if(mid == height.length / 2){
                    return mid ;
                }
                l = mid + 1 ;
                ans = mid ;
            }else {
                r = mid - 1 ;
            }
        }
        return ans ;
    }




}
