package package_动态规划以及贪心问题;


public class Case_字典序最小问题 {
    public static void main(String[] args) {
        String source = new String("ACDBCB");
        Solution(source);
        Solution_ps(source);
    }

    private static void Solution(String S1){
        String S2 = new StringBuffer(S1).reverse().toString();
        StringBuilder re = new StringBuilder("");
        int flag1 = 0 ;
        int flag2 = 0 ;
        int n1 = S1.length();
        int n2 = n1 ;
        while(flag1 < n1 && flag2 < n2){
            if(S1.charAt(flag1) < S2.charAt(flag2)){
                re.append(S1.charAt(flag1));
                n2--;
                flag1++;
            }else if(S1.charAt(flag1) == S2.charAt(flag2)){
                if((flag1+1 < n1 && flag2 + 1 < n2)){
                    if(S1.charAt(flag1+1) < S2.charAt(flag2+1)){
                        re.append(S1.charAt(flag1));
                        n2--;
                        flag1++;
                    }
                    else if(S1.charAt(flag1+1) == S2.charAt(flag2+1)){
                        re.append(S1.charAt(flag1));
                        n2--;
                        flag1++;
                    }
                    else {
                        re.append(S2.charAt(flag2));
                        n1--;
                        flag2++;
                    }

                }else{
                    re.append(S1.charAt(flag1));
                    flag1++;
                    n2--;
                }



            }else{
                re.append(S2.charAt(flag2));
                n1--;
                flag2++;
            }
        }
        System.out.println(re);
    }

    private static void Solution_ps(String S1){//示例解法
        String S2 = new StringBuffer(S1).reverse().toString();
        StringBuilder re = new StringBuilder("");
        int N = S1.length();
        while(re.length() < N){
            if(S1.compareTo(S2) <= 0){
                re.append(S1.charAt(0));
                S1=S1.substring(1);
            }else{
                re.append(S2.charAt(0));
                S2=S2.substring(1);
            }
        }
        System.out.println(re);
    }

}
