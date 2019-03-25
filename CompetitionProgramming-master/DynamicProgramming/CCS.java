import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class CCS{
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int num = io.getInt();
        int []coins = new int[num];
        for(int ii = 0; ii < num; ii++){
            coins[ii] = io.getInt();
        }
        int topRange = coins[num-1] + coins[num-2] - 1;
        int bottomRange = 0;
        if(num > 3){
            bottomRange = coins[2];
        }
        int [] array = new int[topRange + 1];
        array[0] = 0;
        Arrays.sort(coins);
        for(int ii = 1; ii < topRange + 1; ii++){
            array[ii] = Integer.MAX_VALUE;
        }

        bestCount(coins, num, topRange, array);

        for(int ii = bottomRange; ii <= topRange; ii++){
            if(array[ii] < actualCount(coins, num, ii)){
                io.println("non-canonical");
                break;
            }else if(ii == topRange){
                io.println("canonical");
            }
        }
        io.close();
    }

    public static void bestCount(int [] coins, int num, int topRange, int [] array){
        for(int i = 1; i <= topRange; i++){
            for(int j = 0; j < num && coins[j] <= i; j++){
                array[i] = Math.min(array[i - coins[j]] + 1, array[i]);
            }
        }
    }

    public static int actualCount(int [] coins, int num, int topRange){
        int count = 0;
        for(int i = num - 1; i > -1; i--){
            int tmp = topRange / coins[i];
            if(tmp > 0){
                topRange -= tmp * coins[i];
                count += tmp;
            }
            if(topRange == 0){
                break;
            }
        }
        return count;
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