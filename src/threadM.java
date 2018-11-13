public class threadM extends Thread {
    private dico d;
    private String m;

    public threadM(dico d, String m) {
        this.d = d;
        this.m = m;
    }

    @Override
    public void run() {
        d.get5TopMotsDistance(m);
    }
}
