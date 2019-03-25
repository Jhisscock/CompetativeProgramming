import java.util.*;

public class busyschedule{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int test = sc.nextInt();
            if(test == 0){
                break;
            }
            sc.nextLine();
            int [] sorted = new int[test];
            int count = 0;
            int count1 = 0;
            for(int i = 0; i<test; i++){
                String tmp = sc.nextLine();
                String [] tmp2 = tmp.split("\\s+");
                String [] tmp3 = tmp2[0].split(":");
                int hours = Integer.parseInt(tmp3[0]);
                int minutes = Integer.parseInt(tmp3[1]);
                String tod = tmp2[1];
                if(hours == 12 && tod.equals("a.m.")){
                    sorted[i] = minutes;
                }else if(tod.equals("a.m.")){
                    sorted[i] = hours * 60 + minutes;
                }else if(tod.equals("p.m.") && hours != 12){
                    hours = 12 + hours;
                    sorted[i] = hours * 60 + minutes;
                }else{
                    sorted[i] = hours * 60 + minutes;
                }
            }
            Arrays.sort(sorted);
            for(int i = 0; i < test; i++){
                int finalH;
                int finalM;
                if(sorted[i] < 60){
                    finalH = 12;
                    finalM = sorted[i];
                    if(finalM == 0){
                        System.out.println(finalH + ":00 a.m.");
                    }else if(finalM < 10){
                        System.out.println(finalH + ":0" + finalM + " a.m.");
                    }else{
                        System.out.println(finalH + ":" + finalM + " a.m.");
                    }
                }else if(sorted[i] < 720){
                    finalH = sorted[i]/60;
                    finalM = sorted[i]%60;
                    if(finalM == 0){
                        System.out.println(finalH + ":00 a.m.");
                    }else if(finalM < 10){
                        System.out.println(finalH + ":0" + finalM + " a.m.");
                    }else{
                        System.out.println(finalH + ":" + finalM + " a.m.");
                    }
                }else if(sorted[i] >= 720 && sorted[i] < 780){
                    finalH = sorted[i]/60;
                    finalM = sorted[i]%60;
                    if(finalM == 0){
                        System.out.println(finalH + ":00 p.m.");
                    }else if(finalM < 10){
                        System.out.println(finalH + ":0" + finalM + " p.m.");
                    }else{
                        System.out.println(finalH + ":" + finalM + " p.m.");
                    }
                }else{
                    finalH = ((sorted[i] - sorted[i]%60)/60) - 12;
                    finalM = sorted[i]%60;
                    if(finalM == 0){
                        System.out.println(finalH + ":00 p.m.");
                    }else if(finalM < 10){
                        System.out.println(finalH + ":0" + finalM + " p.m.");
                    }else{
                        System.out.println(finalH + ":" + finalM + " p.m.");
                    }
                }
                System.out.println();
            }
        }
    }
}