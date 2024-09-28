import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static int[][] adj;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수 N, 간선의 개수 M, 탐색 시작 지점 V
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 방문을 확인할 배열 선언
		visited = new boolean[N + 1];
		
		// dfs, bfs를 위한 인접행렬을 선언
		adj = new int[N + 1][N + 1];
		
		// 인접행렬과 인접리스트 초기화
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 양방향이므로 대칭되게 초기화
			// 인접행렬
			adj[A][B] = adj[B][A] = 1;
		}

		// dfs 실행
		dfs(V);
		sb.append("\n");
		
		// 방문 배열을 새로 선언
		visited = new boolean[N + 1];
		
		// bfs 실행
		bfs(V);
		
		System.out.println(sb);
	}
	
	// dfs 메서드
	static void dfs(int v) {
		
		// 방문한 지점은 true로 변경
		visited[v] = true;
		sb.append(v).append(" ");
		
		// 정점을 모두 순회하면서 연결된 것들만 추출
		for(int i = 1; i <= N; i++) {
			
			// 이동하려는 지점이 아직 거치지 않은 곳이면서
			// 연결되어 있으면 추출
			if(!visited[i] && adj[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	// bfs 메서드
	static void bfs(int v) {
		
		// 사용할 큐를 선언
		Queue<Integer> q = new LinkedList<>();
		
		// 방문지점을 담고 방문 체크
		q.add(v);
		visited[v] = true;
		
		// 큐가 비지 않았을때까지 반복
		while(!q.isEmpty()) {
			
			// 하나를 꺼내서 확인하고 추출
			v = q.poll();
			sb.append(v).append(" ");
			
			
			// 현재 지점과 연결된 것들을 순회
			for(int i = 1; i <= N; i++) {
				
				// 방문하지 않은 것들을 추출하고 방문체크
				if(!visited[i] && adj[v][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}