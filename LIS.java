import java.util.*;
// Longest Increasing Subsequence Kattis
public class LIS{
    static int cases;
    static int max;
    static int max_end;
    static int count;
    static String index;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            cases = sc.nextInt();
            sc.nextLine();
            int [] array = new int [cases];
            for(int i = 0; i < cases; i++){
                array[i] = sc.nextInt();
            }
            max = 1;
            System.out.println(answer(array, cases));
        }
        sc.close();
    }

    static int answer(int [] array, int n){
        if (n == 1) return 1;
        count = 1;
        max_end =1;
        index = "";
        for(int i = 1; i < n; i++){
            count = answer(array, i);
            if(array[i-1] < array[n-1] && count + 1> max_end){
                System.out.print(i-1 + " ");
                max_end = count + 1;
            }
        }
        if(max_end > max){
            max = max_end;
        }
        return max_end;
    }
}