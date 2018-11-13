import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String [] args){
        try {
            dico d = new dico(new FileInputStream("Ressources/dico.txt"));
            final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Ressources/fautes.txt")));
            ExecutorService exe = Executors.newFixedThreadPool(4);
            long startTime = System.nanoTime();
            while (reader.ready()) {
                exe.submit(new threadM(d, reader.readLine()));
                //d.get5TopMotsDistance(reader.readLine());
            }
            try{
                exe.shutdown();
                exe.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException ie){
                System.out.println(ie.getMessage());
            }
            long endTime = System.nanoTime();
            System.out.println("Durée : " + ((endTime - startTime) * Math.pow(10, -9)) + "s");

        }
        catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        catch(IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
