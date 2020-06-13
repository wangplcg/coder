package cn.com.zookeeper;

import org.apache.commons.lang3.RandomUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Objects;

/**
 * Description:
 * User: 34
 * Date: 2020-04-19
 * Time: 17:07
 */

public class MasterMatcher implements Watcher {

    private ZooKeeper zk;

    private String hostport;

    private String servieId = Integer.toHexString(RandomUtils.nextInt());

    private boolean isLeader = false;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public MasterMatcher(String hostport) {
        this.hostport = hostport;
    }

    void startZk() throws IOException {
        zk = new ZooKeeper(hostport, 15000, this);
    }


    void stopZk() throws IOException, InterruptedException {
        zk.close();
    }

    void runMaster() throws KeeperException, InterruptedException {
        while (!isLeader) {
            zk.create("/master", servieId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            byte[] master = getMaster();
            if (Objects.equals(servieId, new String(master))) {
                break;
            }
        }

    }

    byte[] getMaster() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        return zk.getData("/master", false, stat);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        MasterMatcher masterMatcher = new MasterMatcher("47.101.169.25:2181,47.98.122.184:2181,106.15.39.8:2181");
        masterMatcher.startZk();
        masterMatcher.runMaster();
        masterMatcher.getMaster();
        byte[] master = masterMatcher.getMaster();
        System.out.println(master);
        System.in.read();
    }
}

