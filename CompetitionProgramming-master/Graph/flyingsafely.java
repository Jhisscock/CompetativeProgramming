import java.util.*;

public class flyingsafely{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        boolean [][] array;
        boolean [] checked;
        int row;
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < test; i++){
            int count = -1;
            int tmp = 1;
            int city = sc.nextInt();
            int pilot = sc.nextInt();
            sc.nextLine();
            array = new boolean[city+1][city+1];
            checked = new boolean[city+1];
            row = tmp;
            for(int j = 0; j < pilot; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                array[x][y] = true;
                array[y][x] = true;
            }
            int thing = 0;
            while(thing != city){
                for(int j = 1; j < city+1; j++){
                    if(!checked[j] && array[row][j]){
                        count++;
                        checked[j] = true;
                        tmp = j;
                    }
                }
                int tmp2 = 0;
                for(int j = 1; j < city+1; j++){
                    if(checked[j]){
                        tmp2++;
                    }
                }
                thing = tmp2;
                row = tmp;
            }
            System.out.println(count);
        }
    }
}