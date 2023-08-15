package dataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합 {
    public static void main(String[] args) throws IOException {
        // 받는 값이 많을 때는 BufferedReader 사용
        // 굉장히 길게 받을 때는 int형으로 받기보다 StringTokenizer 사용
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 한 줄 자를 때 사용
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        long[]S = new long[N + 1]; // 0번째 인덱스를 무시
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<=N; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[end]-S[start-1]);
        }

    }
}
