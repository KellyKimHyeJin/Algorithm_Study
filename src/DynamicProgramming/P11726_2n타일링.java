package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726_2n타일링 {
    // 점화식 먼저 만들기 D[N]: 길이 N으로 만들 수 있는 타일의 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] D = new long[1001];
        D[1] = 1l;
        D[2] = 2l;
        for(int i=3; i<=n; i++){
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }
        System.out.println(D[n]);
    }
}
