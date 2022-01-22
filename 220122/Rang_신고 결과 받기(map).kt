class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val n = id_list.size
        val answer: IntArray = IntArray(n) { 0 }
        
        val map = HashMap<String, MutableList<String>>()
        for (repo in report.distinct()) {
            repo.split(" ").apply {
                if (map[this[1]] == null) {
                    map[this[1]] = mutableListOf(this[0])
                } else {
                    map[this[1]]!!.add(this[0])
                }
            }
        }
        
        for (key in map.keys) {
            if (map[key]!!.size >= k) {
                map[key]!!.forEach {
                    val idx = id_list.indexOf(it)
                    answer[idx]++
                }
            }
        }
        
        return answer
    }
}
