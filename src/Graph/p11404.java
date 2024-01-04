package Graph;

import java.io.*;
import java.util.*;

//플로이드
//플로이드-워셜 알고리즘
//동적 계획법을 이용한 각 노드에서 다른 노드들 까지의 최단 경로 구하기
public class p11404 {
    static int N, M;
    static int[][] distance;

    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i == j){
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j] = 9999999;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = Math.min(c, distance[a][b]);
        }
        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
        for (int k = 1; k < N+1; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // 출력
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                // 연결이 안되어 있는 경우
                if (distance[i][j] == 9999999) {
                    sb.append(0).append(" ");
                } else {
                   sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
