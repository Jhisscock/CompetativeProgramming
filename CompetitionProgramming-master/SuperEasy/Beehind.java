import java.util.Scanner;
import java.util.Arrays;

public class Beehind{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [] swt = new int[15];
        int [] sour = new int[15];
        String [] line = new String[15];
        int i = 0;
        int j = 0;
        String [] result = new String[15];
        while(true && i <= 15){
            line[i] = sc.nextLine();
            if(line[i].equals("0 0")){
                break;
            }
            String [] tmp = line[i].split("\\s+");
            swt[i] = Integer.parseInt(tmp[0]);
            sour[i] = Integer.parseInt(tmp[1]);
            if(swt[i] + sour[i] == 13){
                result[i] = "Never speak again.";
            }else if(swt[i] > sour[i] ){
                result[i] = "To the convention.";
            }else if(swt[i] < sour[i]){
                result[i] = "Left beehind.";
            }else if(swt[i] + sour[i] == 13){
                result[i] = "Never speak again.";
            }else{
                result[i] = "Undecided.";
            }
            i++;
        }
        while(true){
            System.out.println(result[j]);
            j++;
            if(result[j] == null){
                break;
            }
        }
    }
}