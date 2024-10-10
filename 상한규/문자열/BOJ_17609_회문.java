import java.io.*;
import java.util.*;

public class Main {
	static String word;
	static int checkCount = 2;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int tc = 0; tc < T; tc++) {
	    	word = br.readLine();
	    	int front = 0;
	    	int rear = word.length() - 1;
	    	checkCount = 2;
	    	
	    	check(front, rear, 0);
	    	
	    	System.out.println(checkCount);
	    }
	}
	
	public static void check(int front, int rear, int count) {
		if(front >= rear || count >= 2) {
			checkCount = Math.min(checkCount, count);

			return ;
		}
		
		char frontChar = word.charAt(front);
		char rearChar = word.charAt(rear);
		
		if(frontChar == rearChar) {
			check(front + 1, rear - 1, count);
		} else {
			if(word.charAt(front + 1) == rearChar) {
				check(front + 2, rear - 1, count + 1);
			}
			if(word.charAt(rear - 1) == frontChar) {
				check(front + 1, rear - 2, count + 1);
			} 
		}
	}
}