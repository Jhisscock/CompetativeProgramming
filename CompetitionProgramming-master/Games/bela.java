import java.util.*;

public class bela{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] tmp = sc.nextLine().split("\\s+");
        int hand = Integer.parseInt(tmp[0]);
        char suit = tmp[1].charAt(0);
        int total = 0;
        for(int i = 0; i < 4*hand; i++){
            String tmp2 = sc.nextLine();
            if(tmp2.charAt(0) == 'A'){
                total = total + 11;
            }
            if(tmp2.charAt(0) == 'K'){
                total = total + 4;
            }
            if(tmp2.charAt(0) == 'Q'){
                total = total + 3;
            }
            if(tmp2.charAt(0) == 'J' && tmp2.charAt(1) == suit){
                total = total + 20;
            }else if(tmp2.charAt(0) == 'J'){
                total = total + 2;
            }
            if(tmp2.charAt(0) == 'T'){
                total = total + 10;
            }
            if(tmp2.charAt(0) == '9' && tmp2.charAt(1) == suit){
                total = total + 14;
            }
        }
        System.out.println(total);
    }
}