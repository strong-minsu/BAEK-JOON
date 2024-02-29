package Implementation;

import java.util.*;
import java.io.*;

//추월
public class p2002 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        LinkedHashMap<String, Integer> carList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String inCarNum = br.readLine();
            carList.put(inCarNum, i);
        }

        int overTakingCar = 0;

//      이름 - 순번으로 데이터를 저장하기 위해 해쉬 맵으로 저장합니다.
//      이때 해쉬 맵은 순서가 지정될 수 있도록 LinkedHashMap를 사용..?
//      저장된 해쉬 맵의 제일 앞 요소를 기준으로 뒷 요소들과 비교해줍니다.
//      앞 요소가 뒷 요소보다 숫자가 높다면 추월한 것으로 판단하고 pass Count를 해줍니다.
//      앞 요소의 비교가 끝나면 앞 요소를 제거 해준다.
//      마지막 요소까지 1-4번 과정을 반복

        for (int i = 0; i < n; i++) {
            String outCarNum = br.readLine();

            Iterator<String> car = carList.keySet().iterator();
            while (car.hasNext()){
                if(carList.get(outCarNum) > carList.get(car.next())){
                    overTakingCar++;
                    break;
                }
            }

            carList.remove(outCarNum);
        }

        bw.write(overTakingCar+"");
        bw.flush();
        bw.close();
    }
}
