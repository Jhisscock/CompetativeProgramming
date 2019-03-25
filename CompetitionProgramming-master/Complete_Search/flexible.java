import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class flexible{
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int size = io.getInt();
        int numP = io.getInt();
        int [] partition = new int [numP+2];
        ArrayList<Integer> answer = new ArrayList<>();
        Set<Integer> duplicate = new LinkedHashSet<>();
        partition[0] = 0;
        partition[numP+1] = size;
        for(int i = 1; i < numP+1; i++){
            partition[i] = io.getInt();
        }
        for(int i = 1; i < numP+2; i++){
            for(int j = 0; j < numP+2; j++){
                if(j == i){
                    answer.add(partition[j]);
                }else if(partition[i] - partition[j] < 1){
                    continue;
                }else{
                    answer.add(partition[i] - partition[j]);
                }
            }
        }
        duplicate.addAll(answer);
        answer.clear();
        answer.addAll(duplicate);
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++){
            io.print(answer.get(i) + " ");
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