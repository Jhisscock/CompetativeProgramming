import java.util.Scanner;
import java.util.Arrays;

public class stats{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n;
        int greatest = 0;
        int least = 0;
        int curr;
        int count = 0;
        int range;
        while(sc.hasNextInt()){
            n = sc.nextInt();
            for(int i = 0; i < n; i++){
                curr = sc.nextInt();
                if(i == 0){
                    least = curr;
                    greatest = curr;
                }
                if(curr>greatest){
                    greatest = curr;
                }else if(curr<least){
                    least = curr;
                }
            }
            count++;
            range = greatest - least;
            System.out.println("Case " + count + ": " + least + " " + greatest + " " + range );
        }
    }
}