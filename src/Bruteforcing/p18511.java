package Bruteforcing;

import java.util.*;
import java.io.*;

//큰 수 구성하기
public class p18511 {
    static int N, K;
    static int[] array;
    static int result;

    static void checkNumber(int n, int ten){
        if(n > N) return;
        //새로 들어온 수가 큰 경우 갱신
        result = Math.max(result, n);

        for (int i = 0; i < K; i++) {
            //모든 수 검사하ㅏ면서.. 자리수 증가 시키면서.. 원소 중복도 ㄱㄴ
            checkNumber(n+array[i]*ten, ten*10);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        checkNumber(0, 1);
        System.out.print(result);
    }
}
