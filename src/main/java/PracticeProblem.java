public class PracticeProblem {

	public static void main(String args[]) {
		
	}

	
	public static int searchMazeMoves(String[][] arr) {
		return dfs(arr, arr.length - 1, 0, 0);
	}

	public static int dfs(String[][] arr, int row, int col, int steps) {
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[row].length || arr[row][col].equals("*")) {
			return -1;
		} else if (arr[row][col].equals("F")) {
			return steps;
		}

		arr[row][col] = "*";
		int up = dfs(arr, row - 1, col, steps + 1);
		int right = dfs(arr, row, col + 1, steps + 1);
		int left = dfs(arr, row, col - 1, steps + 1);
		int down = dfs(arr, row + 1, col, steps + 1);
		arr[row][col] = "";
		if (up == -1) {
			up = arr.length * arr[row].length + 1;
		}
		if (right == -1) {
			right = arr.length * arr[row].length + 1;
		}
		if (left == -1) {
			left = arr.length * arr[row].length + 1;
		}
		if (down == -1) {
			down = arr.length * arr[row].length + 1;
		}
		int min = Math.min(up, Math.min(right, Math.min(left, down)));
		if (min == arr.length * arr[row].length + 1) {
			min = -1;
		}
		return min;
	}
}