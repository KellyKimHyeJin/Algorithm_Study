package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P21736_헌내기는친구가필요해 {
    static char[][] A;
    static boolean[][] visited;
    static int count;
    static int N;
    static int M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 꼭 해주기
        A = new char[N][M];
        visited = new boolean[N][M];
        int pointX = 0;
        int pointY = 0;
        count = 0;
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                A[i] = line.toCharArray();
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j]=='I'){
                    pointX = i;
                    pointY = j;
                }
            }
        }
        BFS(pointX, pointY);
        if(count==0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                x = now[0] + dx[i];
                y = now[1] + dy[i];
                if(x >=0 && y >=0 && x <N && y<M) {
                    if(A[x][y] != 'X' && !visited[x][y]){
                        visited[x][y] = true;
                        queue.add(new int[] {x,y});
                        if(A[x][y] =='P'){
                            count++;
                        }
                    }
                }
            }
        }
    }
}
