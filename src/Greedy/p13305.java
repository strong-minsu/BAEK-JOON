package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주유소
public class p13305 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long distance[] = new long[N-1];
        long city[] = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long min = city[0];

        for (int i = 0; i < distance.length; i++) {
            if(city[i] < min){
                min = city[i];
            }
            answer += min*distance[i];
        }
        System.out.print(answer);
    }
}
