package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 수열
public class p1874 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> array = new Stack<>();

        for (int i=0; i<n ;i++) {
            int number = Integer.parseInt(br.readLine());
            stack.push(number);
        }
        //LIFO 성질이 있어서 다시 정렬
        for (int i = 1; i < n+1; i++) {
            array.push(stack.pop());
        }

        for (int i = 1; i < n+1; i++) {
            if(i <= array.peek()){ //같거나 작으면 stack에 넣기
                stack.push(i);
                sb.append("+\n");
            }
            while (stack.size()>0 && stack.peek().equals(array.peek())){
                //stack의 사이즈가 0보다 크고 빼야하는 수가 나오면 stack에서 제거
                sb.append("-\n");
                stack.pop();
                array.pop();
            }
        }
        if(stack.isEmpty()){
            System.out.print(sb);
        }
        else{
            System.out.print("NO");
        }
    }
}
