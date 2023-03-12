package HOT100;

public class 二百_岛屿数量 {
	/**
	 * 网格dfs(图),通过visit数组来记录哪些已经被遍历到了,每次
	 * dfs都会确定一个岛屿
	 */

	//定义了四个方向
	private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	private boolean[][] visited;
	private int rows;
	private int cols;
	private char[][] grid;

	public int numIslands(char[][] grid) {

		int rows = grid.length;
		if (rows == 0) {
			return 0;
		}
		int cols = grid[0].length;
		this.rows = rows;
		this.cols = cols;
		this.grid=grid;
		this.visited = new boolean[rows][cols];
		int count=0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j]&&grid[i][j]=='1') {
					dfs(i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(int i, int j) {
		if (!inArea(i, j)||visited[i][j]) {
			return;
		}
		visited[i][j]=true;
		for (int k = 0; k < 4; k++) {	//遍历四个方向
			int newX = i + DIRECTIONS[k][0];
			int newY = j + DIRECTIONS[k][1];
			if (inArea(newX, newY) && !visited[newX][newY]&& grid[newX][newY] == '1') {
				dfs(newX, newY);
			}
		}

	}

	private boolean inArea(int x, int y) {
		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			return true;
		} else {
			return false;
		}
	}
}
