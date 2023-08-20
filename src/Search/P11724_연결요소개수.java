package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소개수 {
    // 방문했는지 표시하는 배열
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        // 1부터 한 개씩 연결을 저장하는 ArrayList 만들기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }
        // 간선의 개수만큼 돌면서 두 개 다 각각에 저장해주기 -> 방향성이 없으니까
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        int count = 0;
        for(int i=1; i<N+1; i++){
            // i를 이용해서 DFS 다 돌았는데 다음 거로 갔을 때 visit되지 않았으면 끊어진 부분 -> 끊어진 부분 있을 때마다 count++ 해주기
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }

    private static void DFS(int i) {
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int j: A[i]){
            if(!visited[j]){
                DFS(j);
            }
        }
    }
}
