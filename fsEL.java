import java.util.*;

public class fsEL{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < test; i++){
            int city = sc.nextInt();
            int pilot = sc.nextInt();
            sc.nextLine();
            List<Integer> edges = new ArrayList<Integer>();
            int count = -1;
            for(int j = 0; j < pilot; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                edges.add(x);
                edges.add(y);
            }
            boolean [] checked = new boolean[city+1];
            for(int j = 0; j < edges.size(); j++){
                if(!checked[edges.get(j)]){
                    checked[edges.get(j)] = true;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}