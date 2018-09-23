import java.util.*;

/**
 * Created by yong on 2018. 9. 23..
 */
public class Programmers42579 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42579번 베스트 앨범
         * solution : 1. 정렬된 song Object list를 만든다. (Comparable 사용 - plays순으로)
         *            2. 총 Play수를 담고 있는 Map을 만든다.
         *            3. 총 play수가 가장 큰 Map의 key(genre)를 찾아 songList에서 찾는다
         *            4. 2개씩만 answer List에 추가한다.
         */

        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};

        List<Song> songList = new ArrayList<>(); // 정렬된 song Object list
        Map<String, Integer> rank = new HashMap<>(); // 총 Play수를 담고 있는 Map

        int length = genres.length;
        for(int i = 0; i < length; i++){
            // 총 Play수를 담는 로직
            int genrePlays = rank.getOrDefault(genres[i], 0);
            int totalPlays = genrePlays + plays[i];
            rank.put(genres[i], totalPlays);
            // song Object list를 만드는 로직
            Song song = new Song(i, plays[i], genres[i]); // key : index, value : plays
            songList.add(song);
        }

        Collections.sort(songList);

        int[] arr = new int[length];

        int answerLength = 0;
        int rankSize = rank.size();
        for(int i = 0; i < rankSize; i++) {
            String maxGenre = "";
            int maxValue = 0;
            for (String tmp : rank.keySet()) {
                //가장 Play 수가 가장 큰 genre를 찾는다.
                if (maxValue < rank.get(tmp)) {
                    maxGenre = tmp;
                    maxValue = rank.get(tmp);
                }
            }
            // 해당 genre는 map에서 제거
            rank.remove(maxGenre);

            int index = 0;
            for(int j = 0; j < length; j++){
                if(maxGenre.equals(songList.get(j).genre)){
                    arr[answerLength] = songList.get(j).index;
                    answerLength++;
                    index++;
                    //앨범에 각 장르별 두 개씩만 넣기
                    if(index >= 2){
                        break;
                    }
                }
            }
        }
        //완성된 배열을 복사.
        int[] answer = Arrays.copyOf(arr, answerLength);
    }
}

class Song implements Comparable<Song>{
    int index;
    int plays;
    String genre;

    Song(int index, int plays, String genre){
        this.index = index;
        this.plays = plays;
        this.genre = genre;
    }

    @Override
    public int compareTo(Song o) {
        return o.plays - this.plays;
    }
}


