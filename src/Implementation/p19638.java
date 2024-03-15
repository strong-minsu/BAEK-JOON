package Implementation;

import java.io.*;
import java.util.*;

//센티와 마법의 뿅망치
public class p19638 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < n; i++) {
            int giantsHeight = Integer.parseInt(br.readLine());
            if(giantsHeight >= h){
                priorityQueue.add(giantsHeight);
            }

        }

        int count = 0;
        while (!priorityQueue.isEmpty() && count < t){
            int giantHight = priorityQueue.poll();
            giantHight /= 2;

            if(giantHight == 0){
              priorityQueue.add(1);
              break;
            }

            count++;
            if(giantHight >= h){
                priorityQueue.add(giantHight);
            }
        }

        if(priorityQueue.isEmpty()){
            bw.write("YES \n");
            bw.write(count+"");
        }
        else{
            bw.write("NO \n");
            bw.write(priorityQueue.poll()+"");
        }

        bw.flush();
        bw.close();
    }
}
