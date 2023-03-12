package HOT100;

public class 七十九_单词搜索 {

	/*搜索问题,八成用回溯法*/
	private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};	//四个方向,上,左,右,下
	private int rows;
	private int cols;
	private int len;
	private boolean[][] visited;		//dfs记录已经访问过的格子
	private char[] charArray;			//将word转换为字符数组
	private char[][] board;


	public boolean exist(char[][] board, String word) {
		rows = board.length;
		if (rows == 0) {
			return false;
		}
		cols = board[0].length;
		visited = new boolean[rows][cols];
		this.len = word.length();
		this.charArray = word.toCharArray();
		this.board = board;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(i, j, 0)) {			//对棋盘上的每个节点都进行深度优先的回溯法
					return true;
				}
			}
		}
		return false;

	}

	private boolean dfs(int x, int y, int begin) {	//x,y记录棋盘位置,begin记录字符串已经匹配到哪了
		if (begin == len - 1) {
			return board[x][y] == charArray[len-1];
		}
		if (board[x][y] == charArray[begin]) {
			visited[x][y]=true;
			for (int[] fangxiang : DIRECTIONS) {
				int newX = x + fangxiang[0];
				int newY = y + fangxiang[1];
				if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
					if (dfs(newX, newY, begin + 1)) {        //只要有一个能走通,就返回true
						return true;
					}
				}


			}
			visited[x][y]=false;	//如果走到这一步,说明棋盘上x,y这个点根本就走不通,要回溯为没访问过

		}
		return false;
	}

}
