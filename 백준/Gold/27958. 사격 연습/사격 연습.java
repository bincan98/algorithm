import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, K;
	private static int[][][] map, mapCopy;
	private static int[] bullet;
	private static int[] numbers;
	private static int sum;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N][2];
		bullet = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int ele = Integer.parseInt(st.nextToken());
				map[i][j][0] = ele; // 현재 체력
				map[i][j][1] = ele; // 시작 시점의 체력
			}
		} // map 입력
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			bullet[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		
		numbers = new int[K];
		perm(0);
		
		System.out.println(answer);
		
	} // end of main

	private static void perm(int index) {
		if(index==K) {
			mapCopy = new int[N][N][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.arraycopy(map[i][j], 0, mapCopy[i][j], 0, map[i][j].length);
				}
			}
			simulate();
			
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[index] = i;
			perm(index+1);
		}
	} // end of perm

	private static void simulate() {
		sum = 0;
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) { // 총알 발사
				if(mapCopy[numbers[i]][j][0] != 0) { // 총알이 맞았다 
					if(mapCopy[numbers[i]][j][0] >= 10) { // 보너스 일 경우
						bonus(numbers[i], j, bullet[i]);
					} else { // 아닐 경우
						nonbonus(numbers[i], j, bullet[i]);
					}
					break;
				}
			}
		}
		
//		System.out.println(sum + " " + Arrays.toString(numbers));
		answer = Math.max(answer, sum);
		
	} // end of simulate

	private static void nonbonus(int y, int x, int power) {
		if(power >= mapCopy[y][x][0]) { // 표적이 사라지는 경우
			// 초기값을 더해주기
			sum += mapCopy[y][x][1]; 
			// 새로운 표적 생성하기
			int nextA = mapCopy[y][x][1]/4;
			// 표적 없애기
			mapCopy[y][x][0] = 0;
			mapCopy[y][x][1] = 0;
			// 새로운 표적 생성하기
			if(nextA <= 0) return;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(isValid(ny, nx) && mapCopy[ny][nx][0] == 0) {
					mapCopy[ny][nx][0] = nextA;
					mapCopy[ny][nx][1] = nextA;
				}
			}
		} else { // 표적이 사라지지 않는경우
			mapCopy[y][x][0] -= power; 
		}
	} // end of nonbonus

	private static void bonus(int y, int x, int power) {
		sum += mapCopy[y][x][0];
		mapCopy[y][x][0] = 0;
		mapCopy[y][x][1] = 0;
	} // end of bonus
	
	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<N;
	} // end of isValid
} // end of class