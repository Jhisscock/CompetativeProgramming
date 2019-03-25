import java.util.*;

public class train{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int stops = sc.nextInt();
        sc.nextLine();
        int current = 0;
        boolean possible = true;
        for(int i = 0; i < stops; i++){
            int left = sc.nextInt();
            int enter = sc.nextInt();
            int stay = sc.nextInt();
            sc.nextLine();
            if(left > current){
                possible = false;
            }
            current = current - left + enter;
            if(current > capacity || current < 0 || (current != capacity && stay > 0) || (i == stops - 1 && (stay > 0 || enter > 0))){
                possible = false;
            }
        }
        if(current != 0){
            possible = false;
        }
        if(possible){
            System.out.println("possible");
        } else{
            System.out.println("impossible");
        }
    }
}