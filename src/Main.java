import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String [] args){
        try {
            dico d = new dico(new FileInputStream("Ressources/dico.txt"));
            System.out.println(d.dicoVide());
            System.out.println(DistanceMots.levenshtein("elias", "munoz"));
        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
    }
}
