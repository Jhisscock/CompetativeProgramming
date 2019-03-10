import java.util.*;


public class sidewaysSorting{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int test = sc.nextInt();
            int length = sc.nextInt();
            if(test == 0 && length == 0){
                break;
            }
            sc.nextLine();
            for(int i = 0; i < test; i++){
                String tmp = sc.nextLine();
                String [] array = new String[length];
                String last = "";
                for(int j = 0; j < length; j++){
                    array[j] = Character.toString(tmp.charAt(j));
                    if(j == 0){
                        last = array[j];
                    } else{
                    }
                }
            }
        }
    }
}