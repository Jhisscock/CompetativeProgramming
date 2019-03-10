import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class ladice{
    public static int elements;
    public static int [] parent;
    public static int [] size;
    public static boolean [] full;
    public static int [] tmp;
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int operations = io.getInt();
        elements = io.getInt();
        create(elements);

        for(int i = 0; i < operations; i++){
            int first = io.getInt()-1;
            int second = io.getInt()-1;
            union(first, second);
            if(!full[first]){
                full[first] = true;
                io.println("LADICA");
            }else if(!full[second]){
                full[second] = true;
                io.println("LADICA");
            }else if(full[first] && full[second]){
                for(int j = 0; j < elements; j++){
                    if(connected(first, parent[j]) && !full[parent[j]]){
                        full[parent[j]] = true;
                        io.println("LADICA");
                    }else if(connected(second, parent[j]) && !full[parent[j]]){
                        full[parent[j]] = true;
                        io.println("LADICA");
                    }else if( j == elements - 1){
                        io.println("SMECE");
                    }
                }
            }
            io.println(Arrays.toString(parent));
        }
        io.close();
    }

    public static boolean connected(int first, int second){
        if(find(first) == find(second)){
            return true;
        }else{
            return false;
        }
    }

    public static void create(int elements){
        parent = new int[elements];
        size = new int[elements];
        full = new boolean[elements];
        tmp = new int[elements];
        for(int i = 0; i < elements; i++){
            parent[i] = i;
            size[i] = 1;
            full[i] = false;
        }
    }

    public static void union(int first, int second){
        int fRep = find(first);
        int sRep = find(second);
        if(fRep == sRep){
            return;
        }
        if(size[fRep] < size[sRep]){
            size[sRep] += size[fRep];
            for(int i = 0; i < elements; i++){
                if(connected(parent[i], parent[fRep])){
                    System.out.println(i);
                    tmp[i] = i;
                }
            }
            for(int i = 0; i < tmp.length; i++){
                parent[tmp[i]] = sRep;
            }
        }else{
            size[fRep] += size[sRep];
            for(int i = 0; i < elements; i++){
                if(connected(parent[i], parent[sRep])){
                    System.out.println(i);
                    tmp[i] = i;
                }
            }
            for(int i = 0; i < tmp.length; i++){
                parent[tmp[i]] = fRep;
            }
        }
    }

    public static int find(int i){
        int root = i;
        while(root != parent[root]){
            root = parent[root];
        }
        while(i != root){
            int tmp = parent[i];
            parent[i] = root;
            i = tmp;
        }
        return root;
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