import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int[][] arr;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		answer = Integer.MAX_VALUE;
		recur(0,0,0,0,0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void recur(int cnt1, int cnt2, int cnt3, int cnt4, int cnt5) {
		if(cnt1 >= 6) return;
		if(cnt2 >= 6) return;
		if(cnt3 >= 6) return;
		if(cnt4 >= 6) return;
		if(cnt5 >= 6) return;
		
		int pointY = -1;
		int pointX = -1;
ex:		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(arr[i][j] == 1) {
					pointY = i;
					pointX = j;
					break ex;
				}
			}
		} // end of for i
		
		if(pointY==-1) {
			answer = Math.min(answer, cnt1 + cnt2 + cnt3 + cnt4 + cnt5);
		} else {
			int can = check(pointY, pointX);
			for (int i = 1; i <= can; i++) {
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < i; k++) {
						arr[pointY + j][pointX + k] = 0;
					}
				}
				if(i==1) {
					recur(cnt1+1, cnt2, cnt3, cnt4, cnt5);
				} else if(i==2) {
					recur(cnt1, cnt2+1, cnt3, cnt4, cnt5);
				} else if(i==3) {
					recur(cnt1, cnt2, cnt3+1, cnt4, cnt5);
				} else if(i==4) {
					recur(cnt1, cnt2, cnt3, cnt4+1, cnt5);
				} else if(i==5) {
					recur(cnt1, cnt2, cnt3, cnt4, cnt5+1);
				}
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < i; k++) {
						arr[pointY + j][pointX + k] = 1;
					}
				}
			}
		}
		
	} // end of recur

	private static int check(int y, int x) {
		boolean isPossible = true;
		for (int k = 5; k >= 1; k--) {
			isPossible = true;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					if(!isValid(y+i, x+j) || arr[y+i][x+j] == 0) {
						isPossible = false;
						break;
					}
				}
			}	
			
			if(isPossible) return k;
		}
		return 1;
	} // end of check

	private static boolean isValid(int y, int x) {
		return 0<=y && y<10 && 0<=x && x<10;
	} // end of isValid
} // end of class