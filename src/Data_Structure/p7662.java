package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//이중 우선순위 큐
public class p7662 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //트리맵으로 구현
        TreeMap<Integer, Integer> Double_Priority_Queue = new TreeMap<>();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                char instruction = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(instruction == 'I'){
                    if(Double_Priority_Queue.containsKey(num)){
                        Double_Priority_Queue.put(num, Double_Priority_Queue.get(num)+1);
                    }
                    else{
                        Double_Priority_Queue.put(num, 1);
                    }
                }
                else{
                    if(Double_Priority_Queue.isEmpty()){
                        //큐가 비어있을 때 삭제 명령일시 무시
                        continue;
                    }
                    else{
                        if(num > 0){
                            // 큰 값 삭제
                            int max = Double_Priority_Queue.lastKey();
                            if(Double_Priority_Queue.get(max) == 1){
                                Double_Priority_Queue.remove(max);
                            }
                            else{
                                Double_Priority_Queue.put(max, Double_Priority_Queue.get(max)-1);
                            }
                        }
                        else {
                            // 작은 값 삭제
                            int min = Double_Priority_Queue.firstKey();
                            if(Double_Priority_Queue.get(min) == 1){
                                Double_Priority_Queue.remove(min);
                            }
                            else{
                                Double_Priority_Queue.put(min, Double_Priority_Queue.get(min)-1);
                            }
                        }
                    }
                }
            }

            if(Double_Priority_Queue.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(Double_Priority_Queue.lastKey()).append(" ").append(Double_Priority_Queue.firstKey()).append("\n");
            }

            Double_Priority_Queue.clear();
        }
        System.out.print(sb);
    }
}
