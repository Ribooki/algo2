import java.util.*;


public class valueComparator {

    public static ArrayList<String> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> trieMoiLaMap = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(trieMoiLaMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        ArrayList<String> sortedMap = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : trieMoiLaMap)
        {
            sortedMap.add(entry.getKey());
        }

        return sortedMap;
    }
}
