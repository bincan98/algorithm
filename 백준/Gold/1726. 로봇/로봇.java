import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static String A, B, C;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] lst = new int[M][N];
        int[][][] visited = new int[M][N][4];

        int[][] dxy = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] nxtDir = new int[] {1, 3};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = 20_000;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lst[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int targetY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetDir = Integer.parseInt(st.nextToken());

        startY -= 1;
        startX -= 1;
        targetY -= 1;
        targetX -= 1;
        startDir = chageDir(startDir);
        targetDir = chageDir(targetDir);

        Queue<int[]> q = new ArrayDeque<>();
        visited[startY][startX][startDir] = 0;
        q.offer(new int[] {startY, startX, startDir, 0});

        while (!q.isEmpty()) {
            int[] curLst = q.poll();
            for (int i = 1; i < 4; i++) {
                int ny = curLst[0] + i * dxy[curLst[2]][0];
                int nx = curLst[1] + i * dxy[curLst[2]][1];
                if (0 <= ny && ny < M && 0 <= nx && nx < N) {
                    if (lst[ny][nx] == 1)
                        break;
                    else {
                        if (visited[ny][nx][curLst[2]] > curLst[3] + 1) {
                            visited[ny][nx][curLst[2]] = curLst[3] + 1;
                            q.offer(new int[] {ny, nx, curLst[2], curLst[3] + 1});
                        }

                    }
                }
            } // end of for i
            for (int i: nxtDir) {
                int nd = (curLst[2] + i) % 4;
                if (visited[curLst[0]][curLst[1]][nd] > curLst[3] + 1) {
                    visited[curLst[0]][curLst[1]][nd] = curLst[3] + 1;
                    q.offer(new int[] {curLst[0], curLst[1], nd, curLst[3] + 1});
                }
            } // end of for i
        } // end of while q

        System.out.println(visited[targetY][targetX][targetDir]);
    } // end of main

    private static int chageDir(int x) {
        if (x == 4)
            return 0;
        else if (x == 2)
            return 3;
        else if (x == 3)
            return 2;
        else
            return 1;
    } // end of changeDir

} // end of class