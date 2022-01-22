class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val n = id_list.size
        val answer: IntArray = IntArray(n) { 0 }
        
        val map = Array(n) {IntArray(n) { 0 }}
        for (report in report) {
            report.split(" ").apply {
                val sIdx = id_list.indexOf(this[0])
                val uIdx = id_list.indexOf(this[1])
                
                map[uIdx][sIdx]++
                if (map[uIdx][sIdx] == 1) {
                    map[uIdx][uIdx]++
                }
            }
        }
        
        for (i in map.indices) {
            if (map[i][i] >= k) {
                for (j in map[i].indices) {
                    if (i != j && map[i][j] > 0) {
                        answer[j]++
                    }
                }
            }
        }
        
        return answer
    }
}
