package HOT100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 二零七_课程表 {
	/**
	 * 有向无环图DAG的遍历,广度优先
	 * 先把入度为0的节点依次入栈,每次出栈时其邻接节点的入度-1,每次出队时这个节点就会从图中被删除,当一个节点的入度为0,就将其入队
	 * 最后如果所有节点的入度都为0,就说明是有向无环图.
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegreeTable = new int[numCourses];	//入度表
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		List<List<Integer>> adjacency = new ArrayList<>();	//邻接表
		for (int i = 0; i < numCourses; i++) {
			adjacency.add(new ArrayList<>());    //初始化邻接表
		}

		//制作邻接表
		for(int[] cp : prerequisites) {
			inDegreeTable[cp[0]]++;
			adjacency.get(cp[1]).add(cp[0]);
		}

		//初始化队列
		for (int i = 0; i < numCourses; i++) {
			if (inDegreeTable[i] == 0) queue.add(i);
		}

		//开始遍历dag
		while(!queue.isEmpty()) {
			int pre = queue.poll();
			numCourses--;
			//如果出队的元素指向的元素入度都是0,就加入队列
			for(int cur : adjacency.get(pre))
				if (--inDegreeTable[cur] == 0) {
					queue.add(cur);
				}
		}
		return numCourses == 0;


	}
}
