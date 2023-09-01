package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {
    static int[] result;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        BFS(1);
        for(int i=2; i<=N; i++){
            System.out.println(result[i]);
        }
    }
    private static void BFS(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i: A[now]){
                if(!visited[i]){
                    queue.add(i);
                    result[i] = now;
                    visited[i] = true;
                }
            }
        }
    }
}
