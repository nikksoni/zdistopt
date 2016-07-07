package sorting;

public class KthElement2SortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 5, 7, 9, 11, 13, 15 };
        int[] arr2 = new int[] { 2, 8, 14, 18 };

        int k = 4;
        System.out.println(kthElement(0, 0, arr1.length, arr2.length, arr1, arr2, k, k));
//        int i1 = arr1.length * k / (arr1.length + arr2.length);
//        int i2 = k - i1;
//        if (arr1[i1] > arr2[i2]) {
//
//        } else if (arr1[i1] < arr2[i2]) {
//
//        } else {
//            System.out.println(arr1[i1]);
//        }
    }

    private static int kthElement(int s1, int s2, int e1, int e2, int[] arr1, int arr2[], int k, int factor) {
        if (factor > 1) {
            int i1 = (e1 + 1 - s1) * factor / (e1 + 2 - s1 + e2 - s2);
            int i2 = factor - i1;
            if (arr1[s1 + i1] > arr2[s2 + i2]) {
                factor = factor - i1;
                return kthElement(s1, i2, i1, e2, arr1, arr2, k, factor);
            } else if (arr1[s1 + i1] < arr2[s2 + i2]) {
                factor = factor - i2;
                return kthElement(i1, s2, e1, i2, arr1, arr2, k, factor);
            } else {
                return arr1[s1 + i1];
            }
        } else {
            if (s1 == e1) {
                return arr1[s1];
            } else {
                return arr2[s2];
            }
        }
        //        return 0;
    }
}
