package jinwoo.week10;

class Music{
    String genre;
    int play;
    int idx;

    public Music(String genre, int play, int idx) {
        this.genre = genre;
        this.play = play;
        this.idx = idx;
        }
}

public class P_베스트앨범 {

    public static void main(String[] args) throws NumberFormatException, IOException {

    }

    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // key 값만으로 ArrayList를 생성한다.
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        
        // 1. 장르별 재생 수에 따라 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));
        
        // 2. 장르 내 노래 선정
        ArrayList<Music> result = new ArrayList<>();
        
        for(String g : genre){
            ArrayList<Music> list = new ArrayList<>();
            
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(g)){
                    list.add(new Music(g, plays[i], i));
                }
            }
            
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 정렬
            
            result.add(list.get(0));
            
            if(list.size()!=1){ 	// 더 수록할 곡이 있으면 수록
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }
}
}
