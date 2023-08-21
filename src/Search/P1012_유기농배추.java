package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012_유기농배추 {
    static int[][] A;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0,1,0,-1 };
    static int[] dy = {1,0,-1,0};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            A = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            for(int j =0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                A[x][y] = 1;
            }
            for(int x=0; x<M; x++){
                for(int y=0; y<N;y++){
                    if(A[x][y]==1 && !visited[x][y]){
                        BFS(x,y);
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y]=true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                x = now[0] + dx[i];
                y = now[1] + dy[i];
                if(x>=0 && y>=0 && x< M && y <N){
                    if(A[x][y] ==1 && !visited[x][y]){
                        visited[x][y]=true;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
        count++;
    }
}
