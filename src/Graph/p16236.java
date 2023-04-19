package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//아기 상어
public class p16236 {
    static int [][] space;
    static int N, X, Y, fish, answer=0, size=2, eaten=0;

    //상어 위치
    static int[]dx = {-1,0,0,1};
    static int[]dy = {0,-1,1,0};
    static void search(){
        int currentx, currenty, nx, ny, depth;

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        //현재 위치 queue에 추가, 방문 여부 체크
        queue.add(new int[]{X, Y, 1});
        visited[X][Y] = true;
        //다음 먹을 물고기 위치와 가는 데 걸린 시간 초기화
        int nextX=-1;
        int nextY=-1;
        int nextDepth=Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            int temp[] = queue.remove();
            currentx = temp[0];
            currenty = temp[1];
            depth = temp[2];

            if(nextDepth<depth){break;}

            for(int i=0; i<4; i++){
                nx = currentx+dx[i];
                ny = currenty+dy[i];
                //space공간 안에 있고, 상어의 크기보다 크거나 작은 곳으로 이동
                if(inMap(nx, ny) && !visited[nx][ny] && space[nx][ny] <= size){
                    //물고기가 상어보다 작은 경우 (먹음 처리)
                    if(space[nx][ny]>0 && size>space[nx][ny]){
                        //다음 먹을 물고기가 정해지지 않았을 때
                        if(nextX==-1) {
                            nextX=nx;
                            nextY=ny;
                            nextDepth=depth;
                        }
                        //다음 먹을 물고기가 정해졌을 때
                        else {
                            //다음 먹을 물고기보다 현재 물고기가 더 위쪽에 위치 -> 다음 먹을 물고기 변경
                            if(nextX>nx) {
                                nextX=nx;
                                nextY=ny;
                            }
                            //다음 먹을 물고기보다 현재 물고기가 더 왼쪽에 위치 -> 다음 먹을 물고기 변경
                            else if(nextX==nx) {
                                if(nextY>ny) {
                                    nextX=nx;
                                    nextY=ny;
                                }
                            }
                        }
                    }

                    //방문 여부 체크
                    visited[nx][ny]=true;
                    //큐 add
                    queue.add(new int[]{nx,ny,depth+1});
                }
            }
        }
        //먹을 수 있는 물고기가 있을 때
        if(nextX!=-1) {
            space[nextX][nextY]=0;
            answer+=nextDepth;
            fish--;
            X=nextX;
            Y=nextY;
            eaten++;
            //현재 먹은 물고기 수와 현재 상어의 크기가 같을 때 크기 up
            if(eaten==size) {
                eaten=0;
                size++;
            }
        }
    }
    static boolean inMap(int nx, int ny){
        return nx>=0&&nx<N&&ny>=0&&ny<N;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        fish = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                space[i][j] = num;
                if(num == 9){
                    X = i;
                    Y = j;
                    space[i][j] = 0;
                }
                else if(space[i][j] > 0){
                    fish++;
                }
            }
        }
        int temp;
        while (fish != 0){
            temp = fish;
            search();
            if(temp == fish){
                break;
            }
        }
        System.out.print(answer);
    }
}
