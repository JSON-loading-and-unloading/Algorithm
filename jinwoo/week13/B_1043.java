package jinwoo.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * union-find 를 이용하여 루트 노드가 진실을 아는 사람으로 이루어진 그룹을 피한다.
 * 1. M개의 모든 파티들을 조회하여 진실을 아는 사람이 파티원에 속해있다면
 * 그 파티원을 루트 노드로 설정하여 집합을 만든다.
 * 2. 모든 집합이 형성된 후, 다시 M개의 모든 파티를 조회하여 루트 노드가
 * 진실이 아닌 파티들을 카운트해주면 된다.
 */

public class B_1043 {
    static int N, M;
    static int[] parents; // 루트 노드 저장
    static List<Integer> tList; // 진실을 아는 사람들
    public static void main(String[] args) throws IOException {
        
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 사람 수
    M = Integer.parseInt(st.nextToken()); // 파티 수
    
    parents = new int[N+1]; // 자기 자신을 루트로 하는 배열을 생성한다.
    for(int i=1; i<N+1; i++) {
        parents[i] = i;
    }
    
    st = new StringTokenizer(br.readLine());
	int tn= Integer.parseInt(st.nextToken());
    tList = new ArrayList<>();
	if(tn==0) { // 진실을 아는 사람이 없을 때
		System.out.println(M); // 파티 수 그대로 반환
		return;
	} else{
		for(int i=0; i<tn; i++) { // 진실을 아는 사람들 저장한다.
			tList.add(Integer.parseInt(st.nextToken()));
		}
	}

    List<Integer>[] partyList = new ArrayList[M]; // 파티 정보
	for(int i=0; i<M; i++) { // 초기화
		partyList[i] = new ArrayList<>();
	}

    for(int i=0; i<M; i++) {
        st = new StringTokenizer(br.readLine());
        int pn = Integer.parseInt(st.nextToken());
        
        int x = Integer.parseInt(st.nextToken());
        partyList[i].add(x);
        for(int j=1; j<pn; j++) {
            int y = Integer.parseInt(st.nextToken());
            union(x,y); // x와 y 집합을 합친다.(=진실을 아는 사람을 루트 노드로 설정한다.)
            partyList[i].add(y);
        }
    }

    int cnt=0;
	for(int i=0; i<M; i++) {
		boolean flag = true;
		for(int num : partyList[i]) {
			if(tList.contains(find(parents[num]))) { // 진실을 아는 사람이 루트노드일때
                flag= false;
                break;
    		}
        }
		if(flag) { // 진실을 아는 사람이 없을 때
			cnt++;
		}
	}
	System.out.println(cnt);
}
    static int find(int x) {
        if(parents[x] ==x ) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(tList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry =tmp;
        }
        
        parents[ry] = rx;
    }

}
