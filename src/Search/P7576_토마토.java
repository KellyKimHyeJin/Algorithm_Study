package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576_토마토 {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count;
    static int M;
    static int N;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        count = 0;
        queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j <M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j]==1){
                    queue.add(new int[] {i,j});
                }
            }
        }
        BFS();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                else if(A[i][j]>count){
                    count = A[i][j];
                }
            }
        }
        System.out.println(count-1);
    }

    private static void BFS(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            visited[x][y] = true;
            for(int i=0; i<4; i++){
                x = now[0] + dx[i];
                y = now[1] + dy[i];
                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(A[x][y] != -1 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.add(new int[] {x,y});
                        if(A[x][y] ==0){
                            A[x][y] = A[now[0]][now[1]] +1;
                        }
                    }
                }
            }
        }
    }
}
