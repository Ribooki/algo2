import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class dico {
    private static HashSet<String> h;
    private Map<String, ArrayList<String>> trigrammes = new HashMap<>();

    public dico(FileInputStream f){
        h = readFile(f);
    }

    public HashSet<String> getH() {
        return h;
    }

    public static boolean dicoVide(){
        return h.isEmpty();
    }

    public static boolean mExiste(String M){
        return h.contains(M);
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
}
