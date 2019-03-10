import java.util.Scanner;
import java.util.Arrays;

public class scoring{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String txt;
        int min;
        String question;
        String answer;
        int num = 0;
        String wrong = "";
        int totalmin = 0;
        while(true){
            txt = sc.nextLine();
            if(txt.equals("-1")){
                break;
            }
            String [] spltxt = txt.split("\\s+");
            min = Integer.parseInt(spltxt[0]);
            question = spltxt[1];
            answer = spltxt[2];
            if(answer.equals("right")){
                num++;
                int count = 0;
                for(int i = 0; i < wrong.length(); i++){
                    if(wrong.charAt(i) == question.charAt(0)){
                        count++;
                    }
                }
                totalmin = min + 20*count + totalmin;
            } else{
                wrong = wrong + question;
            }
            if(num == 0){
                totalmin = 0;
            }
        }
        System.out.println(num + " " + totalmin);   
    }
}