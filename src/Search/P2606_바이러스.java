package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2606_바이러스 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        count = 0;
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        DFS(1);
        System.out.println(count-1);
    }
    public static void DFS(int i){
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while(!stack.isEmpty()){
            int num = stack.pop();
            if(!visited[num]){
                visited[num] = true;
                count++;
                for(int j: A[num]){
                    if(!visited[j]) {
                        stack.add(j);
                    }
                }
            }
        }
    }
}
