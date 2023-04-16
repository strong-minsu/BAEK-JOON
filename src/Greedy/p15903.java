package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//카드 합체 놀이
public class p15903 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pqueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Integer.parseInt(st.nextToken());
            pqueue.add(num);
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            long x = pqueue.poll();
            long y = pqueue.poll();

            sum = x + y;
            pqueue.add(sum);
            pqueue.add(sum);
        }

        long answer = 0;
        while (!pqueue.isEmpty()){
            answer += pqueue.poll();
        }
        System.out.print(answer);
    }
}
