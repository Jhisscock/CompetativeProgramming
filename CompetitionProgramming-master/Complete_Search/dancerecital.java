import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class dancerecital{
    public static int count;
    public static int min = 11;
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int routines = io.getInt();
        ArrayList<String> recitals = new ArrayList<>();
        ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>(50);
        int [] weight = new int[routines];
        int count = 0;
        for(int i = 0; i < routines; i++){
            recitals.add(io.getWord());
        }
        int j = 0;
        int i = 1;
        while( i < routines){
            if(weight[i] < routines){
                if(i % 2 == 0){
                    j = 0;
                }else{
                    j = weight[i];
                }
                Collections.swap(recitals, i, j);
                answer.set(count, recitals);
                count++;
                io.println(answer);
                weight[i]++;
                i = 1;
            }else{
                weight[i] = 0;
                i++;
            }
        }
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