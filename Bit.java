import java.util.*;

public class Bit{
    public static boolean [] array;
    public static int num;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        boolean tmp;
        for(int i = 0; i < test; i++){
            num =  sc.nextInt();
            int state = sc.nextInt();
            sc.nextLine();
            array = new boolean[num];
            tmp = true;
            for(int j = 0; j < state; j++){
                Check(0);
            }
            for(int j = 0; j < num; j++){
                if(!array[j]){
                    tmp = false;
                    break;
                }
            }
            if(!tmp){
                System.out.println("Case #" + (i+1) + ": OFF");
            }else{
                System.out.println("Case #" + (i+1) + ": ON");
            }
        }
    }

    public static int Check(int x){
        if(x == num){
            array = new boolean[num];
            return 0;
        }else if(!array[x]){
            array[x] = !array[x];
            return 0;
        }else{
            array[x] = !array[x];
            return Check(x+1);
        }
    }
}