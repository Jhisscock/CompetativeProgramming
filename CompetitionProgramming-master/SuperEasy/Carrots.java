import java.util.Scanner;
import java.util.Arrays;

public class Carrots{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        String [] tmp2 = tmp.split("\\s+");
        int length = Integer.parseInt(tmp2[0]);
        int answer = Integer.parseInt(tmp2[1]);
        for(int i = 0; i < length; i++){
            sc.nextLine();
        }
        System.out.println(answer);
    }
}