import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int t;
	private static int r;
	private static int c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int testcase = 0; testcase < t; testcase++) {
			br.readLine(); // 빈줄
			st= new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			char[][] lst = new char[r][c];
			
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					lst[i][j] = s.charAt(j);
				}
			}
			
			int answer = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (lst[i][j] == 'o') {
						if (isValid(i, j - 1) && lst[i][j - 1] == '>') 
							if (isValid(i, j + 1) && lst[i][j + 1] == '<')
								answer++;
						if (isValid(i - 1, j) && lst[i - 1][j] == 'v') 
							if (isValid(i + 1, j) && lst[i + 1][j] == '^')
								answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
	} // end of main

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < r && 0 <= x && x < c;
	} // end of isValid
} // end of class