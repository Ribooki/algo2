import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String [] args){
        try {
            dico d = new dico(new FileInputStream("Ressources/dico.txt"));
            final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Ressources/fautes.txt")));
            ExecutorService exe1 = Executors.newFixedThreadPool(4);
            long startTime = System.nanoTime();
            while (reader.ready()) {
                exe1.submit(new threadM(d, reader.readLine()));
            }
            try{
                exe1.shutdown();
                exe1.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException ie){
                System.out.println(ie.getMessage());
            }
            long endTime = System.nanoTime();
            double secondes = ((endTime - startTime) * Math.pow(10, -9));
            double resultat =(double) Math.round(secondes * 100)/100;
            System.out.println("\u001B[36m" +"Durée : " + resultat + "s");

        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        catch(IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
