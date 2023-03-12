package HOT100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*排列与组合问题,棋盘问题,子集问题,首选回溯法(backtracking),回溯法的递归深度就是组合元素的位数,搜索树的宽度是由元素宽度组成
	比如本题的电话号,输入23,搜索深度就是2层,搜索宽度是3*3,因为2对应"abc"有三位,3也是对应"def"也是三位*/
/*回溯法的基本结构为,递归函数里有个for循环,在for循环里调用递归函数
	function backtracking(){
		if(搜索到结尾,叶子结点或者中间节点){
			//终止条件,经常也是收集结果元素的时候
		}
		for(){		//在for循环的判断条件上做剪枝操作,至多从n-(k-pathsize())+1开始
			path.push()
			backtracking()
			path.pop()
		}
	}
* 回溯法的三部曲:
* 	1.确定参数与返回值	,一般来说所需的参数有:一个存储结果的容器,元素长度(大小)n,组合结果的位数k,开始标记startindex
* 	2.确定终止条件	一般来说,不是求子集的问题,都是在叶子结点收集结果,也就是递归结束时收集
* 	3.分析单层递归逻辑*/

/*本题解法思路:
* 	首先需要一个结果收集器,一个全局的arrlist<string> result
* 	递归函数的参数:digits:传入的数字组合;
* 				index:表示现在搜索到digits哪一位了,当index==digits.size的时候,也就搜索到头了
* 				result:结果收集器
* 				StringBuffer或者String来充当组装结果的工具,然后将其添加进到result中
* */
public class 十七_电话号码字母组合 {
	public List<String> letterCombinations(String digits) {

		ArrayList<String> container = new ArrayList<>();
		if (digits.equals("")) {
			return container;
		}
		HashMap<Integer, String> letterMap = new HashMap<>();
		letterMap.put(2, "abc");
		letterMap.put(3, "def");
		letterMap.put(4, "ghi");
		letterMap.put(5, "jkl");
		letterMap.put(6, "mno");
		letterMap.put(7, "pqrs");
		letterMap.put(8, "tuv");
		letterMap.put(9, "wxyz");
		StringBuffer sb = new StringBuffer();
		//回溯函数
		backTracing(container, letterMap, digits, 0, sb);

		return container;
	}

	public void backTracing(List<String> container,HashMap<Integer, String> letterMap, String digits, Integer index, StringBuffer sb) {
		//终止条件为叶子结点
		if (index == digits.length()) {
			container.add(sb.toString());	//这里一定记住千万不要直接把path变量丢到结果收集器里,否则会因为浅拷贝而出问题
			return;
		}
		int digit = digits.charAt(index) - '0';
		String targetString = letterMap.get(digit);
		for (int i = 0; i < targetString.length(); i++) {
			sb.append(targetString.charAt(i));
			backTracing(container, letterMap, digits, index+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
