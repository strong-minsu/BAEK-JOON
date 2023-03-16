package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최소, 최대
public class p10818 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number > max){
                max = number;
            }
            if(number < min){
                min = number;
            }
        }
        System.out.print(min + " " + max);
    }
}
