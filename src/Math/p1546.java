package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균
public class p1546 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score[] = new int[N];

        st = new StringTokenizer(br.readLine());
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            score[i] = number;
            if(max<number){
                max = number;
            }
        }

        double sum = 0;
        double average;
        for (int i = 0; i < N; i++) {
            sum += (score[i]/max) * 100;
        }
        average = sum/N;
        System.out.print(average);
    }
}
