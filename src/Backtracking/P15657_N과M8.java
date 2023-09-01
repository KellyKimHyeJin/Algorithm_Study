package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15657_N과M8 {
    static int N;
    static int M;
    static int[] A;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        result = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        DFS(0,0);
        System.out.println(sb);
    }
    private static void DFS(int depth, int start){
        if(depth == M){
            for(int i: result){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<N; i++){
            result[depth] = A[i];
            DFS(depth+1, i);
        }
    }
}
