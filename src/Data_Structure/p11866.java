package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//요세푸스 문제 0
public class p11866 {
    static Queue<Integer> queue;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        sb.append("<");
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        while (!queue.isEmpty()){
            int number=0;
            for(int i=0; i<K-1; i++){
                number = queue.remove();
                queue.add(number);
            }
            //K번째 수를 제거할 때 큐의 사이즈가 1인 경우 (숫자가 하나만 남음) : 바로 제거
           if(queue.size() == 1){
               sb.append(queue.remove());
           }
           //K번째 수를 제거함
           else{
               sb.append(queue.remove()).append(", ");
           }
        }
        sb.append(">");

        System.out.print(sb);
    }
}
