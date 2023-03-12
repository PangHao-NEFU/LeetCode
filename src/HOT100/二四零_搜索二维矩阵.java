package HOT100;

public class 二四零_搜索二维矩阵 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0, j = col - 1; i < row && j >= 0; i++, j--) {
			if (target <= matrix[i][j]) {    //如果小于副对角线的元素,就在其左边找,否则在其下边找,如果找不到就将副对角线元素向左下移动
				int left = 0;
				int right = j;
				while (left < right) {
					int mid = (left + right) >> 1;
					if (matrix[i][mid] >= target) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				if (matrix[i][right] == target) return true;
			} else {
				int top = i;
				int bottom = row-1;
				while (top < bottom) {
					int mid = (top + bottom) >> 1;
					if (matrix[mid][j] >= target) {
						bottom = mid;
					} else {
						top = mid + 1;
					}
				}
				if (matrix[bottom][j] == target) return true;
			}
		}

		return false;
	}
}
