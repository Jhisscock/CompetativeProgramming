import java.util.Scanner;
import java.util.Arrays;

public class battle{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        char [] array = inp.toCharArray();
        for(int i = 0; i < array.length; i++){
            if(i + 2 < array.length && ((int)array[i] + (int)array[i + 1] + (int)array[i+2]) == 224){
                System.out.print("C");
                i += 2; 
            } else if((int)array[i] == 82){
                System.out.print("S");
            } else if((int)array[i] == 66){
                System.out.print("K");
            }else{
                System.out.print("H");
            }
        }
    }  
}