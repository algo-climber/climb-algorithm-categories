import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904_A와_B {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] S = br.readLine().split("");
		String[] T = br.readLine().split("");
		boolean dir = true;
		int L = 0;
		int R = T.length - 1;
		int ans = 1;
		
		while (S.length != R + 1 - L) {
			if (dir) {
				switch (T[R]) {
				case "A":
					R--;
					break;
				case "B":
					R--;
					dir = false;
					break;
				}
			} else {
				switch (T[L]) {
				case "A":
					L++;
					break;
				case "B":
					L++;
					dir = true;
					break;
				}
			}
		}
		
		if (dir) {
			for (int i = 0; i < S.length; i++) {
				if (!S[i].equals(T[L + i])) {
					ans = 0;
					break;
				}
			}
		} else {
			for (int i = 0; i < S.length; i++) {
				if (!S[i].equals(T[R - i])) {
					ans = 0;
					break;
				}
			}
		}
		
		System.out.println(ans);

	}

}