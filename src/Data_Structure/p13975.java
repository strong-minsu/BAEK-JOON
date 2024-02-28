package Data_Structure;

import java.util.*;
import java.io.*;

//파일 합치기3
public class p13975 {
    //소설의 장을 각각 다른 파일에 저장함
    //모든 장을 쓰고 각 장이 쓰여진 파일을 합쳐서 최종적으로 한 개의 파일을 만든다
    //이 과정에서 두 개의 파일을 합쳐 임시파일 -> 임시파일 혹은 원래 파일 두 개씩 합쳐서 파일 을 합쳐
    //두 파일을 합칠 때 필요한 비용이 두 파일의 크기의 합.
    //최종적으로 한 개의 파일을 완성하는데 필요한 비용의 합계....

    static int T;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //기본 오름차순  (차순이 낮은 것 부터..) 내림차순 원할 경우 -> Collections.reverseOrder()함수 인자로 넣으면 됨
        PriorityQueue<Long> priorityQueue;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            priorityQueue = new PriorityQueue<>();
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                int n = Integer.parseInt(st.nextToken());
                priorityQueue.add((long)n);
            }

            long result = 0;
            while (priorityQueue.size() > 1){
                long n1 = priorityQueue.poll();
                long n2 = priorityQueue.poll();

                long addn1n2 = n1+n2;
                result += addn1n2;
                priorityQueue.add(addn1n2);
            }

            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }
}
