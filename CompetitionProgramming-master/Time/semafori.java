import java.util.*;

public class semafori{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int lights = sc.nextInt();
        int distance = sc.nextInt();
        sc.nextLine();
        int traveled = 0;
        int prevTL = 0;
        for(int i = 0; i<lights; i++){
            int toLight = sc.nextInt();
            int red = sc.nextInt();
            int green = sc.nextInt();
            sc.nextLine();
            if(i == 0){
                prevTL = toLight;
                traveled = toLight;
                if(traveled % (red+green) < red){
                    traveled = traveled + (red - traveled%(red+green));
                }
            }else{
                traveled = traveled + (toLight - prevTL);
                prevTL = toLight;
                if(traveled % (red+green) < red){
                    traveled = traveled + (red - traveled%(red+green));
                }
            }
            if(i == lights-1){
                traveled = traveled + (distance - toLight);
            }
        }
        System.out.println(traveled);
    }
}