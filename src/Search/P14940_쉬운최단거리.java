package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14940_쉬운최단거리 {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];
        int pointX = 0;
        int pointY = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                // 못 가는 구간은 -1이므로 -1로 일단 먼저 처리를 해두기
                if(A[i][j] == 1){
                    A[i][j] = -1;
                }
                if(A[i][j] ==2){
                    pointX = i;
                    pointY = j;
                }
            }
        }
        BFS(pointX,pointY);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        A[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = now[0] + dx[i];
                y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (A[x][y] == -1 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        A[x][y] = A[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
