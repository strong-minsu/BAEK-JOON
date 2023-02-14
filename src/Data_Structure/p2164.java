package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//카드2
public class p2164 {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        boolean t = false;
        while(queue.size() > 1){
            int number = queue.remove();
            if(t) {
                queue.add(number);
                t = false;
            }
            else{
                t = true;
            }
        }
        System.out.print(queue.peek());
    }
}
