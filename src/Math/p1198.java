package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1198 {
    static double result;
    static int N;
    static int[][] vertex;
    static boolean [] removed;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        vertex = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            vertex[i][0]=Integer.parseInt(st.nextToken());
            vertex[i][1]=Integer.parseInt(st.nextToken());
        }

        result = 0;

        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    double t = (double) Math.abs((vertex[i][0] * vertex[j][1] + vertex[j][0] * vertex[k][1] + vertex[k][0] * vertex[i][1]
                            - vertex[j][0] * vertex[i][1] - vertex[k][0] * vertex[j][1] - vertex[i][0] * vertex[k][1]));
                    result = Math.max(result, t/2);
                }
            }
        }
        System.out.print(result);
    }

}
