import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KitchenSource2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String s = scan.nextLine();
			int ni=Integer.parseInt(s);
			String inputStr=scan.nextLine();
			String[] input = s.split(" ");
			int array[]=new int[ni];
			int sumArr[]=new int[ni];
			int mini=0;
			int maxi=0;
			int min=0;
			int max=0;
			
			for(int j=1;j<ni;j++){
				array[j]=Integer.parseInt(input[j]);
				sumArr[j]=sumArr[j-1]+array[j];
			}
			
			
			
			
			
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
