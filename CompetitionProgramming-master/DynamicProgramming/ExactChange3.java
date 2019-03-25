import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class ExactChange3{
    public static int MAX = 9999999;
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int cases = io.getInt();
        for(int ii = 0; ii < cases; ii++){
            int price = io.getInt();
            int bills = io.getInt();
            int [] coin = new int[bills];
            int [] array = new int[bills+1];
            for(int i = 0; i < bills; i++){
                coin[i] = io.getInt();
                array[i+1] = coin[i];
            }
            array[0] = 0;
            int min = -999999;
            int tmp;
            while(true){
                tmp = answer(array, coin, price, bills, min);
                if(tmp < MAX) break;
                price = price - min;
            }
            io.println(price + " " + tmp);
        }
        io.close();
    }

    public static int answer(int [] array, int [] coin, int price, int bills, int min){
        for(int i = 0; i < bills; i++){
            for(int j = 1; j <  bills+1; j++){
                if(price == 0){
                    return 0;
                }
                if(price < 0){
                    return MAX;
                }
                if(i == 0){
                    array[j] = price - array[j];
                }else if(i != j){
                    array[j] = array[j] - coin[i];
                    if(array[j] > min && array[j] <= 0){
                        min = array[j];
                    }
                }
                if(array[j] == 0){
                    return i;
                }
            }
        }
        for(int i = 0; i < bills; i++){
            array[i+1] = coin[i];
        }
        array[0] = 0;
        return MAX;
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