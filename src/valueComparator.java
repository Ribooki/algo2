import java.util.*;


public class valueComparator {

    public static HashSet<String> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> trieMoiLaMap = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(trieMoiLaMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<String, Integer> laMapEstTrie = new LinkedHashMap<String, Integer>();
        HashSet<String> h = new LinkedHashSet<>();

        for (Map.Entry<String, Integer> entry : trieMoiLaMap)
        {
            h.add(entry.getKey());
        }

        return h;
    }
}
