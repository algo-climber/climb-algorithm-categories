import java.util.*;
import java.io.*;

public class Main {
	static int N, M, V;
	static int[][] arr;
	static boolean [] visited;
	static boolean [] visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 간선의 개수
		M = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점의 번호
		V = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		visited2 = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				arr[A][B] = arr[B][A] = 1;
		}
		dfs(V);
		System.out.println();
		bfs(V);
	}
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && arr[v][i] == 1) {
				dfs(i);
			}
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited2[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			
			for(int i = 1; i <= N; i++) {
				if(!visited2[i] && arr[curr][i] == 1) {
					q.add(i);
					visited2[i] = true;
				}
			}
			
		}
	}
}
