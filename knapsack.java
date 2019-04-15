import java.util.*;

public class knapsack{
    static int [] index;
    static int count;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String [] tmp = sc.nextLine().split(" ");
            double capacity = Double.parseDouble(tmp[0]);
            int items = Integer.parseInt(tmp[1]);
            int [] value = new int[items];
            int [] weight = new int[items];
            index = new int[items];
            count = 0;
            for(int i = 0; i < items; i++){
                String [] tmp2 = sc.nextLine().split(" ");
                value[i] = Integer.parseInt(tmp2[0]);
                weight[i] = Integer.parseInt(tmp2[1]);
            }
            System.out.println(answer(capacity, items, value, weight));
            for(int i = 0; i < items; i++){
                System.out.print(index[i] + " ");
            }
        }
    }

    static int answer(double capacity, int items ,int [] value, int [] weight){
        int [][] array = new int[items+1][(int)(capacity+1)];
        boolean [][] checked = new boolean[items+1][(int)(capacity)+1];
        for(int i = 1; i <= items; i++){
            for(int j = 0; j <= capacity; j++){
                array[i][j] = array[i - 1][j];
                if(weight[i - 1] <= j){
                    if(value[i-1] + array[i - 1][j - weight[i-1]] > array[i-1][j]){
                        array[i][j] = value[i-1] + array[i - 1][j - weight[i-1]];
                        checked[i][j] = true;
                    }
                }else{
                    array[i][j] = array[i-1][j];
                }
            }
        }
        int tmp = (int)capacity;
        for(int i = items-1; i >= 0; i--){
            if(checked[i][tmp]){
                index[i] = i;
                tmp -= weight[i];
            }
        }
        return array[items][(int)capacity];
    }
}