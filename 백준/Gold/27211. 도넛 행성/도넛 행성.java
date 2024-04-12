import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[][] arr;
    private static int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    answer += 1;
//                    dfs(i , j);
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    } // end of main

    static void bfs(int startY, int startX) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startY);
        q.add(startX);
        arr[startY][startX] = 1;

        while (!q.isEmpty()) {
            int curY = q.poll();
            int curX = q.poll();
            for (int[] cur: dxy) {
                int ny = (curY + cur[0] + N) % N;
                int nx = (curX + cur[1] + M) % M;
                if (arr[ny][nx] == 0) {
                    q.add(ny);
                    q.add(nx);
                    arr[ny][nx] = 1;
                }
            }
        }

    } // end of bfs

    static void dfs(int y, int x) {
        arr[y][x] = 1;
        for (int[] cur: dxy) {
            int ny = (y + cur[0] + N) % N;
            int nx = (x + cur[1] + M) % M;
            if (arr[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    } // end of dfs

} // end of class