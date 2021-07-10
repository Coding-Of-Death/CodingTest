class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] arrSkill = skill.toCharArray();
        
        
        for (String skill_tree : skill_trees) {
            boolean[] check = new boolean[arrSkill.length];
            int pre_skill = 0;
            boolean flag = true;
            
            for (int i = 0; i < arrSkill.length; i++) {
                int skill_indx = skill_tree.indexOf(arrSkill[i]);
                if (skill_indx == -1) {         // 스킬 아예 배우지 않은 경우
                    check[i] = false;
                } else if(skill_indx >= pre_skill){
                    if (i > 0 && !check[i-1]) { // 선행스킬 배우지 않은 경우
                        flag = false;
                        break;
                    } else {                    // 선행스킬 배운 경우
                        pre_skill = skill_indx;
                        check[i] = true;
                    }
                } else {                        // 선행스킬 배우지 않고 배운 경우
                    flag = false;
                    break;
                }
            }
            
            if (flag)   answer++;
        }
        
        return answer;
    }
}
