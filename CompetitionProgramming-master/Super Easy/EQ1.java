import java.util.Scanner;
import java.util.Arrays;

public class EQ1{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        String [] array = new String[x];
        for(int i = 0; i < x; i++){
            String tmp = sc.nextLine();
            array[i] = tmp;
        }
        for(int i = 0; i < x; i++){
            String [] line = array[i].split("\\s+");
            String name = line[0];
            int pss = Integer.parseInt(line[1].substring(0,4));
            int birth = Integer.parseInt(line[2].substring(0,4));
            int courses = Integer.parseInt(line[3]);
            if(pss >=2010 || birth >=1991){
                System.out.println(name + " eligible");
            }else if(courses >= 41){
                System.out.println(name + " ineligible");
            }else{
                System.out.println(name + " coach petitions");
            }
        }
    }
}