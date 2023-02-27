package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//제로
public class p10773 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num;
        for(int i=0; i<K; i++){
            num = Integer.parseInt(br.readLine());

            if(num==0){
                stack.pop();
            }
            else{
                stack.push(num);
            }
        }

        int sum=0;

        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.print(sum);
    }
}
