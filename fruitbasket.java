import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class fruitbasket{
    public static int fruits;
    public static long [] array;
    public static long total;

    public static void Solution(int x, boolean [] c, long y){
        if(x < fruits){
            Solution(x+1, c, y);
            if(array[x]+y < 200){
                c[x] = true;
                Solution(x+1,c,array[x]+y);
            }
        }else{
            total-= y;
        }
    }

    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        fruits = io.getInt();
        long size = (long)Math.pow(2, fruits-1);
        array = new long[fruits];
        long tmp = 0;
        boolean [] checked = new boolean[fruits];
        for(int i = 0; i < fruits; i++){
            array[i] = io.getLong();
            tmp += array[i];
        }
        total = tmp * size;
        Solution(0, checked, 0);
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
