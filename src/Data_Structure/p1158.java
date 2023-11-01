package Data_Structure;

import java.util.*;
import java.io.*;

public class p1158 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            queue.add(i);
        }

        int count = 0;
        sb.append("<");
        while (!queue.isEmpty()){
            int number = queue.poll();
            count++;

            if(count == K){
                if(queue.isEmpty()){
                    sb.append(number);
                }
                else{
                    sb.append(number).append(", ");
                }
                count = 0;
            }
            else{
                queue.add(number);
            }
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
