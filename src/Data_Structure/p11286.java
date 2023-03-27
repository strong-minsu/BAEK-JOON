package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToDoubleFunction;

//절댓값 힙
public class p11286 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        //우선순위큐에 배열을 넣는 경우 반드시!! comparator을 써야한다.
        PriorityQueue<int[]> abs_queue = new PriorityQueue<>(new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(abs_queue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    int array[] = abs_queue.remove();
                    if(array[1]<0){
                        sb.append(-1*array[0]).append("\n");
                    }
                    else{
                        sb.append(array[0]).append("\n");
                    }
                }
            }

            else {
                if(x>0){
                    int array[] = new int[2];
                    array[0] = x;
                    array[1] = 1;
                    abs_queue.add(array);
                }
                else{
                    int array[] = new int[2];
                    array[0] = Math.abs(x);
                    array[1] = -1;
                    abs_queue.add(array);
                }
            }
        }
        System.out.print(sb);
    }
}
