package discrete;

public class SendMoreMoney {

	public static void main(String[] args) {
		String s1 = "SEND";
		String s2 = "MORE";
		String s3 = "MONEY";
		String finalStr = "SENDMORY";

		int[][] constraintSpace = new int[finalStr.length()][10];

		int[] cArr = new int[s1.length()];

	}

	
//	private static void populateConstraint(String s1, String s2, )
	
	
	private static void populateConstraintArray(int ini, int num, int row, int column, int[][] constraintArr) {
		populateHorizontal(ini, num, row, column, constraintArr);
		populateVertical(ini, num, row, column, constraintArr);
	}

	private static void populateVertical(int ini, int num, int row, int column, int[][] constraintArr) {
		for (int i = 0; i < constraintArr.length; i++) {
			if (constraintArr[i][column] == ini || constraintArr[i][column] == -ini) {
				if (i != row) {
					constraintArr[i][column] = num;
				} else {
					constraintArr[i][column] = -num;
				}

			}
		}
	}

	private static void populateHorizontal(int ini, int num, int row, int column, int[][] constraintArr) {
		for (int i = 0; i < constraintArr[0].length; i++) {
			if (constraintArr[row][i] == ini || constraintArr[row][i] == -ini) {
				if (i != column) {
					constraintArr[row][i] = num;
				} else {
					constraintArr[row][i] = -num;
				}

			}
		}
	}

	private static void populateHorRestriction(int ini, int num, int last, int toRep, int row, int column,
			int[][] constraintArr) {
		for (int i = ini; i < last; i++) {
			if (constraintArr[row][i] == num) {
				constraintArr[row][i] = 10;

			}
		}

	}

}
