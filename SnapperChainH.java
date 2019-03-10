/*
First you take the number of test cases and create a loop that will loop equal to the number of test cases. 
Then inside the loop the first thing you do is take the case and state inputs saved as num and state respectively.
Next comes the actaul worrk, we have a statement that takes what ever the case is and modifies the bits to equal zero in whatever place
is equal to the case number so it at the farthest point left in the bit string. Then it makes the rest of the bit string equal to one. 
For example say if we had 4 (0100) we would change it to 1000 and then subatract 1 so it would be 0111. 
We do this because this is equivalent to the state of a light being on because the state of being on's bit string always ends in two ones. 
The next thing we do is compare state and the modified bit string that equals on with the and bit operator.
We do this to comapre the end of the bit string to see if it's equivalent to the state of being on and if so it modifies the bit string to be
equal to count. Finally we compare count and bit and if they are equal that means the light is on if not then it prints off.
*/

import java.util.*;

public class SnapperChainH{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        int count;
        int bit;
        for(int i = 0; i < test; i++){
            int num = sc.nextInt();
            int state = sc.nextInt();
            sc.nextLine();
            bit = (1 << num) - 1;
            count = (state & bit);
            if(bit != count){
                System.out.println("Case #" + (i+1) + ": OFF");
            }else{
                System.out.println("Case #" + (i+1) + ": ON");
            }
        }
    }
}