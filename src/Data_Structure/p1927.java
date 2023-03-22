package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//최소 힙
public class p1927 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //우선순위 큐로 구현
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            int instruction = Integer.parseInt(br.readLine());
            if(instruction == 0){
                if(priorityQueue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else {
                    int num = priorityQueue.remove();
                    sb.append(num).append("\n");
                }
            }
            else {
                priorityQueue.add(instruction);
            }
        }
        System.out.print(sb);
    }
}

