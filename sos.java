import java.util.*;

public class sos{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int test = sc.nextInt();
            sc.nextLine();
            if(test == 0){
                break;
            }
            String [] names = new String [test];
            for(int i = 0; i < test; i++){
                names[i] = sc.nextLine();
            }
            for(int i = 0; i < test-1; i++){
                int min = i;
                for(int j = i+1; j < test; j++){
                    if((int)names[j].charAt(0) < (int)names[min].charAt(0)){
                        min = j;
                    }else if((int)names[j].charAt(0) == (int)names[min].charAt(0) && (int)names[j].charAt(1) < (int)names[min].charAt(1)){
                        min = j;
                    }
                }
                String key = names[min];
                while(min > i){
                    names[min] = names[min - 1];
                    min--;
                }
                names[i] = key;
            }
            for(int i = 0; i < test; i++){
                System.out.println(names[i]);
            }
            System.out.println();
        }
    }
}