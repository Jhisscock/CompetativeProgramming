import java.util.Scanner;
import java.util.Arrays;

public class armystrength2{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        int greatG ;
        int greatMG;
        for(int i = 0; i<tmp; i++){
            sc.nextLine();
            String tmp1 = sc.nextLine();
            String tmp2 = sc.nextLine();
            String [] tmp3 = tmp1.split("\\s+");
            String [] tmp4 = tmp2.split("\\s+");
            Arrays.sort(tmp3);
            Arrays.sort(tmp4);
            greatG = Integer.parseInt(tmp3[tmp3.length-1]);
            greatMG = Integer.parseInt(tmp4[tmp4.length-1]);
            if(greatG >= greatMG){
                System.out.println("Godzilla");
            } else {
                System.out.println("MechaGodzilla");
            }
            sc.nextLine();
        }
    }
}