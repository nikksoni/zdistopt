package topcoder;

import java.util.Scanner;

public class BearCircleGameDPAAP2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        winProbability(n, k);

    }

    public static int winProbability(int n, int k) {

        double[][] ddpArray = new double[2][n]; //1- dpN  2- position- 3-k

        populateDpArray(ddpArray, n, k);
        System.out.println((ddpArray[(n - 1) % 2][0]));
        return 0;
    }

    private static void populateDpArray(double[][] dpArray, int n, int k) {

        //1- dpN  2- position- 3-k
        if (k % 2 == 1) {
            dpArray[1][0] = ((double) 1 / 3);
            dpArray[1][1] = ((double) 2 / 3);
        } else {
            dpArray[1][0] = 1;
            dpArray[1][1] = 0;
        }

        for (int dpn = 2; dpn < n; dpn++) {
            for (int pos = 1; pos <= dpn; pos++) {
                int nextPos = (k - 1 + pos) % dpn;
                dpArray[dpn % 2][pos] = dpArray[(dpn - 1) % 2][nextPos] * .5;
            }
            for (int pos = 0; pos <= dpn; pos++) {
                //                int prevPos = (k + pos) % (dpn + 1);
                //                int p2 = (k + prevPos) % (dpn + 1);
                //                dpArray[dpn % 2][pos] += dpArray[dpn % 2][prevPos] * .5 + dpArray[dpn % 2][p2] * .25;
                int factor = 0;
                double mfactor = 1.0;
                int kk = 1;
                int prevPos = pos;
                while (factor <= 50) {
                    mfactor /= 2;
                    if (kk == 1 && pos == 0 && dpn == k - 1) {
                        prevPos = (k - 1 + prevPos) % (dpn + 1);
                        kk++;
                    } else {
                        prevPos = (k + prevPos) % (dpn + 1);
                    }

                    //                    if(prevPos!=0){
                    dpArray[dpn % 2][pos] += dpArray[dpn % 2][prevPos] * mfactor;
                    //                    }
                    factor++;
                    //                    p=prevPos;
                }
                //                dpArray[dpn % 2][pos] += dpArray[dpn % 2][prevPos] * .5 + dpArray[dpn % 2][p2] * .25;
            }
            for (int pos = 0; pos <= dpn; pos++) {
                dpArray[(dpn + 1) % 2][pos] = 0.0;
            }
            System.out.println("hello");
        }
    }

}
