import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class EditInstructions{
    public static String first, second;
    public static int[][] memo;
    public static String result;
    public static int delete, insert, replace;
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        Scanner sc = new Scanner(System.in);
        int test = io.getInt();
        for(int ii = 0; ii < test; ii++){
            result = "";
            delete = io.getInt();
            insert = io.getInt();
            replace = io.getInt();
            first = sc.nextLine();
            second = sc.nextLine();
            memo = new int[first.length()+1][second.length()+1];
            for(int i = 0; i <= first.length(); i++){
                for(int j = 0; j <= second.length(); j++){
                    memo[i][j] = -1;
                }
            }
            io.println(answer(0, 0, 0, result));
        }
        io.close();
        sc.close();
    }

    public static int answer(int i, int j, int weight, String result){
        if (memo[i][j] != -1) return memo[i][j];
        // insert rest of first
        if (i == first.length()) {
            memo[i][j] = (second.length()-j) * insert + weight;
            return (second.length()-j) * insert + weight;
        }
        
        // insert rest of first
        if (j == second.length()) {
            memo[i][j] = (first.length() - i) * insert + weight;
            return (first.length()-i) * insert + weight;
        }

        // Skip
        if (first.charAt(i) == second.charAt(j)) {
            memo[i][j] = answer(i+1,j+1, weight, result + "S");
            return weight;
        }

        memo[i][j] = Math.min(Math.min(
            answer(i,j+1, weight + insert, result + "I" + Character.toString(second.charAt(j))), // insert
            answer(i+1,j, weight + delete, result + "D")), // delete
            answer(i+1,j+1, weight + replace, result + "R" + Character.toString(second.charAt(j))) // replace
            );
        return memo[i][j];
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
