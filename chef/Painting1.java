package chef;

import java.util.Scanner;

public class Painting1 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int tc=scan.nextInt();
		for(int i=0;i<tc;i++){
			int n=scan.nextInt();
			int [] arr=new int[]{-1,-1,-1};
			boolean possible=false;
			for(int j=0;j<n;j++){
				arr[j%3]=scan.nextInt();
				if(arr[0]==arr[1] && arr[1]==arr[2] && arr[0]!=-1){
					possible=true;
				}
			}
			if(possible){
				System.out.println("Yes");
			} else{
				System.out.println("No");
			}
		}
		scan.close();
	}

}
