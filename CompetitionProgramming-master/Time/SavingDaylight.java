import java.util.*;

public class SavingDaylight{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int minutes;
        while(sc.hasNextLine()){
            String tmp = sc.nextLine();
            String [] tmp2 = tmp.split("\\s+");
            String date = tmp2[0] + " " + tmp2[1] + " " + tmp2[2] + " ";
            String [] tmp3 = tmp2[3].split(":");
            String [] tmp4 = tmp2[4].split(":");
            int startH = Integer.parseInt(tmp3[0]);
            int startM = Integer.parseInt(tmp3[1]);
            int endH = Integer.parseInt(tmp4[0]);
            int endM = Integer.parseInt(tmp4[1]);
            int hours = endH - startH;
            if(endM - startM < 0){
                hours -= 1;
                minutes = 60 - (startM - endM);
            }else{
                minutes = endM - startM;
            }
            System.out.println(date + hours + " hours " + minutes + " minutes" );
        }
    }
}