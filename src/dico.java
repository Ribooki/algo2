import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class dico {
    private HashSet<String> h;
    private Map<String, ArrayList<String>> trigrammes = new HashMap<>();

    public dico(FileInputStream f){
        h = readFile(f);
        createTrigrammesDico();
    }

    public HashSet<String> getH() {
        return h;
    }

    public boolean dicoVide(){
        return h.isEmpty();
    }

    public boolean mExiste(String M){
        return h.contains("<" + M + ">");
    }

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

    private void createTrigrammesDico(){
        ArrayList<String> dico = new ArrayList<String>(h);
        for(String mot : dico){
            ArrayList<String> trigrammesMot = createTrigrammesMot(mot);
            for(String trig : trigrammesMot){
                if(!trigrammes.containsKey(trig)){
                    trigrammes.put(trig, new ArrayList<String>());
                }
                trigrammes.get(trig).add(mot);
            }
        }
    }

    private ArrayList<String> createTrigrammesMot(String mot){
        ArrayList<String> t = new ArrayList<String>();
        String trigramme;
        for(int i=0 ; i+3<mot.length() ; i++){
            trigramme = mot.substring(i, i+3);
            t.add(trigramme);
        }
        return t;
    }
}
