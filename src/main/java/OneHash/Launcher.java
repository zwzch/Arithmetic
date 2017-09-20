package OneHash;

/**
 * Created by zw on 17-9-20.
 */
import  java.util.*;
public class Launcher {
    private int sumHash;

    public static void main(String[] args) {
//        Launcher launcher = new Launcher();
//        short data = -6553;
//        System.out.println(launcher.getUnsignedByte(data));
        HashMap <String,Integer>data_Map = new HashMap<String,Integer>();
        String Ip = "192.168.56.";
        List <Node>Nodes = new ArrayList();
        for (int i=1;i<=10;i++){
            Nodes.add(new Node(Ip+i,"node"+i));
            data_Map.put(Ip+i,0);
        }
        OneHash oneHash = new OneHash();
        oneHash.init(Nodes,100);
        for (Node node:Nodes) {
            oneHash.add(node);
        }
//        System.out.println(oneHash.get(UUID.randomUUID().toString()));
        for (int j=1;j<1000;j++){
            Node node = oneHash.get(UUID.randomUUID().toString());
            int tmp = data_Map.get(node.getIp());
            data_Map.put(node.getIp(),++tmp);
        }
        for(String key:data_Map.keySet()){
            System.out.println("ip -------------> "+key+"  "+"data ------------->"+data_Map.get(key));
        }
    }
}
