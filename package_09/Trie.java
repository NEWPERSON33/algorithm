package package_09;

import java.util.ArrayList;

//前缀树
public class Trie {
    private TrieNode root = new TrieNode() ;
    private ArrayList<String>data = new ArrayList<>() ;

    public static void main(String[] args) {
        //System.out.println('c' - 'a');
        Trie test = new Trie() ;
        test.apply("mornig");
        test.apply("good");
        test.apply("fuck");
        test.DFS("" , test.root);
        System.out.println(test.data);
    }

    private void apply(String str){
        char [] ch = str.toCharArray() ;
        TrieNode p = root ;
        for (int i = 0; i < ch.length; i++) {
            TrieNode child = p.children[ch[i] - 'a'] ;
            if(child == null){
                TrieNode nn = new TrieNode() ;
                nn.level = i ;
                nn.fre = 1 ;
                nn.parent = p ;
                p.children[ch[i] - 'a'] = nn ;
                p = nn ;
            }else {
                p = child;
                child.fre++ ;
            }
        }
        p.isLast = true ;
    }

    private void DFS(String str , TrieNode node){
        if(node.isLast && str.length() > 0){
            data.add(str) ;
        }
        for (int i = 0; i < node.children.length; i++) {
            if(node.children[i] != null){
                DFS(str + (char)(i + 'a') , node.children[i]) ;
            }
        }
    }

}
