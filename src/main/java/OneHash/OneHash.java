package OneHash;

import  java.util.*;
import java.util.TreeMap;

/**
 * Created by zw on 17-9-20.
 */
public class OneHash {
    private int VNnum=100;
    private List Nodes;
    private final SortedMap<Long, Node> circle = new TreeMap<Long, Node>();
//    private HashMap NodeMap=new HashMap();
    public boolean init(List nodes,int vnum){
        this.VNnum = vnum;
        this.Nodes = nodes;
        for (Object obj:Nodes) {
            add((Node) obj);
        }
        return  true;
    }
    public void add(Node node) {
        for (int i=0;i<VNnum;i++ ){
            circle.put(HashUtil.Hash(node.toString()+i),node);
        }
    }
    public Node get(String s_hash){
        if (circle.isEmpty()) {
            return null;
        }
        SortedMap<Long, Node> tail_map =  circle.tailMap(HashUtil.Hash(s_hash));
        long get_hash = tail_map.isEmpty()?circle.firstKey(): (long) tail_map.firstKey();
        return circle.get(get_hash);
    }
}
