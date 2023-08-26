import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static String answerString;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		answerString = "";
		
		recur("", 0);
		System.out.println(answerString);
	} // end of main

	private static void recur(String string, int cur) {
		if (!answerString.equals("")) {
			return;
		}
		if (checkNotGoodSeq(string)) {
			return;
		}
		if (cur == N) {
			answerString = string;
			return;
		}
		recur(string + "1", cur + 1);
		recur(string + "2", cur + 1);
		recur(string + "3", cur + 1);
		
	} // end of recur

	private static boolean checkNotGoodSeq(String string) {
		for (int i = 2; i < string.length() + 1; i += 2) { // 이번에 볼 부분 수열의 길이
			for (int j = 0; j < string.length(); j++) { // 부분수열 시작 지점
				if (i + j > string.length()) break;
				if (!string.substring(j, j + (int) i/2).equals(string.substring(j + (int) i/2, j+i))) {
					continue;
				} else {
					return true;
				}
			}
		}
		return false;
	} // end of checkNotGoodSeq
} // end of class