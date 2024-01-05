package Greedy;

import java.util.*;
import java.io.*;

//강의실 배정
public class p11000 {
    static int N;
    static class Lecture{
        int start, end;
        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        //시작 시간 기준으로 강의 오름차순 정렬 (시작 시간이 같다면 종료 시간 기준)
        Arrays.sort(lectures,(o1, o2) -> o1==o2 ? o1.end - o2.end : o1.start - o2.start);

        //종료 시간만 오름차순 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //첫 강의의 종료시간 저장(무조건 1개의 강의실은 필요!)
        priorityQueue.offer(lectures[0].end);
        for (int i = 1; i < N; i++) {
            if(priorityQueue.peek() <= lectures[i].start){
                // 현재 강의의 종료 시간이 다음 강의의 시작 시간보다 작거나 같은 경우
                // 같은 강의실에서 강의할 수 있음
                priorityQueue.poll();
            }
            //다음 강의의 종료 시간을 넣어줌
            priorityQueue.offer(lectures[i].end);
        }

        System.out.print(priorityQueue.size());
    }
}
