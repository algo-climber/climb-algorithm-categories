package _2024_09._2024_09_29.방승윤;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {

	static int N, M, V;
	static boolean[] visited;
	static boolean[][] edge;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		// 간선을 저장 배열
		edge = new boolean[N + 1][N + 1];
		// 방문 체크 배열
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향 간선
			edge[a][b] = true;
			edge[b][a] = true;
		}

		dfs(V);

		sb.append("\n");

		// 방문 체크 배열 초기화
		Arrays.fill(visited, false);

		// 시작 정점을 방문 체크
		visited[V] = true;

		bfs(V);

		System.out.println(sb);

	}

	static void dfs(int curr) {

		// 방문한 정점을 정답에 추가
		sb.append(curr).append(" ");

		// 방문한 정점을 방문 체크
		visited[curr] = true;

		for (int i = 1; i <= N; i++) {
			// 연결되어 있고 방문하지 않은 정점을 방문
			if (edge[curr][i] && !visited[i]) {
				dfs(i);
			}
		}

	}

	static void bfs(int curr) {

		// 방문한 정점을 정답에 추가
		sb.append(curr).append(" ");

		for (int i = 1; i <= N; i++) {
			// 연결되어 있고 방문하지 않은 정점을 큐에 넣으면서 방문 체크
			if (edge[curr][i] && !visited[i]) {
				queue.offer(i);
				visited[i] = true;
			}
		}

		// 큐에서 뽑아서 방문
		while (!queue.isEmpty()) {
			bfs(queue.poll());
		}

	}

}