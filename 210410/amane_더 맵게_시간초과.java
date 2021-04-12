public int solution(int[] scoville, int K) {
        int answer = 0;
        int now = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < scoville.length; j++){
            list.add(scoville[j]);
        }
        
        while(list.size() > 1 && now <= K){
            now = list.get(0) + list.get(1) * 2;
            answer++;
            list.remove(0);
            list.remove(0);
            list.add(now);
            
            Collections.sort(list);
        }
        
        if(now <= K)
        	return -1;
        else
        	return answer;
    }