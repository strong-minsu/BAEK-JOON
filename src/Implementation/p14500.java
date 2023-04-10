package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//테트로미노
public class p14500 {
    static int N, M;
    static int paper[][];
    //[19][3][2] 회전과 대칭을 포함하면 모두 19개의 고정 테트로미노 생성
    static int tetromino[][][] = {
            {{1, 0}, {2, 0}, {3, 0}},
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {0, 1}, {1, 1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {1, -1}, {1, -2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{1, 0}, {0, 1}, {0, 2}},
            {{0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{0, -1}, {1, -1}, {1, -2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
            {{1, -1}, {1, 0}, {1, 1}},
    };

    static int maxSum(){
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                int x = j;
                int y = i;
                for (int k = 0; k < 19; k++) {
                    int[][] arr = tetromino[k];
                    if(check(x, y, arr)){
                        sum += paper[y][x];
                        for (int l = 0; l < 3; l++) {
                            sum+= paper[y+arr[l][1]][x+arr[l][0]];
                        }
                        if(max < sum){
                            max = sum;
                        }
                    }
                    sum = 0;
                }
            }
        }
        return max;
    }
    static boolean check(int x, int y, int k[][]){
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            if(k[i][0] + x < 0 || k[i][0] + x >= M || k[i][1] + y < 0 || k[i][1] + y >= N ){
                result = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(maxSum());
    }
}
