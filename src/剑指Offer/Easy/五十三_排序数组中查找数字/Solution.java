package 剑指Offer.Easy.五十三_排序数组中查找数字;

public class Solution {
	int[] arr;
	int ans=0;
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		arr=nums;
		sum(0, nums.length-1, target);
		return ans;
	}

	public void sum(int i, int j, int target) {
		if (i == j) {
			if (arr[i]==target) ans++;
			return;
		}
		if (arr[j]<target||arr[i]>target) return;	//剪枝
		sum(i, i + (j - i) / 2, target);
		sum(i + (j - i) / 2+1,j,target);

	}


	public static void main(String[] args) {
		String s="我 们 只 能在 今 天 的 技 术 条 件 下 ， 在 人们 的 生 活不 可 能 离 开数 据 的 情 况 下 ， 去 探 讨 如 何 保护 用 户 数据 信 息 安 全 、 如 何在 数据 上 享受到 公 平 与 公 正 。 正 是 因 为 在 实 际 生 活 中 ， 在 大 数据 领域之 内 ， 数据 安 全 、 数据 公平 与 公 众没 有 得 到 充 分 的 重视 与 保 护 ， 所 以 这些 议题才会 成为大 数据 的 分析者 、 利 用 者 关 注 的 伦 理 问 题 。 在 看 到 了 如 此之 多 的 数据 安 全事 故之 后 ， 我们 可 以 意 识 到 ， 对 大 数 据 的 利 用 如 果 偏 离 轨 道 ， 社 会 公众 的 大 数 据 伦 理 意 识 淡 薄 ， 将 会对 社 会 正 常 ＇ 的 生 活 秩序 造 成 巨 大 的 冲 击 。 如 果 任 由 对 大数据 的 不 当 利 用 肆 意 发 展 ， 对 社 会 公 众 大 数 据 伦理 意 识 淡 薄 的 现状视而 不 见 ， 可 以 想 见 ， 长此 以 往 ， 社 会 伦 理 道 德 意 识 扭 曲 、 社 会 正 常 的 经济秩 序 受 到 冲 击 ： 《 人们 思 想 受到 侵 蚀 、 个 人 生活受到极大干扰，会严重危害人们的正常生活。";
		String[] s1 = s.split(" ");
		StringBuilder ans=new StringBuilder();
		for (String s2 : s1) {
			ans.append(s2);
		}
		String s2 = ans.toString();
		System.out.println(s2);
	}
}
