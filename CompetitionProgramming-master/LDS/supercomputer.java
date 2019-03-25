import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class supercomputer{
    public static long [] array;
    public static int [] checked;
    public static int arrayL;
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        arrayL = io.getInt();
        create(arrayL);
        int operations = io.getInt();
        for(int i = 0; i < operations; i++){
            String operand = io.getWord();
            if(operand.equals("F")){
                int index = io.getInt();
                if(checked[index] == 0){
                    iteration(index, 1);
                    checked[index] = 1;
                }else{
                    iteration(index, -1);
                    checked[index] = 0;
                }
            }else{
                int low = io.getInt();
                int high = io.getInt();
                io.println(summation(high) - summation(low-1));
            }
        }
        io.close();
    }

    public static void create(int arrayL){
        array = new long[arrayL+1];
        checked = new int[arrayL + 1];
    }
    
    public static void iteration(int index, int iterate){ 
        while(index < arrayL+1){
            array[index] += iterate;
            index += index & (-index);
        }
    }

    public static long summation(int index){
        long sum = 0;
        while(index > 0){
            sum += array[index];
            index -= index & (-index);
        }
        return sum;
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