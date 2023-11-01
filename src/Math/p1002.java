package Math;

import java.io.*;
import java.util.*;

//터렛

public class p1002 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double distance = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));

            if(distance == 0){
                if(r1 == r2){
                    sb.append(-1);
                }
                else{
                    sb.append(0);
                }
            }
            else {
                if(distance < r1 + r2){

                    //거리와 작은 반지름 더한 값 == 큰 반지름 (원안에 원...)
                    if(Math.min(r1, r2) + distance == Math.max(r1, r2)){
                        sb.append(1);
                    }

                    //거리와 작은 반지름 더한 값 < 큰 반지름
                    else if(Math.min(r1, r2) + distance < Math.max(r1, r2)){
                        sb.append(0);
                    }

                    //거리와 작은 반지름 더한 값 > 큰 반지름
                    else{
                        sb.append(2);
                    }

                }

                //한 점에서 만남
                else if (distance == r1 + r2) {
                    sb.append(1);
                }
                //원이 안겹침
                else if (distance > r1 + r2) {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
