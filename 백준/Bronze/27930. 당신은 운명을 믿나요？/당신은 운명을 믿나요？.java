import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String S = br.readLine();
		
		int[] YONSEI = new int[6];
		int[] KOREA = new int[5];
		
		Arrays.fill(YONSEI, Integer.MAX_VALUE);
		Arrays.fill(KOREA, Integer.MAX_VALUE);
		
		int cur_y = 0;
		for (int i = 0; i < S.length(); i++) {
			if (cur_y == 0 && S.charAt(i) == 'Y') {
				YONSEI[cur_y] = i;
				cur_y++;
			} else if (cur_y == 1 && S.charAt(i) == 'O') {
				YONSEI[cur_y] = i;
				cur_y++;
			} else if (cur_y == 2 && S.charAt(i) == 'N') {
				YONSEI[cur_y] = i;
				cur_y++;
			} else if (cur_y == 3 && S.charAt(i) == 'S') {
				YONSEI[cur_y] = i;
				cur_y++;
			} else if (cur_y == 4 && S.charAt(i) == 'E') {
				YONSEI[cur_y] = i;
				cur_y++;
			} else if (cur_y == 5 && S.charAt(i) == 'I') {
				YONSEI[cur_y] = i;
				cur_y++;
				break;
			}
		}
		
		int cur_x = 0;
		for (int i = 0; i < S.length(); i++) {
			if (cur_x == 0 && S.charAt(i) == 'K') {
				KOREA[cur_x] = i;
				cur_x++;
			} else if (cur_x == 1 && S.charAt(i) == 'O') {
				KOREA[cur_x] = i;
				cur_x++;
			} else if (cur_x == 2 && S.charAt(i) == 'R') {
				KOREA[cur_x] = i;
				cur_x++;
			} else if (cur_x == 3 && S.charAt(i) == 'E') {
				KOREA[cur_x] = i;
				cur_x++;
			} else if (cur_x == 4 && S.charAt(i) == 'A') {
				KOREA[cur_x] = i;
				cur_x++;
				break;
			} 
		}
		
		if (YONSEI[5] > KOREA[4]) {
			System.out.println("KOREA");
		} else {
			System.out.println("YONSEI");
		}
		
	}
}