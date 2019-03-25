import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class fruitbasket{
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int fruits = io.getInt();
        long size = (long)Math.pow(2, fruits);
        int [] array = new int[fruits];
        boolean [] checked = new boolean[41];
        int answer = 0;
        long sum = 0;
        for(int i = 0; i < fruits; i++){
            array[i] = io.getInt();
            sum += array[i];
        }
        long total = sum*size;
        for(int i = 1; i < fruits; i++){
            sum = 0;
            for(int j = 0; j < fruits; j++){
                if((i & (1 << j)) >  0 && checked[j] == false){
                    sum += array[j];
                }
            }
            if(sum < 200){
                total -= sum;
            }
        }
        io.println(answer);
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
