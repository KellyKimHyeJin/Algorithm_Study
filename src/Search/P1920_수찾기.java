package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {
    // for문 그냥 돌면서 하면 시간복잡도 크니까 이진탐색으로 해결
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            boolean find = false;
            while(start <= end){
                int mid = (start+end)/2;
                int midNum = A[mid];
                if(num > midNum){
                    start = mid+1;
                } else if(num < midNum){
                    end = mid-1;
                } else{
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println('1');
            }else{
                System.out.println('0');
            }
        }
    }
}
