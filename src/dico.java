import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class dico {
    private HashSet<String> h;                                              //creation du dictionnaire
    private Map<String, HashSet<String>> trigrammes = new HashMap<>();
    private String[] motsTrigCommTrie;
    private String[] top5mots;
    Lock lock = new ReentrantLock();

    public dico(FileInputStream f){
        h = readFile(f);
        createTrigrammesDico();
    }

    /**__________DICTIONNAIRE__________**/

    public HashSet<String> getH() {
        return h;
    }

    public boolean dicoVide(){
        return h.isEmpty();
    }

    public boolean mExiste(String M){
        return h.contains("<" + M + ">");
    }

    /**________SECTION_LECTURE_FICHIER__________ **/

    private HashSet<String> readFile(FileInputStream f) {
        HashSet<String> wl = new HashSet<>();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(f));
            while (reader.ready()) {
                wl.add("<"+reader.readLine()+">");
            }
            return wl;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**_______SECTION_TRIGRAMMES_________ **/

    private void createTrigrammesDico(){
        for(String mot : h){
            String[] trigrammesMot = createTrigrammesMot(mot);
            for(String trig : trigrammesMot){
                if(!trigrammes.containsKey(trig)){
                    trigrammes.put(trig, new HashSet<>());
                }
                trigrammes.get(trig).add(mot);
            }
        }
    }

    private String[] createTrigrammesMot(String mot){
        String[] t = new String[mot.length() - 2];
        String trigramme;
        for(int i=0 ; i+2<mot.length() ; i++){
            trigramme = mot.substring(i, i+3);
            t[i] = trigramme;
        }
        return t;
    }

    /**__________SECTION_TRIGRAMMES_COMMUNS___________**/

    private void motsTrigrammesCommuns(String mot){

            String[] tMot = createTrigrammesMot("<" + mot + ">"); // on crée les trigramme du mot
            HashMap<String, Integer> listeTrigComm = new HashMap<>(); //HashMap<mots, nbTrigCommun>
            for (String tri : tMot) {
                if(trigrammes.containsKey(tri)) {
                    for (String m : trigrammes.get(tri)) {
                        if (!listeTrigComm.containsKey(m)) {
                            listeTrigComm.put(m, 1);
                        } else {
                            listeTrigComm.put(m, listeTrigComm.get(m) + 1);
                        }
                    }
                }
            }
            motsTrigCommTrie = valueComparator.sortByValue(listeTrigComm, 100);
    }

    public void get5TopMotsDistance(String mot){
        HashMap<String, Integer> levi = new HashMap<>();
        motsTrigrammesCommuns(mot);
        for (int i=0; i<motsTrigCommTrie.length; i++) {
            if (motsTrigCommTrie[i] == null)
                break;
            levi.put(motsTrigCommTrie[i], (-1) * DistanceMots.levenshtein(mot, motsTrigCommTrie[i]));
        }
        top5mots = valueComparator.sortByValue(levi, 5);
        affiche5premiersMots(mot);
    }

    public void affiche5premiersMots(String mot){
        System.out.print(mot + " : ");
        for(int i=0; i<5; i++){
            System.out.print(top5mots[i]);
        }
        System.out.println();
    }
}

