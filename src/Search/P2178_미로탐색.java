package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    // 상하좌우로 탐색하기 위함
    static int[] dx = {0,1,0,-1}; // 아래, 오른쪽, 위, 왼
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 int 다시 선언해서 안 들어가게 하는 것 조심하기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        // 하나씩 값 넣어주기
        // 공백이 없을 때는 nextToken 사용하면 안됨 -> substring으로 자르기
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j =0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        // 0부터 시작했으니까 -1씩 해주기
        System.out.println(A[N-1][M-1]);
    }
    private static void BFS(int i, int j){
        // 이차원이니까 배열(좌표)이 들어간 큐를 사용하기 -> i,j를 큐에 넣기
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            // 상하좌우 탐색
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                // 주어진 범위를 넘어가면 안 됨
                if(x >= 0 && y>=0 && x<N && y<M){
                    // 0이여서 갈 수 없거나 이미 방문해서 갈 수 없음
                    if(A[x][y]!=0 && !visited[x][y]){
                        // 이 속에 있는 건 갈 수 있다는 뜻
                        visited[x][y] = true;
                        // 다음에 방문할 수 있는 곳을 현재 수 + 1로 저장해주기 -> 최단거리 알 수 있음
                        A[x][y] = A[now[0]][now[1]] + 1;
                        // 큐에 새로운 양, 옆으로 돌면서 생긴 새로운 값들을 넣기
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }

}
