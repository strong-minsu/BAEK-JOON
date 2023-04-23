package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주식
public class p11501 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            int max= Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            for (int j = N-1; j >= 0; j--) {
                if(arr[j]>max){
                    max = arr[j];
                }
                else {
                    answer += (max - arr[j]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
