package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_BFSDFS {
    static ArrayList<Integer>[] A;
    static boolean[] visitedBFS;
    static boolean[] visitedDFS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }
        DFS(V);
        System.out.println();
        BFS(V);
    }
    private static void DFS(int V){
        if(visitedDFS[V]){
            return;
        }
        System.out.print(V + " ");
        visitedDFS[V] = true;
        for(int i : A[V]) {
            if (!visitedDFS[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int V){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visitedBFS[V] = true;
        while(!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num + " ");
            for(int i : A[num]){
                if(!visitedBFS[i]){
                    queue.add(i);
                    visitedBFS[i] = true;
                }
            }
        }
    }
}
