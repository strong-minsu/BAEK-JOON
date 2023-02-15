package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블랙잭
public class p2798 {
    static int N;
    static int M;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int number[] = new int[N+1];
        for (int i=1; i<=N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        int max= Integer.MIN_VALUE;
        int sum=0;
        //모두 한 번씩 돌아가면서 체크
        for(int i=1; i<=N; i++){
            for (int j=i+1; j<=N; j++){
                for(int k=j+1; k<=N; k++){
                    sum = number[i]+ number[j]+ number[k];
                    if(sum<=M && max<sum){
                        //M을 넘지않고 최대인 수 구하기
                        max = sum;
                    }
                }
            }
        }

        System.out.print(max);

    }
}
