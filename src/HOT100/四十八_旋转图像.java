package HOT100;

public class 四十八_旋转图像 {
	public void rotate(int[][] matrix) {
		//本题的公式为mat[row][col],旋转后的新位置是matnew[col][n-row-1]
		//即:matnew[col][n-row-1]=mat[row][col]
		//本题的一个讨巧办法是,先进行水平翻转,再进行主对角线翻转

		int n = matrix.length;
		// 水平翻转
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < n; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		// 主对角线翻转
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}
}
