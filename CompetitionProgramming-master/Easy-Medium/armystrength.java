import java.util.Scanner;
import java.util.Arrays;

public class armystrength{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        int currGreat;
        int gSize;
        int mgSize;
        int gGreat;
        int mgGreat ;
        for(int i = 0; i<tmp; i++){
            gSize = sc.nextInt();
            mgSize = sc.nextInt();
            sc.nextLine();
            gGreat = 0;
            mgGreat = 0;
            for(int j = 0; j<gSize; j++){
                currGreat = sc.nextInt();
                if(currGreat > gGreat){
                    gGreat = currGreat;
                }
            }
            for(int j = 0; j<mgSize; j++){
                currGreat = sc.nextInt();
                if(currGreat > mgGreat){
                    mgGreat = currGreat;
                }
            }
            if(gGreat>=mgGreat){
                System.out.println("Godzilla");
            }else{
                System.out.println("MechaGodzilla");
            }
            sc.nextLine();
        }
    }
}