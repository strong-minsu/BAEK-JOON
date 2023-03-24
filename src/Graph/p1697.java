package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질
public class p1697 {
    static int countSeconds[] = new int[100001];
    static void Hide_And_Seek(int N, int K){
        if(N == K){
            //언니와 동생 위치가 같은 경우. 0초
            System.out.print(0);
            return;
        }

        //BFS 너비우선 탐색이용
        Queue<Integer> queue = new LinkedList<>();
        countSeconds[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            int next [] = {temp*2, temp+1, temp-1};
            for (int i = 0; i < next.length; i++) {
                int num = next[i];
                if(num == K){
                    System.out.print(countSeconds[temp]);
                    return;
                }
                if(num>=0 && num<countSeconds.length && countSeconds[num]==0){
                    queue.add(num);
                    countSeconds[num] = countSeconds[temp] + 1;
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Hide_And_Seek(N, K);
    }
}
