package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//카드 정렬하기
public class p1715 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pqueue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (pqueue.size() > 1){
            int n1 = pqueue.poll();
            int n2 = pqueue.poll();

            int sum = n1+n2;
            answer+= sum;
            pqueue.add(sum);
        }
        System.out.print(answer);
    }
}
