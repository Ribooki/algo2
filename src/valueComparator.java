import java.util.*;


public class valueComparator {

    public static String[] sortByValue(Map<String, Integer> map, int size) {
        List<Map.Entry<String, Integer>> trieMoiLaMap = new LinkedList<>(map.entrySet());
        String[] sortedMap = new String[size];

        Collections.sort(trieMoiLaMap, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // Utilisation d'une lambda expression pour eviter d'ecrire :
        /* new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }); */


        int i=0;
        for (Map.Entry<String, Integer> entry : trieMoiLaMap)
        {
            sortedMap[i++] = entry.getKey();
            if (i == size) break;
        }
        return sortedMap;
    }
}
