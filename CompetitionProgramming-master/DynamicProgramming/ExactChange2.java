import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class ExactChange2{

    public static int [] coin = new int[1000];
    public static int MAX = 999999999;
    public static int bills;
    public static int count;
    public static int min = -1000000;
    public static int price;
    public static int [] counter = new int[1000];
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int cases = io.getInt();
        for(int ii = 0; ii < cases; ii++){
            price = io.getInt();
            bills = io.getInt();
            for(int i = 0; i < bills; i++){
                coin[i] = io.getInt();
            }
            int tmp;
            while(true){
                tmp = answer(0, price);
                if(tmp < MAX) break;
                price = price - min;
            }
            io.println(price + " " + tmp);
        }
        io.close();
    }

    public static int answer(int x, int y){
        if(y > min && y < 0){
            min = y;
        }
        if(y < 0) return MAX;
        if(y == 0) return 0;
        if(x >= bills) return MAX;
        return Math.min(answer(x+1,y), answer(x+1, y-coin[x])+1);
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