import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class dico {
    private HashSet<String> h;
    public dico(FileInputStream f){
        h = Read_file(f);
    }

    public HashSet<String> getH() {
        return h;
    }

    public boolean dicoVide(){
        return h.isEmpty();
    }

    public boolean M_existe(String M){
        return h.contains(M);
    }

    private HashSet<String> Read_file(FileInputStream f) {
        HashSet<String> wl = new HashSet<>();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(f));
            while (reader.ready()) {
                wl.add(reader.readLine());
            }
            return wl;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
