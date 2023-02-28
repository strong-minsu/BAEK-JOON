package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//프린터 큐
public class p1966 {
    public static void main(String[] args)throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            //자료형이 정수 배열인 큐 생성
            LinkedList<int[]> queue = new LinkedList<>();
            for(int j=0; j<N; j++){
                //큐에 새로운 정수 배열 추가
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            //각 큐에 대해 검사
            while (!queue.isEmpty()){

                boolean b = true;
                //가장 앞의 요소 빼기
                int first[] = queue.poll();

                //다른 요소와 비교
                for(int k=0; k< queue.size(); k++){
                    //만약 우선순위가 더 큰 경우
                    if(first[1]< queue.get(k)[1]){
                        //큐에 가장 앞 요소 넣기
                        queue.add(first);

                        //첫 요소보다 큰 요소 전까지의 요소들 다시 큐에 넣기
                        for(int l=0; l<k; l++){
                            queue.add(queue.poll());
                        }
                        //우선순위가 가장 큰 요소가 아니었음
                        b = false;
                        break;
                    }
                }
                if(b == false){
                    //우선순위가 가장 큰 요소가 아니였으면 count를 증가하지 않고 지나감
                    //빠지는 요소가 없었으므로
                    continue;
                }

                //증가시킴
                count++;
                if(first[0] == M){
                    //만약 빠지는 요소 (즉 빠질 경우가 된 수 이면) M번째 요소인지 검사
                    break;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
