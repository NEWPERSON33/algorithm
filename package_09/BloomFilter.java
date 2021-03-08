package package_09;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BloomFilter {
    public static final int NUM_SLOTS = 1024*1024*8;//位图长度
    public static final int NUM_HASH = 8 ;//哈希函数的个数
    private BigInteger bitmap = new BigInteger("0");//位图
    private int getHash(String message , int n) throws NoSuchAlgorithmException {
        message = message + String.valueOf(n);
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] bytes = message.getBytes();
        md5.update(bytes);
        BigInteger bi = new BigInteger(md5.digest());
        return Math.abs(bi.intValue())%NUM_SLOTS;
    }

    public void addElement(String message) throws NoSuchAlgorithmException {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message , i);
            if(!bitmap.testBit(hashcode)){
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }

    public boolean check(String message) throws NoSuchAlgorithmException {//可能在或者一定不在
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message , i);
            if(!this.bitmap.testBit(hashcode)){
                return false;//一定不在
            }
        }
        return true;//不一定正确
    }

}
