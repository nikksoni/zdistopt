import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KitchenSource3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String s = scan.nextLine();
			String[] input = s.split(" ");
			String w = input[0];
			int k = Integer.parseInt(input[1]);
			int[] arr = new int[26];
			int counter = 0;
			for (int j = 0; j < w.length(); j++) {
				arr[w.charAt(j) - 'a']++;
			}
			List<Integer> sortedList = new ArrayList<Integer>();
			for (int l = 0; l < 26; l++) {
				if (arr[l] > 0) {
					sortedList.add(arr[l]);
				}
			}
			Collections.sort(sortedList);
			int pos = 0;
			for (int p = 1; p < sortedList.size(); p++) {
				int num = sortedList.get(p) - sortedList.get(pos) - k;
				if (num > 0) {
					if (sortedList.get(pos) <= num) {
						counter += pos;
						pos++;
					} else {
						counter += num;
					}
				}
			}
			System.out.println(counter);

		}

	}

}
