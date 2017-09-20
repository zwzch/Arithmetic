package OneHash;

/**
 * Created by zw on 17-9-20.
 */
public class Node {
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String ip;
    public String Hash;
    public String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    @Override
    public String toString() {
        return this.ip;
    }

    public Node(String ip, String info) {
        this.ip = ip;
        this.info = info;
    }
}
