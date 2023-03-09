package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1로 만들기
public class p1463 {
    static int dp(int n, int number[]){
        for (int i = 2; i < n+1; i++) {
            if(i%3==0 && i%2==0){
                int min = Math.min(number[i/3]+1,number[i/2]+1);
                number[i] = Math.min(min, number[i-1]+1);
            }

            else if(i%3==0){
                number[i] = Math.min(number[i/3]+1, number[i-1]+1);
            }
            else if(i%2==0){
                number[i] =  Math.min(number[i/2]+1, number[i-1]+1);
            }
            else{
                number[i] = number[i-1]+1;
            }
        }
        return number[n];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int number[] = new int[N+1];
        number[1] = 0;

        System.out.print(dp(N, number));
    }
}
