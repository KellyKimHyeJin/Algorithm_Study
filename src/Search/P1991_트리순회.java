package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentNode = st.nextToken().charAt(0) - 'A';
            int leftNode = st.nextToken().charAt(0) - 'A';
            int rightNode = st.nextToken().charAt(0) - 'A';

            // . 일때는 -1로 해주기 return 될 수 있도록
            // .에서 'A'빼면 -19
            if(leftNode == -19){
                tree[parentNode][0] = -1;
            }else{
                tree[parentNode][0] = leftNode;
            }
            if(rightNode == -19){
                tree[parentNode][1] = -1;
            }else{
                tree[parentNode][1] = rightNode;
            }
        }
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    static void preOrder(int s){
        if(s == -1) {
            return;
        }
        sb.append((char) (s + 'A'));
        preOrder(tree[s][0]);
        preOrder(tree[s][1]);
    }
    static void inOrder(int s){
        if(s == -1){
            return;
        }
        inOrder(tree[s][0]);
        sb.append((char) (s + 'A'));
        inOrder(tree[s][1]);
    }
    static void postOrder(int s){
        if(s == -1){
            return;
        }
        postOrder(tree[s][0]);
        postOrder(tree[s][1]);
        sb.append((char) (s + 'A'));
    }
}
