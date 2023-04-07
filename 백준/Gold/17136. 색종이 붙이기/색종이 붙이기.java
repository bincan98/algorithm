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
		
		// answer 초기화
		answer = Integer.MAX_VALUE;
		recur(0,0,0,0,0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void recur(int cnt1, int cnt2, int cnt3, int cnt4, int cnt5) {
		// 각 색종이들이 5개를 넘으면 리턴
		if(cnt1 >= 6) return;
		if(cnt2 >= 6) return;
		if(cnt3 >= 6) return;
		if(cnt4 >= 6) return;
		if(cnt5 >= 6) return;
		
		int pointY = -1;
		int pointX = -1;
ex:		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// 제일 첫 1을 가져오기
				if(arr[i][j] == 1) {
					pointY = i;
					pointX = j;
					break ex;
				}
			}
		} // end of for i
		
		if(pointY==-1) { // 1이 없다면 다 덮은것
			// 색종이 개수 합을 answer에 넣어보기
			answer = Math.min(answer, cnt1 + cnt2 + cnt3 + cnt4 + cnt5);
		} else { // 1을 덮기
			int can = check(pointY, pointX); // 그 1을 기준으로 가장 큰 정사각형 칸 구해오기
			for (int i = 1; i <= can; i++) { // 칸 개수 만큼 반복하기
				// 색종이로 덮기
				for (int j = 0; j < i; j++) { 
					for (int k = 0; k < i; k++) {
						arr[pointY + j][pointX + k] = 0;
					}
				}
				// 덮은 색종이 개수를 1증가 시키고 재귀로 들어가기
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
				// 덮은 색종이 다시 빼기
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < i; k++) {
						arr[pointY + j][pointX + k] = 1;
					}
				}
			}
		}
		
	} // end of recur

	private static int check(int y, int x) {
		// 가능한지 체크할 변수
		boolean isPossible;
		for (int k = 5; k >= 1; k--) { // 제일 큰 칸을 리턴하기 위해 --로 for문 돌리기
			isPossible = true;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					if(!isValid(y+i, x+j) || arr[y+i][x+j] == 0) { // 범위를 벗어나거나, 1이 아니라면
						isPossible = false;
						break;
					}
				}
			}	
			
			// 만약 가능하다면 그 값을 리턴하기
			if(isPossible) return k;
		}
		return 1;
	} // end of check

	private static boolean isValid(int y, int x) {
		return 0<=y && y<10 && 0<=x && x<10;
	} // end of isValid
} // end of class