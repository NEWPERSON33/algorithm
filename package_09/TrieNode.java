package package_09;

public class TrieNode {
    int level ;//表示字母在原单词中的位置
    TrieNode parent ;
    TrieNode [] children = new TrieNode[26*2] ;
    public boolean isLast ;
    public int fre = 1 ; // 出现频率
}
