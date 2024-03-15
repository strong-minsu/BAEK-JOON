package Data_Structure;

import java.io.*;
import java.util.*;

public class p6198 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        long result = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h){
                stack.pop();
            }

            result += stack.size();
            stack.push(h);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
