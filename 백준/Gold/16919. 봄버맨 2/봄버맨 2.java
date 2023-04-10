import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int R, C, N;
	private static char[][] map;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	private static char[][] newMap;
	private static char[][] newMap2;

	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력 완료



		if(N%2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append("O");					
				}
				sb.append("\n");
			}
		} else if(N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} else if(N%4 == 1) {
			newMap = new char[R][C];
			newMap2 = new char[R][C];

			for (int i = 0; i < R; i++) {
				Arrays.fill(newMap[i], 'O');
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'O') {
						newMap[i][j] = '.';
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if(isValid(ny,nx)) {
								newMap[ny][nx] = '.';
							}
						}
					}
				}
			} // end of for i

			for (int i = 0; i < R; i++) {
				Arrays.fill(newMap2[i], 'O');
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(newMap[i][j] == 'O') {
						newMap2[i][j] = '.';
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if(isValid(ny,nx)) {
								newMap2[ny][nx] = '.';
							}
						}
					}
				}
			} // end of for i

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(newMap2[i][j]);
				}
				sb.append("\n");
			}

		} else if(N%4 == 3) {
			newMap = new char[R][C];

			for (int i = 0; i < R; i++) {
				Arrays.fill(newMap[i], 'O');
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'O') {
						newMap[i][j] = '.';
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if(isValid(ny,nx)) {
								newMap[ny][nx] = '.';
							}
						}
					}
				}
			} // end of for i

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(newMap[i][j]);
				}
				sb.append("\n");
			}

		}





		System.out.println(sb.toString());

	} // end of main

	private static boolean isValid(int y, int x) {
		return 0<=y && y<R && 0<=x && x<C;
	} // end of isValid
} // end of class