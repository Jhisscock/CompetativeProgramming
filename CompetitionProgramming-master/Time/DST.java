import java.util.*;

public class DST{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < test; i++){
            String tmp = sc.nextLine();
            String [] tmp2 = tmp.split("\\s+");
            char bf = tmp2[0].charAt(0);
            int change = Integer.parseInt(tmp2[1]);
            int hour = Integer.parseInt(tmp2[2]);
            int min = Integer.parseInt(tmp2[3]);
            if(change <= 60){
                if (min - change < 0 && bf == 'B'){
                    if(hour == 0){
                        hour = 23;
                    }else{
                        hour -= 1;
                    }
                    min = 60 - change + min;
                }
                else if (min + change >= 60 && bf == 'F'){
	                if(hour == 23){
                        hour = 0;
                    }else{
                        hour += 1;
                    }
                    min = change + min - 60;
                }
                else if (bf == 'F'){
                    min = change + min;
                }
                else{
                    min = min - change;
                }
            }else{
                if (change - min > 60 && bf == 'B'){
                    hour -= 2;
                    if(hour < 0){
                        hour = 24 + hour;
                    }
                    min = (120 - change) + min;
                }else if (change + min >= 120 && bf == 'F'){
                    hour += 2;
                    if(hour >= 24){
                        hour = hour - 24;
                    }
                    int tmp3 = (120 - change ) - min;
                    min = Math.abs(tmp3);
                }else if (bf == 'F'){
                    if(hour == 23){
                        hour = 0;
                    }else{
                        hour += 1;
                    }
                    min = change - 60 + min;
                }else{
                    if(hour == 0){
                        hour = 23;
                    }else{
                        hour -= 1;
                    }
                    min = 60 - (change - min);
                }
            }
            System.out.println(hour + " " + min);
        }
    }
}