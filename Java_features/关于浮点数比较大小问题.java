package Java_features;

public class 关于浮点数比较大小问题 {
    public static void main(String[] args) {
        double x =3/7.0;
        double y =3/7.0;
        double z = 1 ;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x==y);
        System.out.println((x-y));
        System.out.println(Math.abs((x-y)-z) <= 1.0E-15);
    }
}
/**总结；
 * 未经任何运算的两浮点数可直接比较，但经过运算的浮点值可能会存在误差，
 * 将误差标准调整至小数点后15-16为即可判别相等.取15位更佳
 *
 */
