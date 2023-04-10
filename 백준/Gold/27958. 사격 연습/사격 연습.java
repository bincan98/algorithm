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
		
		map = new int[N][N][2]; // [0]은 현재 표적의 체력, [1]은 표적의 초기 체력
		bullet = new int[K]; // 총알 저장할 배열
		
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
		// 순열 만들기
		perm(0);
		
		System.out.println(answer);
		
	} // end of main

	private static void perm(int index) {
		if(index==K) { // 순열 완성
			// 시뮬해볼 맵 복사해서 생성
			mapCopy = new int[N][N][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.arraycopy(map[i][j], 0, mapCopy[i][j], 0, map[i][j].length);
				}
			}
			// 시뮬레이션 해보기
			simulate();
			
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[index] = i;
			perm(index+1);
		}
	} // end of perm

	private static void simulate() {
		sum = 0; // 시뮬레이션하면서 얻는 점수
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) { // 총알 발사
				if(mapCopy[numbers[i]][j][0] != 0) { // 총알이 맞는경우
					if(mapCopy[numbers[i]][j][0] >= 10) { // 보너스 일 경우
						bonus(numbers[i], j, bullet[i]);
					} else { // 아닐 경우
						nonbonus(numbers[i], j, bullet[i]);
					}
					break; // 총알이 맞았다면 다음 총알로 넘어가기
				}
			}
		}
		
		// sum을 answer에 넣어주기
		answer = Math.max(answer, sum);
		
	} // end of simulate

	private static void nonbonus(int y, int x, int power) { // y,x 좌표, 총알의 공격력
		if(power >= mapCopy[y][x][0]) { // 표적이 사라지는 경우
			// 초기값을 점수에 더해주기
			sum += mapCopy[y][x][1]; 
			// 새로운 표적 생성할때 사용할 변수 저장하기
			int nextA = mapCopy[y][x][1]/4;
			// 맵에서는 표적 없애기
			mapCopy[y][x][0] = 0;
			mapCopy[y][x][1] = 0;
			if(nextA <= 0) return; // 만약 0이라면 표적 생성하지 않기
			// 새로운 표적 생성하기
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(isValid(ny, nx) && mapCopy[ny][nx][0] == 0) {
					mapCopy[ny][nx][0] = nextA;
					mapCopy[ny][nx][1] = nextA;
				}
			}
		} else { // 표적이 사라지지 않는경우
			// 맵의 표적에서 총알의 파워만큼 깎기
			mapCopy[y][x][0] -= power; 
		}
	} // end of nonbonus

	private static void bonus(int y, int x, int power) { // y,x 좌표, 총알의 공격력
		// 점수를 더해주기
		sum += mapCopy[y][x][0];
		// 맵에서는 표적 없애기
		mapCopy[y][x][0] = 0;
		mapCopy[y][x][1] = 0;
	} // end of bonus
	
	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<N;
	} // end of isValid
} // end of class