package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int my[];
    static int check[];
    static int checkSecret; // check이랑 my랑 비교했을 때 개수 맞으면 성공시켜주기 위함 -> 4되면 통과
    // 슬라이딩 윈도우 -> 범위를 지정한 다음 범위를 유지한 채로 이동 (부분 문자열)
    // P, S의 길이가 커서 O(n)의 시간 복잡도로 해결해야 함 -> 슬라이딩 윈도우
    // 범위를 지정해야 함 -> 이 문제에서는 부분 문자열의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = br.readLine().toCharArray();
        check = new int[4];
        my = new int[4];
        checkSecret = 0;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
            // 0일 때는 무조건 만족하므로 하나 올려주기
            // equal일때로 구해줘서 Add에서 1개부터 셀 수 있음
            if(check[i]==0){
                checkSecret++;
            }
        }
        for(int i=0; i<P; i++) {
            Add(A[i]);
        }
        if(checkSecret == 4) count++;
        // 슬라이딩 윈도우 -> 다 보지 않고 빠져나가는 것과 들어가는 것만 봄
        // 슬라이딩 이미 한 상태부터 지정 -> 배열에서 P부터 지정
        for(int i=P; i<S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) count++;
        }

        System.out.println(count);
        br.close();
    }
    public static void Add(char c){
        switch(c) {
            case 'A':
                my[0]++;
                if(my[0]==check[0]) checkSecret++;
                break;
            case 'C':
                my[1]++;
                if(my[1]==check[1]) checkSecret++;
                break;
            case 'G':
                my[2]++;
                if(my[2]==check[2]) checkSecret++;
                break;
            case 'T':
                my[3]++;
                if(my[3]==check[3]) checkSecret++;
                break;
        }
    }
    public static void Remove(char c){
        switch(c) {
            case 'A':
                // 원래 my가 check배열과 같았다면 제거되니까 checkSecret 한 개 빼주기
                if(my[0]==check[0]) checkSecret--;
                my[0]--;
                break;
            case 'C':
                if(my[1]==check[1]) checkSecret--;
                my[1]--;
                break;
            case 'G':
                if(my[2]==check[2]) checkSecret--;
                my[2]--;
                break;
            case 'T':
                if(my[3]==check[3]) checkSecret--;
                my[3]--;
                break;
        }
    }
}
