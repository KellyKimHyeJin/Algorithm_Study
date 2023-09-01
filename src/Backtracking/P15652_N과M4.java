package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652_N과M4 {
    static int N;
    static int M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M];
        DFS(0,0);
    }
    private static void DFS(int depth, int start){
        if(depth == M){
            for(int i: A){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<N; i++){
            A[depth] = i+1;
            DFS(depth+1, i);
        }
    }
}
