package 剑指Offer.Easy.十七难_打印从1到最大的n位数;

public class Solution2 {
	//当考虑大整数时,要求返回一个String------递归,全排列
	StringBuilder res;
	int nine = 0;	//nine是生成字符数组中9的个数
	int start;//start是生成字符数组有效起始位,比如001,start就是2
	int n;	//n为输入的位数
	char[] num;	//num是每次全排列中生成的字符数组
	char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	public String printNumbers(int n) {
		this.n = n;
		res = new StringBuilder(); // 数字字符串集
		num = new char[n]; // 定义长度为 n 的字符列表,此字符列表是用来每次生成全排列的数字,并添加到res中的
		start = n - 1;		//start初始值为n-1,就是个位,也就是nums最右边的一位
		dfs(0); // 开启全排列递归
		res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
		return res.toString(); // 转化为字符串并返回
	}


	void dfs(int x) {
		if(x == n) { // 终止条件：已固定完所有位,将nums[start:],添加入res中
			String s = String.valueOf(num).substring(start);	//为了防止诸如001,002,098这种字符串出现
			if(!s.equals("0")) res.append(s + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开,且从1开始,不含0
			if(n - start == nine) start--;	//当start后的有效位都为9时,n - start == nine成立,start应该减一
			return;
		}

		for(char i : loop) { // 遍历 ‘0‘ - ’9‘
			if(i == '9') nine++;	//如果当前数位出现9,则nine要加一
			num[x] = i; // 固定第 x 位为 i
			dfs(x + 1); // 开启固定第 x + 1 位
		}
		nine--;	//本位全排列已经结束,恢复nine的值
	}
}
