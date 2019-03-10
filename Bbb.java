import java.math.BigInteger;
import java.util.*;

public class Bbb{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int test = sc.nextInt();
            sc.nextLine();
            if(test == 0){
                break;
            }
            int [] bit = new int[32];
            for(int i = 0; i < 32; i++){
                bit[i] = -32;
            }
            int bit1 = 0;
            boolean [] pass = new boolean[32];
            for(int i = 0; i < test; i++){
                String tmp = sc.nextLine();
                String [] tmp2 = tmp.split("\\s+");
                String word = tmp2[0];
                int n = 0;
                if(tmp2.length == 2){
                    n = Integer.parseInt(tmp2[1]);
                }else{
                    n = Integer.parseInt(tmp2[1]);
                    bit1 = Integer.parseInt(tmp2[2]);
                }
                if(word.equals("SET")){
                    bit[31-n] = (bit1 | (1 << n));
                    pass[31-n] = true;
                }else if(word.equals("CLEAR")){
                    bit[31-n] = (bit1  & ~(1 << n));
                    pass[31-n] = true;
                }else if(word.equals("AND")){
                    if((bit1  & (1 >> n)) >> n != 0 && (n & (1 >> bit1)) >> bit1 != 0){
                        bit[31-n] = 1;
                        pass[31-n] = true;
                    }else if((bit1 |(1 << n)) == 0 || (n |(1 << bit1)) == 0){
                        bit[31-n] = 0;
                        pass[31-n] = true;
                    }else{
                        pass[31-n] = false;
                    }
                }else if(word.equals("OR")){
                    if((bit1 |(1 << n)) != 0 || (n |(1 << bit1)) != 0){
                        bit[31-n] = 1;
                        pass[31-n] = true;
                    }else if((bit[31-n] == 0 && (bit[31-bit1] == 0))){
                        bit[31-n] = 0;
                        pass[31-n] = true;
                    }else{
                        pass[31-n] = false;
                    }
                }
            }
            for(int i = 0; i < 32; i++){
                if(bit[i] != 0){
                    bit[i] = 1;
                }
                if(pass[i]){
                    System.out.print(new BigInteger(Integer.toBinaryString(bit[i])));
                }else{
                    System.out.print("?");
                }
            }
            System.out.println();
        }
    }
}