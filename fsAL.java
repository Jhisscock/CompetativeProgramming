import java.util.*;
import java.lang.*;

public class fsAL{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < test; i++){
            int city = sc.nextInt();
            int pilot = sc.nextInt();
            sc.nextLine();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
            boolean checked[] = new boolean[city + 1];
            ArrayList<Integer>array = new ArrayList<>();
            int count = 0;
            for(int j = 0; j < pilot; j++){
                adjList.add(new ArrayList<Integer>());
            }
            for(int j = 0; j < pilot; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                adjList.get(j).add(x);
                adjList.get(j).add(y);
            }
            for(int j = 0; j < adjList.size(); j++){
                array = adjList.get(j);
                if(!checked[array.get(0)] || !checked[array.get(1)]){
                    checked[array.get(0)] = true;
                    checked[array.get(1)] = true;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}