package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DSLR
public class p9019 {
    static String BFS(int A, int B) {
        boolean []visited = new boolean[10000];
        String count[] = new String[10000];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(count,  "");

        queue.add(A);
        count[A] = "";
        visited[A] = true;
        while (!queue.isEmpty() && !visited[B]){
            int current = queue.poll();

            //D, S, L, R 계산된 4개 수 저장
            int[] DSLR = {(current*2) % 10000, current == 0 ? 9999 : current - 1,
                    (current%1000)*10 + current/1000, current/10 + (current%10)*1000};

            String[] dslr = {"D", "S", "L", "R"};
            for(int j=0; j<DSLR.length; j++) {
                int n = DSLR[j];
                //방문 체크 후, 큐에 넣어줌
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    count[n] = count[current] + dslr[j];
                }
            }
        }
    return count[B];
}
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int A, B;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            BFS(A, B);
            System.out.println(BFS(A, B));
        }
    }
}
