import java.io.*;

public class Main {
    public static void main(String [] args){
        try {
            dico d = new dico(new FileInputStream("Ressources/dico.txt"));
            final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Ressources/fautes.txt")));
            long startTime = System.nanoTime();
            while (reader.ready()) {
                d.get5TopMotsDistance(reader.readLine());
            }
            long endTime = System.nanoTime();
            System.out.println("Durée : " + ((endTime - startTime)*Math.pow(10, -9)) + "s" );
        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        catch(IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
