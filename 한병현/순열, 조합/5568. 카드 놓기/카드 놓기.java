import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static int n, k;
	static int[] card;
	static boolean[] visited;
	static int[] select;
	static Set<Integer> set = new HashSet<>();
	static String num = "";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 카드 개수 n, 선택할 카드의 개수 k
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		// 카드 배열에 카드를 할당
		card = new int[n];
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		
		// 해당 카드를 사용했는지 확인하기 위한 배열
		visited = new boolean[n];
		
		// 정수를 만들기 전에 뽑은 카드를 담을 배열
		select = new int[k];
		
		search(0);
		
		System.out.println(set.size());
		
	}
    
	// 조합을 찾기위한 메서드
	static void search(int start) {
		
		// k만큼 뽑았으면 종료
		if(start == k) {
			
			// 문자열로 더하기 위해 변수 선언
			String str = "";
			
			// 반복문을 통해 뽑힌 카드들을 문자열로 모두 더함
			for(int i = 0; i < k; i++) {
				str += (select[i] + "");
			}
			
			// 만든 정수가 이미 있는지 확인하기 위한 set			
			set.add(Integer.parseInt(str));
			return;
		}
		
		// 모든 카드를 순회하면서 반복
		for(int i = 0; i < n; i++) {
			
			// 해당 카드를 사용하지 않았다면
			if(!visited[i]) {
				
				// 선택한 카드 배열에 담고
				// 해당 카드를 사용처리하고
				// 재귀로 반복
				// 모든 경우의 수를 파악하기 위해 다시 false로
				select[start] = card[i];
				visited[i] = true;
				search(start + 1);
				visited[i] = false;
			}
		}
	}
}
