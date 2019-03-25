import java.util.*;
import java.io.*;
import javafx.util.Pair;

public class fsList{
    private final LinkedList<Pair<Integer, Integer>>[] adjancenyList;

    public fsList(int vertices){
        adjancenyList = (LinkedList<Pair<Integer, Integer>>[]) new LinkedList[vertices];
        for(int j = 0; j < adjancenyList.length; j++){
            adjancenyList[j] = new LinkedList<>();
        }
    }

    public void addEdge(int x, int y, int w){
        adjancenyList[x].add(new Pair<>(y, w));
    }
}
    
class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < test; i++){
            int city = sc.nextInt();
            int pilot = sc.nextInt();
            sc.nextLine();
            fsList adjacencyList = new fsList(city);
            for(int j = 0; j < pilot; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                fsList.addEdge(x, y, 0);
            }
            System.out.println(city - 1);
        }
    }
}