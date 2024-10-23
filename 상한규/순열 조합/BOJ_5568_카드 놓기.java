import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] result;
	static int[] cards;
	static int n;
	static int k;
	static HashSet<Integer> set;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		result = new int[k];
		cards = new int[n];
		set = new HashSet<>();
		sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		permutation(0);
		
		System.out.println(set.size());
	}
	
	static void permutation(int count) {
		if(count == k) {
			for(int value : result) {
				sb.append(value);
			}
			set.add(Integer.parseInt(sb.toString()));
			sb.setLength(0);
			
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[count] = cards[i];
				permutation(count + 1);
				visited[i] = false;
			}
		}
	}
}
