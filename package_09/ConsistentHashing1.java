package package_09;
/**
 * 欠账：删除数据，
 * 虚拟节点
 */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class ConsistentHashing1 {
    private List<YHNode>nodes ;
    private TreeMap<Long, YHNode> HashandNode = new TreeMap<>();
    private TreeMap<Long , YHNode> IpandNode = new TreeMap<>();
    public ConsistentHashing1(List<YHNode> nodes ){
        this.nodes = nodes ;
        init();
    }
    private long hash(String key){////hash算法，将关键字映射到2^32的环状空间里面
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return Math.abs(h);

    }
    private void init(){//根据ip生成哈希码
        for (YHNode Y:nodes) {
            long hash = hash(Y.ip);
            HashandNode.put(hash , Y);
        }
    }

    public void add(String ip){//要根据用户ip进行区域分配
        long hash = hash(ip);
        SortedMap<Long, YHNode> subMap = HashandNode.tailMap(hash);//找到map中key比fromKey大的所有的键值对，组成一个子Map
        if(subMap.size() == 0){
            IpandNode.put(hash , HashandNode.firstEntry().getValue());
        }else {
            IpandNode.put(hash , subMap.get(subMap.firstKey()));//归属到子图第一个大于目标节点的
        }
    }

    public void add(YHNode Knode){//增加服务器
        long hash = hash(Knode.ip);
        SortedMap<Long , YHNode>mapHead = IpandNode.headMap(hash);//找到所有小于新增服务器节点的节点
        if(mapHead.size() == 0){
            SortedMap<Long , YHNode> between1 = IpandNode.subMap(0L , hash);
            for (Map.Entry<Long , YHNode> e:between1.entrySet()) {
                e.setValue(Knode);
            }
            SortedMap<Long , YHNode> between2 = IpandNode.tailMap(HashandNode.lastKey());
            for (Map.Entry<Long , YHNode> e:between2.entrySet()) {
                e.setValue(Knode);
            }
        }else {
            long from = mapHead.lastKey();
            SortedMap<Long , YHNode> between = IpandNode.subMap(from , hash);
            for (Map.Entry<Long , YHNode> e:between.entrySet()) {
                e.setValue(Knode);
            }
        }
    }

}
class YHNode{
    public String name ;
    public String ip ;
    public YHNode(String name , String ip){
        this.name = name ;
        this.ip = ip ;
    }
}
