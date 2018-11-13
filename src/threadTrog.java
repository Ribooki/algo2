import java.util.HashSet;
import java.util.Map;

public class threadTrog extends Thread {
    private Map<String, Integer> listeTrigComm;
    private HashSet<String> list;


    public threadTrog(Map<String, Integer> listeTrigComm, HashSet<String> list) {
        this.listeTrigComm = listeTrigComm;
        this.list = list;
    }

    @Override
    public void run() {
        for (String m: list) {
            listeTrigComm.putIfAbsent(m, 1);
            listeTrigComm.replace(m, listeTrigComm.get(m) + 1);
        }
    }
}
