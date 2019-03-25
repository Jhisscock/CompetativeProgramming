import java.util.*;

public class chess{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        int [][] board;
        for(int i = 0; i < test; i++){
            board = new int[8][8];
            char column1 = sc.next().charAt(0);
            int row1 = sc.nextInt();
            char column2 = sc.next().charAt(0);
            int row2 = sc.nextInt();
            if(column1 == column2 && row1 == row2){
                System.out.println("0 " + column1 + " " + row1);
            }
        }
    }
}