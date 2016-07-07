package chef;

import java.util.Scanner;

public class ArrayIJ {
	private static final int LIMIT=1000000007;

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int tc=scan.nextInt();
		for(int i=0;i<tc;i++){
			int n=scan.nextInt();
			int m=scan.nextInt();
			int x=scan.nextInt();
			int y=scan.nextInt();
			int [] input=new int[n];
			for(int j=0;j<n;j++){
				input[j]=scan.nextInt();
			}
			int[] sum =populateSum(input,x-1,y-1,m);
			System.out.println(sum[2]);
		}
		scan.close();
	}

	private static int[] populateSum(int[] input, int x, int y, int m) {
		if(m==0){
			int[] arr= new int[5];
			arr[0]=input[x];
			arr[1]=input[x+1];
			arr[3]=input[y-1];
			arr[4]=input[y];
			int sum=0;
			for(int i=x;i<=y;i++){
				sum+=input[i];
				sum%=LIMIT;
			}
			arr[2]=sum;
			return arr;
		}
		if (x % 2 == 0 && y % 2 == 0) {
			int [] arr=populateSum(input, x/2, y/2, m-1);
			arr[2]=(3*arr[2] -arr[0]-arr[4])%LIMIT;
			arr[1]+=arr[0];
			arr[3]+=arr[4];
			return arr;
		} else if (x % 2 == 0 && y % 2 != 0) {
			int [] arr=populateSum(input, x/2, (y+1)/2, m-1);
			arr[2]=(3*arr[2] -arr[0]-2*arr[4])%LIMIT;
			arr[1]+=arr[0];
			arr[4]+=arr[3];
			return arr;
			
		} else if (x % 2 != 0 && y % 2 == 0) {
			int [] arr=populateSum(input, (x-1)/2, y/2, m-1);
			arr[2]=(3*arr[2] -2*arr[0]-arr[4])%LIMIT;
			arr[0]+=arr[1];
			arr[3]+=arr[4];
			return arr;
		} else {

			int [] arr=populateSum(input, (x-1)/2, (y+1)/2, m-1);
			arr[2]=(3*arr[2] -2*arr[0]-2*arr[4])%LIMIT;
			arr[0]+=arr[1];
			arr[4]+=arr[3];
			return arr;
		}
	}
}
