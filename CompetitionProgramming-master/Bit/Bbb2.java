import java.math.BigInteger;
import java.util.*;

public class Bbb2{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int test = sc.nextInt();
            sc.nextLine();
            if(test == 0){
                break;
            }
            int answer = 0;
            int [] checked = new int[test];
            int [] try2 = new int[32];
            boolean [] pass = new boolean [32];
            for(int i = 0; i < test; i++){
                checked[i] = -1;
            }
            for(int i = 0; i < test; i++){
                String tmp = sc.nextLine();
                String [] tmp2 = tmp.split("\\s+");
                String word = tmp2[0];
                int bit = 0;
                int n = 0;
                if(tmp2.length == 2){
                    n = Integer.parseInt(tmp2[1]);
                }else{
                    n = Integer.parseInt(tmp2[1]);
                    bit = Integer.parseInt(tmp2[2]);
                }
                if(word.equals("SET")){
                    answer = (answer | (1 << n));
                }else if(word.equals("CLEAR")){
                    answer = (answer & ~(1 << n));
                    pass[31-n] = true;
                }else if(word.equals("AND")){
                    for(int j = 0; j < test; j++){
                        if(checked[j] == n){
                            pass[31-n] = true;
                            break;
                        }
                    }
                    if(pass[31-n]){
                        answer = answer & (1 >> n) >> n;
                    }
                }else if(word.equals("OR")){
                    for(int j = 0; j < test; j++){
                        if(checked[j] == n){
                            pass[31-n] = true;
                            break;
                        }
                    }
                    if(pass[31-n]){
                        answer |= (1 << n);
                    }
                }
                checked[i] = n;
            }
            String end = String.format("%032d", new BigInteger(Integer.toBinaryString(answer)));
            String [] end2 = end.split("");
            for(int i = 0; i < 32; i++){
                if(!pass[i]){
                    end2[i] = "?";
                }
                System.out.print(end2[i]);
            }
            System.out.println();
        }
    }
}