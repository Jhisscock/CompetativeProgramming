import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class cds{
    public static void main(String [] args){
        Kattio io = new Kattio(System.in, System.out);
        int score = io.getInt();
        int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int [] multiplyer = {1,2,3};
        boolean answer =false;
        outerloop:
        for(int i = 0; i < array.length; i++){
            for(int j = 2; j >= 0; j--){
                if(array[i] * multiplyer[j] == score){
                    answer = true;
                    if(multiplyer[j] == 3){
                        io.println("triple " + array[i]);
                    }else if(multiplyer[j] == 2){
                        io.println("double " + array[i]);
                    }else if(multiplyer[j] == 1){
                        io.println("single " + array[i]);
                    }
                    break outerloop;
                }
                for(int k = 0; k < array.length; k++){
                    for(int l = 2; l >= 0; l--){
                        if(array[i] * multiplyer[j] + array[k] * multiplyer[l] == score){
                            answer = true;
                            if(multiplyer[j] == 3){
                                io.println("triple " + array[i]);
                            }else if(multiplyer[j] == 2){
                                io.println("double " + array[i]);
                            }else if(multiplyer[j] == 1){
                                io.println("single " + array[i]);
                            }
                            if(multiplyer[l] == 3){
                                io.println("triple " + array[k]);
                            }else if(multiplyer[l] == 2){
                                io.println("double " + array[k]);
                            }else if(multiplyer[l] == 1){
                                io.println("single " + array[k]);
                            }
                            break outerloop;
                        }
                        for(int p = 0; p < array.length; p++){
                            for(int q = 2; q >= 0; q--){
                                if(array[i] * multiplyer[j] + array[k] * multiplyer[l] + array[p] * multiplyer[q] == score){
                                    answer = true;
                                    if(multiplyer[j] == 3){
                                        io.println("triple " + array[i]);
                                    }else if(multiplyer[j] == 2){
                                        io.println("double " + array[i]);
                                    }else if(multiplyer[j] == 1){
                                        io.println("single " + array[i]);
                                    }
                                    if(multiplyer[l] == 3){
                                        io.println("triple " + array[k]);
                                    }else if(multiplyer[l] == 2){
                                        io.println("double " + array[k]);
                                    }else if(multiplyer[l] == 1){
                                        io.println("single " + array[k]);
                                    }
                                    if(multiplyer[q] == 3){
                                        io.println("triple " + array[p]);
                                    }else if(multiplyer[q] == 2){
                                        io.println("double " + array[p]);
                                    }else if(multiplyer[q] == 1){
                                        io.println("single " + array[p]);
                                    }
                                    break outerloop;
                                }
                            }
                        }
                    }
                }
            }
            
        }
        if(!answer){
            io.println("impossible");
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