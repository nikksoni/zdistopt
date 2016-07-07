package discrete;

public class KnapSackProblem {
	// 16x1 +19x2 +23x3 +28x4
	// 2x1+3x2+4x3+5x4<=7
	public static void main(String[] args) {
		int[][] input = new int[][] { { 2, 16 }, { 3, 19 }, { 4, 23, }, { 5, 28 } };
		int[][] dArr = new int[5][8];
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 8; j++) {
				if ((j - input[i - 1][0]) < 0) {
					dArr[i][j] = dArr[i - 1][j];
				} else {
					// if(dArr[][]<(dArr[][j-input[i-1][0]]))
					if (dArr[i - 1][j] < (input[i - 1][1] + dArr[i - 1][j - input[i - 1][0]])) {
						dArr[i][j] = input[i - 1][1] + dArr[i - 1][j - input[i - 1][0]];
					} else {
						dArr[i][j] = dArr[i - 1][j - 1];
					}
				}
			}
		}
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(dArr[i][j] +"  ");
			}
			System.out.println();
		}
	}

}
