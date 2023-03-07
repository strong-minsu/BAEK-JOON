package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//동전 0
public class p11047 {
    public static void main(String[] agrs)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            stack.push(Integer.parseInt(st.nextToken()));
        }

        int count=0;
        while (K>0){
            int money = stack.pop();
            while (K>=money){
                K = K-money;
                count++;
            }
        }
        System.out.print(count);
    }
}
