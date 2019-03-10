import java.util.Scanner;
import java.util.Arrays;

public class armystrength{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();
        sc.nextLine();
        System.out.println();
        boolean boo = true;
        boolean [] win = new boolean[tmp];
        int l = 0;
        for(int i = 0; i<tmp; i++){
            String armynum = sc.nextLine();
            String [] armysplit = armynum.split("\\s+");
            int army1 = Integer.parseInt(armysplit[0]);
            int army2 = Integer.parseInt(armysplit[1]);
            int [] fighters1 = new int[army1];
            int [] fighters2 = new int[army2];
            String tmp1 = sc.nextLine();
            String tmp2 = sc.nextLine();
            String [] tmp3 = tmp1.split("\\s+");
            String [] tmp4 = tmp2.split("\\s+");
            for(int j = 0; j<tmp3.length;j++){
                fighters1[j] = Integer.parseInt(tmp3[j]);
            }
            for(int r = 0; r<tmp4.length;r++){
                fighters2[r] = Integer.parseInt(tmp4[r]);
            }
            System.out.println();
            Arrays.sort(fighters1);
            Arrays.sort(fighters2);
            int q = 0;
            int w = 0;
            while(boo){
                if(fighters1[q] > fighters2[w]){
                    w++;
                    if(w+1 > army2){
                        win[l] = true;
                        l++;
                        boo = false;
                    }
                }
                if(fighters1[q] < fighters2[w]){
                    q++;
                    if(q+1 > army1){
                        win[l] = false;
                        l++;
                        boo = false;
                    }
                }
                if(fighters1[q] == fighters2[w]){
                    w++;
                    if(w+1 > army2){
                        win[l] = true;
                        l++;
                        boo = false;
                    }
                }
            }
        }
        for(int b = 0; b<tmp; b++){
            if(win[b]){
                System.out.println("Godzilla");
            }else{
                System.out.println("MechaGodzilla");
            }
        }
    }
}