import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String[][] broken = new String[4][5];
		
		String[][] number = {{"###",
					           "#.#",
					           "#.#",
					           "#.#",
					           "###"},
					          {"..#",
					           "..#",
					           "..#",
					           "..#",
					           "..#"},
					          {"###",
					           "..#",
					           "###",
					           "#..",
					           "###"},
					          {"###",
					           "..#",
					           "###",
					           "..#",
					           "###"},
					          {"#.#",
					           "#.#",
					           "###",
					           "..#",
					           "..#"},
					          {"###",
					           "#..",
					           "###",
					           "..#",
					           "###"},
					          {"###",
					           "#..",
					           "###",
					           "#.#",
					           "###"},
					          {"###",
					           "..#",
					           "..#",
					           "..#",
					           "..#"},
					          {"###",
					           "#.#",
					           "###",
					           "#.#",
					           "###"},
					          {"###",
					           "#.#",
					           "###",
					           "..#",
					           "###"}};
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				broken[j][i] = st.nextToken(); 
			}
		}
		
		int[] selected = new int[4];
		
		for (int i = 0; i < broken.length; i++) {
			for (int j = 0; j < number.length; j++) {
				boolean isPossible = true;
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 3; l++) {
						if (broken[i][k].charAt(l) == '#' && number[j][k].charAt(l) == '.') {
							isPossible = false;
							break;
						}
					}
					if (!isPossible) {
						break;
					}
				}
				if (!isPossible) {
					continue;
				} else {
					selected[i] = j;
					break;
				}
			}
		}
		
		System.out.println("" + selected[0] + selected[1] + ":" + selected[2] + selected[3]);
		
		
	} // end of main
} // end of class