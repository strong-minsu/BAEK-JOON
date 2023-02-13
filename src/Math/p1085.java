package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1085 {
    static int x, y, w, h;
    static public void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int x_result = Math.min(x, w-x);
        int y_result = Math.min(y, h-y);

        int result = Math.min(x_result, y_result);

        System.out.print(result);
    }
}
