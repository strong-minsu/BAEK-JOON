package Graph;

import java.io.*;
import java.util.*;

// 숨바꼭질 3
public class p13549 {
    static boolean visited[] = new boolean[100001];
    static int time;
    //우선 순위 큐 없이 구현 시 순간 이동 검사 전 방문 처리 되어 버리는 위치 생김..(?)
    static void Hide_And_Seek(int N, int K){
        //시간 오름차순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int location = now[0];
            time = now[1];

            if(location == K){
                return;
            }

            visited[location] = true;
            //순간 이동
            if(location *2 <= 100000 && !visited[location*2]){
                queue.offer(new int[] {location*2, time});
            }
            //+1
            if(location < K && location+1 <= 100000 & !visited[location+1]){
                queue.offer(new int[]{location+1, time+1});
            }
            //-1
            if(location-1 >=0 && !visited[location-1]){
                queue.offer(new int[]{location-1, time+1});
            }


        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Hide_And_Seek(N, K);
        System.out.print(time);
    }
}
