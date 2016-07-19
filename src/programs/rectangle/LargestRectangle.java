package programs.rectangle;

import java.util.Scanner;

public class LargestRectangle {
	public static void main(String[] args) {
		//Scanner scan=new Scanner(System.in);
		int [][]inputArray={{1,1,1,1,0,1},{1,1,1,1,0,1},{1,1,1,1,0,1},{1,1,1,1,0,1},{1,1,1,1,0,1},{1,1,1,1,0,1}};
		int [][] horizontalArray=populateHorizontal(inputArray);
		int [][] verticalArray=populateVertical(inputArray);
	}
	
	
	private static int[][] populateHorizontal(int [][]inputArray){
		int row=inputArray.length;
		int column=inputArray[0].length;
		int [][] horizontalArray=new int [row][column];
		for(int i=0;i<row;i++){
			horizontalArray[i][0]=inputArray[i][0];
			for(int j=1;j<column;j++){
				if(inputArray[i][j]==1){
					horizontalArray[i][j]=horizontalArray[i][j-1]+1;
				}
			}
		}
		return horizontalArray;
	}

	private static int[][] populateVertical(int [][]inputArray){
		int row=inputArray.length;
		int column=inputArray[0].length;
		int [][] verticalArray=new int [row][column];
		for(int i=0;i<column;i++){
			verticalArray[0][i]=inputArray[0][i];
			for(int j=1;j<row;j++){
				if(inputArray[j][i]==1){
					verticalArray[j][i]=verticalArray[j-1][i]+1;
				}
			}
		}
		return verticalArray;
	}
}
