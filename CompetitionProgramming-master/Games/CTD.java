import java.util.*;

public class CTD{
    static char [][] board = new char[101][101];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [][] position = new int[65][2];
        int count = 0;
        while(true){
            String line = sc.nextLine();
            int column = line.length();
            int row = 0;
            int dots = 0;
            do{
                for(int i = 0; i<column; i++){
                    board[row][i] = line.charAt(i);
                    if(board[row][i] != '.'){
                        char dot = board[row][i];
                        int index;

                        if((int) dot < 60){
                            index = (int) dot - 48;
                        }else{
                            if(Character.isUpperCase(dot)){
                                index = ((int)dot -65) + 36;
                            }else{
                                index = ((int) dot - 97) + 10;
                            }
                        }
                        position[index][0] = row;
                        position[index][1] = i;
                        dots++;
                    }
                }
                row++;
                line = sc.nextLine();
                if(line == null || line.equals("")){
                    break;
                }
            }while(true);
            if(count++ > 0){
                System.out.println();
            }
            for(int j = 0; j < dots - 1; j++){
                int dRow = position[j][0];
                int dColumn = position[j][1];
                int nextDR = position[j+1][0];
                int nextDC = position[j+1][1];

                if(dRow == nextDR){
                    if(dColumn < nextDC){
                        for(int i = dColumn + 1; i < nextDC; i++){
                            Draw(dRow, i, '-');
                        }
                    }else{
                        for(int i = dColumn - 1; i > nextDC; i--){
                            Draw(dRow, i, '-');
                        }
                    }
                }else{
                    if(dRow < nextDR){
                        for(int i = dRow + 1; i < nextDR; i++){
                            Draw(i, dColumn, '|');
                        }
                    }else{
                        for(int i = dRow - 1; i > nextDR; i--){
                            Draw(i, dColumn, '|');
                        }
                    }
                }
            }
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            if(line == null){
                break;
            }
        }
    }

    static void Draw(int row, int column, char line){
        if(board[row][column] == '.'){
            board[row][column] = line;
        }else if(board[row][column] == '-' || board[row][column] == '|'){
            if(board[row][column] != line){
                board[row][column] = '+';
            }
        }
    }
}