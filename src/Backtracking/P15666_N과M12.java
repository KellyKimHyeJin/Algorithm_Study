package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15666_N과M12 {
    static int N;
    static int M;
    static int[] A;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        DFS(0,0);
        System.out.println(sb);
    }
    private static void DFS(int depth, int start){
        int before = 0;
        if(depth == M){
            for(int i : result){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<N; i++){
            if(before != A[i]){
                result[depth] = A[i];
                before = A[i];
                DFS(depth + 1, i);
            }
        }
    }
}
