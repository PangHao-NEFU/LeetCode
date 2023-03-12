package 剑指Offer.Easy.二十九_顺时针打印矩阵;

public class Solution {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0){
			return new int[0];
		}
		int[] res = new int[matrix[0].length * matrix.length];
		int l = 0, b = matrix.length - 1,r = matrix[0].length-1,t = 0;	//l记录左边界,r记录右边界,t记录上边界,b记录下边界
		int num = matrix[0].length * matrix.length;	//矩阵一共有多少元素
		int k = 0;	//记录当前添加了多少个元素了
		while (k<num){

			for (int i = l; i <= r & k < num; i++) {	//从左到右横向添加元素
				res[k] = matrix[t][i];
				k++;
			}
			t++;										//上边界向下移动一位,即加一


			for (int i = t; i <= b & k < num; i++) {	//从上到下纵向添加元素
				res[k] = (matrix[i][r]);
				k++;
			}
			r--;										//添加后右边界左移,即减一


			for (int i = r; i >= l & k < num; i--) {	//从右向左添加元素
				res[k] = (matrix[b][i]);
				k++;
			}
			b--;										//完成后下边界上移,即减一


			for (int i = b; i >= t & k < num; i--) {	//从下到上纵向添加元素,从下边界到上边界
				res[k] = (matrix[i][l]);
				k++;
			}
			l++;										//结束后左边界右移一位,即加一
		}
		return res;

	}
}
