class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++){
            String[] sk = skill_trees[i].split("");
            
            int idx = 0;
            boolean flag = true;
            
            for(int j = 0; j < sk.length; j++){
                if(idx < skill.indexOf(sk[j])){
                    flag = false;
                    break;
                }
                
                else if(idx == skill.indexOf(sk[j]))
                    idx++;
            }
            
            if(flag)
                answer++;
            
        }
        return answer;
    }
}
