public class DistanceMots {
    private static int Tmin[][];
    private static int n;
    private static int m;
    private static String mot1;
    private static String mot2;

    public static int levenshtein(String m1, String m2){
        mot1 = m1;
        mot2 = m2;
        n = mot1.length();
        m = mot2.length();
        Tmin = new int[n+1][m+1];
        for(int i=0 ; i<n+1 ; i++){
            for(int j=0 ; j<m+1 ; j++){
                Tmin[i][j] = -1;
            }
        }
        for(int i=0 ; i<n+1 ; i++){
            Tmin[i][0] = i;
        }
        for(int j=0 ; j<m+1 ; j++){
            Tmin[0][j] = j;
        }
        Tmin[0][0] = 0;
        return minD(n, m);
    }

    private static int minD(int i, int j){
        if (Tmin[i][j] == -1){
            if(mot1.charAt(i-1) != mot2.charAt(j-1))
                Tmin[i][j] = min(minD(i-1,j), minD(i,j-1), minD(i-1,j-1)) + 1;
            else
                Tmin[i][j] = min(minD(i-1,j), minD(i,j-1), minD(i-1,j-1));
        }
        return Tmin[i][j];
    }

    private static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String [] args){
        System.out.println(levenshtein("elias","munoz"));
    }
}
