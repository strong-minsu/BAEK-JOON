package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//유기농 배추
public class p1012 {
    static int cabbage[][];
    static int N, M;
    static int countWorm (){
        int count=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cabbage[i][j] == 1){
                    cabbage[i][j] = 0;
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int y, int x){ //스택 이용 탐색
        //배추가 이어져 있는 부분은 count할 필요가 없음
        Stack<Integer> X = new Stack<>();
        Stack<Integer> Y = new Stack<>();
        X.push(x);
        Y.push(y);

        while (!X.isEmpty()){
            int x_current = X.pop();
            int y_current = Y.pop();

            int x_array[] = {x_current-1, x_current, x_current, x_current+1};
            int y_array[] = {y_current, y_current-1, y_current+1, y_current};

            for (int i = 0; i < 4; i++) {
                if((x_array[i]>=0 && x_array[i]<M) && (y_array[i]>=0 && y_array[i]<N)){
                    if(cabbage[y_array[i]][x_array[i]] == 1){
                        X.push(x_array[i]);
                        Y.push(y_array[i]);
                        cabbage[y_array[i]][x_array[i]] = 0;
                    }
                }
            }
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cabbage = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1;
            }
            sb.append(countWorm()).append("\n");
        }

        System.out.print(sb);
    }
}
