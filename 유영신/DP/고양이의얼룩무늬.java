package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 고양이의얼룩무늬 {
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static char[][] board;
	static int N, M;
	static int countB, countO, countW;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			countB = 0;
			countO = 0;
			countW = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						continue;
					}
					visited[i][j] = true;

					dfs(i, j);

					if (board[i][j] == 'B') {
						countB++;
					} else if (board[i][j] == 'O') {
						countO++;
					} else {
						countW++;
					}
				}
			}

			System.out.println("#" + tc + " " + countB + " " + countO + " " + countW);
		}

	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[r][c] == board[nr][nc] && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}
}
