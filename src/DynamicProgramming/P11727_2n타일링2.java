package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727_2n타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] D = new Long[1001];
        D[1] = 1l;
        D[2] = 3l;
        for(int i=3; i<=n; i++){
            D[i] = (D[i-1] + 2*D[i-2]) % 10007;
        }
        System.out.println(D[n]);
    }
}
