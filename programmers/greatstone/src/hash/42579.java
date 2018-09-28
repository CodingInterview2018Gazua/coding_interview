import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        for (int i = 0; i < genres.length; ++i) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> indexes = Stream.iterate(0, i -> i + 1)
            .limit(genres.length)
            .sorted((i1, i2) -> plays[i2] - plays[i1])
            .collect(Collectors.toList());
        
        Map<String, Integer> countMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i : indexes) {
            int count = countMap.getOrDefault(genres[i], 0);
            if (count < 2) {
                answer.add(i);
            }
            countMap.put(genres[i], count + 1);
        }
        return answer.stream()
            .sorted((i1, i2) -> genreCount.get(genres[i2]) - genreCount.get(genres[i1]))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}