package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//어린 왕자
public class p1004 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int x1, y1, x2, y2, cx, cy, r;
        int count;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            count = 0;

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                double distance1 = Math.sqrt(Math.pow((x1 - cx), 2) + Math.pow((y1 - cy), 2));
                double distance2 = Math.sqrt(Math.pow((x2 - cx), 2) + Math.pow((y2 - cy), 2));

                if(r>distance1 && distance2>r){
                    count++;
                } else if (r<distance1 && distance2<r) {
                    count++;
                }
                else{
                    continue;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
