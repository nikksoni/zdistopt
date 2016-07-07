package topcoder;

import java.util.Scanner;

public class FirstBearStandProbablity {
    private static final double IGNORE_VALUE = 0.00000001;
    private static double       sum          = 0.0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        boolean[] bearArray = new boolean[n];
        Node lc = new Node();
        lc.setValue(bearArray, 1, 0);
        findProbablity(bearArray, n, (k - 1) % n, 1, k, n, 0, lc);
        System.out.println(sum);
        System.out.println(lc.printStr(lc, "Root"));

    }

    private static void findProbablity(boolean[] bearArray, int sizeLeft, int index, double value, int k, int n, int depth, Node node) {
        if (depth <= 10) {
            if (sizeLeft > 1) {
                //                System.out.println("NR" + bearArray[0] + bearArray[1] + bearArray[2] + "index" + index + "value" + value);
                int nextNum = (index + 1) % n;
                while (bearArray[nextNum % n]) {
//                    System.out.println("f");
                    nextNum++;
                }
                nextNum = nextNum % n;
                int finalIndex = nextNum;
                int bearSurviveIndex = ((k - 1) % sizeLeft) ;
                for (int i = 0; i < bearSurviveIndex;) {
                    finalIndex++;
                    if (!bearArray[(finalIndex) % n]) {
                        i++;
                    }
                    //                    System.out.println("fw");
                   
                }
                finalIndex = finalIndex % n;
                Node lc = new Node();
                lc.setValue(bearArray, 0.5 * value, index);
                node.setLeft(lc);
                findProbablity(bearArray, sizeLeft, finalIndex, 0.5 * value, k, n, depth + 1, lc);
                if (index != 0) {
                    bearArray[index] = true;
//                    System.out.println();
                    finalIndex = nextNum;
                    //          System.out.println("R" + bearArray[0] + bearArray[1] + bearArray[2] + "index" + index + "value" + value);
                    int bearOutIndex = ((k - 1) % (sizeLeft - 1)) ;
                    for (int i = 0; i < bearOutIndex;) {
                        finalIndex++;
                        if (!bearArray[( finalIndex) % n]) {
                            i++;
                        }
//                        System.out.println("fe");
                        
                    }
                    finalIndex = finalIndex % n;
                    Node rc = new Node();
                    rc.setValue(bearArray, 0.5 * value, index);
                    node.setRight(rc);
                    findProbablity(bearArray, sizeLeft - 1, finalIndex, 0.5 * value, k, n, depth + 1, rc);
                    bearArray[index] = false;
                }
            } else {
                //                System.out.println("SIZE" + bearArray[0] + bearArray[1] + bearArray[2] + "index" + index + "value" + value + "sum " + sum);
                sum += value;
            }
        } /*else {
            //            System.out.println("LIMIT" + bearArray[0] + bearArray[1] + bearArray[2] + "index" + index + "value" + value + "sum " + sum);
            sum += value;
        }*/
    }

    static class Node {
        private Node   left;
        private Node   right;
        private String value;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setValue(boolean[] arr, double value, int index) {
            StringBuilder valueBuilder = new StringBuilder();
            for (boolean b : arr) {
                if (b) {
                    valueBuilder.append("t,");
                } else {
                    valueBuilder.append("f,");
                }
            }
            valueBuilder.append(" index ").append(index).append("value");
            valueBuilder.append(value);
            this.value = valueBuilder.toString();
        }

        public String printStr(Node n, String dis) {
            if (n != null) {
                return "\"" + dis + "value\": \"" + n.getValue() + "\", \"child\":[{" + printStr(n.getLeft(), "left") + "},{" + printStr(n.getRight(), "right") + "}]";
            } else {
                return "";
            }
        }

    }

}
