import java.util.Scanner;
import java.util.Arrays;

public class mm{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int M,P,L,E,R,S,N;
        while(sc.hasNextInt()){
            M = sc.nextInt();
            P = sc.nextInt();
            L = sc.nextInt();
            E = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            N = sc.nextInt();

            for(int i = 0; i < N; i++){
                int tmp = P;
                P = L/R;
                L = E * M;
                M = tmp / S;
            }
            System.out.println(M);
        }
    }
}