import java.util.Scanner;

public class KitchenSource1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) {
			int ni = scan.nextInt();
			int count = 0;
			if (ni > 0) {
				int[] input = new int[ni];
				if (scan.hasNext()) {
					for (int j = 0; j < ni; j++) {
						input[j] = scan.nextInt();
					}
				}
				if (scan.hasNext()) {
					if(scan.nextInt()<=input[0]){count++;}
					for (int k = 1; k < ni; k++) {
						if (scan.nextInt() <= (input[k]-input[k-1])) {
							count++;
						}
					}
				}
				System.out.println(count);
			} else {
				System.out.println(0);
			}
		}
	}
}
