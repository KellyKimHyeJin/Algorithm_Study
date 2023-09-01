package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650_N과M2 {
    static boolean[] visited;
    static int[] A;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        A = new int[M];
        DFS(0,0);
    }
    private static void DFS(int depth, int start){
        if(depth == M){
            for(int i : A){
                System.out.print(i +" ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                A[depth] = i + 1;
                DFS(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
