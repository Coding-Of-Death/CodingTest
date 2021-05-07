import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < genres.length; i++){
            hm.put(genres[i], hm.getOrDefault(genres[i],0)+plays[i]);
        }
        ArrayList<Integer> answers = new ArrayList<Integer>();
        ArrayList<String> al = new ArrayList<String>(hm.keySet());
        Collections.sort(al,(o1,o2)->(hm.get(o2).compareTo(hm.get(o1))));
        
        for(int i = 0 ; i < al.size();i++){
            String TempGenres = al.get(i);
            int firstIdx = 0;
            int secondIdx = 0;
            int max = 0;
            for(int j = 0 ; j<genres.length; j++){
                if(TempGenres.equals(genres[j])){
                    if(plays[j]>max){
                        max = plays[j];
                        firstIdx = j;
                    }
                }
            }
            max = -1;
            for(int j = 0 ; j < genres.length; j++){
                if(TempGenres.equals(genres[j])){
                    if(j!=firstIdx && plays[j]>max){
                        max = plays[j];
                        secondIdx = j;
                    }
                }
            }
            answers.add(firstIdx);
            if(max != -1){
                answers.add(secondIdx);
            }
        }
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
