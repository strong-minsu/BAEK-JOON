package Graph;

import java.io.*;
import java.util.*;

//거짓말
// 분리 집합  (Union-find)알고리즘
public class p1043 {
    static int N, M, knowTrueCount;
    static int root[];
    static boolean knowTrueList[];
    static HashSet<Integer> partyList[];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        root = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            root[i] = i;
        }

        //진실을 아는 사람 수
        knowTrueCount = Integer.parseInt(st.nextToken());

        //진실을 아는 사람 0명인 경우 파티 모두 과장 가능!
        if(knowTrueCount == 0){
            System.out.print(M);
            return;
        }
        
        //진실을 알 경우 true처리
        knowTrueList = new boolean[N+1];
        for (int i = 0; i < knowTrueCount; i++) {
            knowTrueList[Integer.parseInt(st.nextToken())] = true;
        }

        //파티 정보
        partyList = new HashSet[M];
        for (int i = 0; i < M; i++) {
            partyList[i] = new HashSet<>();
        }

        //파티 시작
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int partyPeople =  Integer.parseInt(st.nextToken());

            int firstPeople = Integer.parseInt(st.nextToken());

            partyList[i].add(firstPeople);
            for (int j = 1; j < partyPeople; j++) {
                int nextPeople = Integer.parseInt(st.nextToken());

                if(find(firstPeople) != find(nextPeople)){
                    union(firstPeople, nextPeople);
                }

                partyList[i].add(nextPeople);
            }
        }

        //진실 연관 관계 정리
        boolean visited[] = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            if(knowTrueList[i] && !visited[i]){
                //i번째 사람의 root를 알아낸다
                int currentRoot = find(i);
                for (int j = 1; j < N+1; j++) {
                    //i와 같은 부모를 가진 사람들을 모두 true로
                    if(find(j) == currentRoot){
                        knowTrueList[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        //정리된 연관 관계(knowTrueList[])를 가지고
        // 파티원이 진실을 모두 모를 경우 result++;
        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int person: partyList[i]) {
                if(knowTrueList[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);
    }

    static int find(int peopelNumber){
        //현재가 루트인 경우
        if(root[peopelNumber] == peopelNumber){
            return peopelNumber;
        }

        //재귀 함수로 제일 위에 있는 부모 탐색 후 리턴
        root[peopelNumber] = find(root[peopelNumber]);
        return root[peopelNumber];
    }

    static void union(int x, int y){
        //next의 루트를 찾아서 first 루트로 변경
        int root_y = find(y);
        root[root_y] = x;
    }
}
