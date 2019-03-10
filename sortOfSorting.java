import java.util.*;

public class sortOfSorting{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int test = sc.nextInt();
            sc.nextLine();
            if(test == 0){
                break;
            }
            String [] names = new String [test];
            for(int i = 0; i < test; i++){
                names[i] = sc.nextLine();
            }
            quickSort(names, 0, test - 1);
            for(int i = 0; i < test; i++){
                System.out.println(names[i]);
            }
            System.out.println();
        }
    }

    public static void quickSort(String array[], int start, int end){
        int i = start;
        int j = end;
        String pivot = array[start + (end - start)/2];

        while(i<=j){
            while((int)array[i].charAt(0) < (int)pivot.charAt(0)){
                i++;
            }
            while((int)array[j].charAt(0) > (int)pivot.charAt(0)){
                j--;
            }
            while((int)array[i].charAt(0) == (int)pivot.charAt(0) && ((int)array[i].charAt(1) < (int)pivot.charAt(1))){
                i++;
            }
            while((int)array[j].charAt(0) == (int)pivot.charAt(0) && ((int)array[j].charAt(1) > (int)pivot.charAt(1))){
                j--;
            }
            if(i <= j){
                String tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        if(start < j){
            quickSort(array, start, j);
        }
        if(i < end){
            quickSort(array, i, end);
        }
    }
}