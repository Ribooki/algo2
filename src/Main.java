import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String [] args){
        try {
            dico d = new dico(new FileInputStream("dico.txt"));
            System.out.println(DistanceMots.levenshtein("elias", "munoz"));
        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
    }
}
