package topcoder;

import java.util.Scanner;

public class OneBearStandProbability {
    private static final double IGNORE_VALUE = 0.0000000000000000001;
    private static double       sum          = 0.0;
    private static long         currentTime  = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        boolean[] bearArray = new boolean[n];
        currentTime = System.nanoTime();
        findProbablity(bearArray, n, (k - 1) % n, 1, k, n, 0);
        System.out.println((long)(sum));

    }

    private static void findProbablity(boolean[] bearArray, int sizeLeft, int index, double value, int k, int n, int depth) {
        if (value >= IGNORE_VALUE) {
            if (sizeLeft > 1) {
                int nextNum = (index + 1) % n;
                while (bearArray[nextNum % n]) {
                    nextNum++;
                }
                nextNum = nextNum % n;
                int finalIndex = nextNum;
                if (index != 0) {
                    bearArray[index] = true;
                    int bearOutIndex = ((k - 1) % (sizeLeft - 1));
                    for (int i = 0; i < bearOutIndex;) {
                        finalIndex++;
                        if (!bearArray[(finalIndex) % n]) {
                            i++;
                        }

                    }
                    finalIndex = finalIndex % n;
                    if (System.nanoTime() - currentTime <= 300000000000L){
                        findProbablity(bearArray, sizeLeft - 1, finalIndex, 0.5 * value, k, n, depth+1);
                    }
                    bearArray[index] = false;
                }
                finalIndex = nextNum;
                int bearSurviveIndex = ((k - 1) % sizeLeft);
                for (int i = 0; i < bearSurviveIndex;) {
                    finalIndex++;
                    if (!bearArray[(finalIndex) % n]) {
                        i++;
                    }
                }
                finalIndex = finalIndex % n;
                if (System.nanoTime() - currentTime <= 300000000000L){
                    findProbablity(bearArray, sizeLeft, finalIndex, 0.5 * value, k, n, depth+1);
                }
            } else {
                sum += value;
//                System.out.println("CDepth: "+depth);
//                printArr(bearArray);
            }
        } /*else{
            System.out.println("Depth: "+depth);
            printArr(bearArray);
        }*/
    }
 /*   private static void printArr(boolean[] bear){
        for(boolean b:bear){
            if(b){
                System.out.print("t,");
            }else{
                System.out.print("f,");
            }
        }
        System.out.println();
    }*/

    
    public static int winProbability(int n, int k) {
        boolean[] bearOutArray = new boolean[n];
        findProbablity(bearOutArray, n, (k - 1) % n, 1, k, n, 0);
        return 0;
    }
    
}
