package pramp;

/**
 * Question: https://www.pramp.com/question/N5LYMbYzyOtbpovQoY7X
 * 
 * @author Khanh
 *
 */
public class NumberOfPath {
	int memo[][];
	int n;
	public NumberOfPath(int n) {
		this.n = n;
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				memo[i][j] = -1;
			}
		}
	}

	public void solve() {
		Object result = numberOfPath(n - 1, n - 1);
		System.out.println("result: " + result);
	}

	private int numberOfPath(int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i < j) {
			memo[i][j] = 0;
		}

		if (i == 0 && j == 0) {
			memo[i][j] = 1;
		}

		if (memo[i][j] == -1) {
			memo[i][j] = numberOfPath(i, j - 1) + numberOfPath(i - 1, j);
		}

		return memo[i][j];
	}

	public static void main(String[] args) {
		new NumberOfPath(4).solve();
	}
}
