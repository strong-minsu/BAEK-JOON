package Graph;

import java.io.*;
import java.util.*;

//키 순서
//노드가 모든 노드와 연결되어 있는지 체크만 하면 됨
public class p2458 {
    static int N, M;
    static boolean [][]check;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //한 번의 간선을 거쳐서 갈 수 있는 경우 연결됨 표시
            check[a][b] = true;
        }

        for(int k = 1; k < N+1; k++) {
            for(int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++) {
                    //k노드를 거쳐서 갈 수 있으면 i와 j는 연결된 상태임
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        int result = 0;
        for (int i = 1; i < N+1; i++) {
            count = 0;
            for (int j = 1; j < N+1; j++) {
                if(i != j){
                    //정방향 역방향 둘 중 하나라도 알면...
                    if(check[i][j] || check[j][i]){
                        count++;
                    }
                }
            }
            if(count == N-1){
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
