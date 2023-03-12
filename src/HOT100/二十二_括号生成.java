package HOT100;

import java.util.ArrayList;
import java.util.List;

public class 二十二_括号生成 {
	public List<String> generateParenthesis(int n) {
		//结果集
		ArrayList<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		StringBuffer path = new StringBuffer();
		backTracing(res, path, n, n);
		return res;

	}

	private void backTracing(ArrayList<String> res, StringBuffer path, int left, int right) {
		if (left == 0 && right == 0) {
			res.add(path.toString());
			return;
		}
		if (left > right) {		//剪枝操作,如果左括号大于右括号数,要不然肯定不行,必须剪枝
			return;
		}
		if (left > 0) {		//回溯法核心代码
			backTracing(res,path.append("("),left-1,right);
			path.deleteCharAt(path.length() - 1);	//添加完别忘了回溯
		}
		if (right > 0) {
			backTracing(res, path.append(")"), left, right-1);
			path.deleteCharAt(path.length() - 1);
		}

	}
}
