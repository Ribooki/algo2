import java.util.Comparator;
import java.util.HashMap;

public class valueComparator implements Comparator<String> {
    private HashMap<String, Integer> sorted = new HashMap<>();

    public void setSorted(HashMap<String, Integer> map) {
        sorted.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if(sorted.get(s1) >= sorted.get(s2))
            return -1;
        else
            return 1;
    }
}
