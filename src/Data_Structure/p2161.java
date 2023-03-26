package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//카드1
public class p2161 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            queue.add(i);
        }

        boolean check = true;
        while (!queue.isEmpty()){
            int num = queue.remove();
            if (check){
                sb.append(num).append(" ");
                check = false;
            }
            else{
                queue.add(num);
                check = true;
            }
        }
        System.out.print(sb);
    }
}
