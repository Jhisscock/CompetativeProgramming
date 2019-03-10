import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class pagelayout{
    public static int cases;
    public static long [][] array;
    public static long total;
    public static long [] areas;

    public static boolean overlap(int x, int y){
        if(array[x][0] >= array[y][1] || array[y][0] >= array[x][1]){

        }else
    }

    public static void Solution(int x, boolean [] c){
        if(x < cases){
            Solution(x+1, c);
            boolean check = false;
            for(int i = 0; i < x; i++){
                if(overlap)
                check = true;
                break;
            }
        }
        if(!check){
            c[x] = true;
            Solution(x+1, c);
        }
    }

    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        cases = io.getInt();
        long size = (long)Math.pow(2, cases-1);
        array = new long[cases][4];
        long tmp = 0;
        boolean [] checked = new boolean[cases];
        for(int i = 0; i < cases; i++){
           for(int j = 0; j < 4; j++){
               array[i][j] = io.getLong();
           }
           areas[i] = array[i][0] * array[i][1];
        }
        total = tmp * size;
        Solution(0, checked);
        io.println(total);
        io.close();
    }

    public static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
        }
    
        public boolean hasMoreTokens() {
        return peekToken() != null;
        }
    
        public int getInt() {
        return Integer.parseInt(nextToken());
        }
    
        public double getDouble() { 
        return Double.parseDouble(nextToken());
        }
    
        public long getLong() {
        return Long.parseLong(nextToken());
        }
    
        public String getWord() {
        return nextToken();
        }
    
    
    
        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;
    
        private String peekToken() {
        if (token == null) 
            try {
            while (st == null || !st.hasMoreTokens()) {
                line = r.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            token = st.nextToken();
            } catch (IOException e) { }
        return token;
        }
    
        private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
        }
    }
    
}
