package HOT100;

public class 七十五_颜色分类 {
	//排序,不使用库内置的 sort 函数,原地对它们进行排序,并不是好的方法
	//双指针,一个指针记录当前已排序的0的位置,一个指针记录已排序的1的位置

	public void sortColors(int[] nums) {
		int p0 = 0, p1 = 0;
		for (int i = 0; i < nums.length; i++) {
			//刷油漆算法
			int now = nums[i];		//保存当前值
			nums[i] = 2;			//默认把当前值刷为2,如果当前值为2,那就相当于没有操作
			if (now < 2) {			//如果当前值小于2,说明当前值不是0就是1,先刷为1,如果是0就会走下面的if
				nums[p1] = 1;
				p1++;
			}
			if (now < 1) {			//如果当前值是0,就刷为0
				nums[p0] = 0;
				p0++;
			}
		}
	}
}
