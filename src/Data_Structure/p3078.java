package Data_Structure;

import java.io.*;
import java.util.*;

//좋은 친구
public class p3078 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long countFriends = 0;

        //인덱스 이름 길이를 학생 수
        int [] lenList = new int[21];

        //성적 순으로 들어온 학생의 이름 길이 큐
        Queue<Integer> students = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String studentName = br.readLine();

            //입력 받은 이름 길이
            int nameLen = studentName.length();

            //입력 받은 이름 길이를 가진 학생 수 늘림
            lenList[nameLen]++;

            //큐에 이름 길이 저장
            students.add(nameLen);

            //만약 큐 사이즈가 k+1보다 크다 (성적 차이를 넘게 된다)
            if(students.size() > k+1){
                // 앞에서 한 명 제거 (이름 길이에 학생 이름도 줄여야함)
                lenList[students.poll()]--;
            }

            //입력 받은 길이를 가진 학생 수 -1(본인 제외: 한 쌍으로 만드니까..?)를 더한다.
            countFriends += ((long)lenList[nameLen] - 1);
        }

//        for (int i = 0; i <= n-k; i++) {
//            for (int j = 1; j <= k; j++) {
//                if(j+i < n){
//                    if(studentList[i].length() == studentList[j+i].length()){
//                        countFriends++;
//                    }
//                }
//
//            }
//        }

        bw.write(countFriends+"");
        bw.flush();
        bw.close();
    }
}
