import java.util.*;

class Solution {
      public int[] solution(String[] genres, int[] plays) {
	     int[] answer = {};  
		 ArrayList<Integer> sortedAnswer = new ArrayList<Integer>();
		 HashMap<String, Integer> replay = new HashMap<>(); // 각 장르의 총 재생 횟수 
	 	 for(int i = 0; i< genres.length; i++) {
	 		replay.put(genres[i], replay.getOrDefault(genres[i],0)+plays[i]); 
	 	 }
	 	 List<String> replaySet = new ArrayList<>(replay.keySet()); //replay의 keySet을 리스트로 변환
	 	 Collections.sort(replaySet, (o1, o2) -> (replay.get(o2).compareTo(replay.get(o1)))); //총 재생 횟수 기준으로 내림차순
	 	 for(String key : replaySet) {
	 		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 		 for(int i = 0; i<genres.length; i++) {
	 			if(key.equals(genres[i])) {
	 				map.put(i, plays[i]);
	 			}
	 		 }
	 		List<Integer> keyLists = new ArrayList<>(map.keySet());
	 		keyLists.sort((s1, s2)->map.get(s2).compareTo(map.get(s1)));
	 		int j = 0;
	 		for (Integer i : keyLists) {
	 			if(j>1) {
	 				break;
	 			}
	 			sortedAnswer.add(i);
	 		    j++;
	 		}
	 	 }
	 	 answer = new int[sortedAnswer.size()];
	 	 for( int i =0;i<sortedAnswer.size();i++) {
	 		answer[i] = sortedAnswer.get(i);
	 	 }

        return answer;
      }
}