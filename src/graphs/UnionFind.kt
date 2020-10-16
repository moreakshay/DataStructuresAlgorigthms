package graphs

class UnionFind {

    fun find(parent: Array<Int>, i: Int): Int {
        if(parent[i] == -1) return i
        return find(parent, parent[i])
    }

    fun union(parent: Array<Int>, x: Int, y: Int){
        val xSet = find(parent, x)
        val ySet = find(parent, y)
        parent[xSet] = ySet
    }

    fun isCycle(graph: GraphWeighted): Boolean {
        val parent: Array<Int> = Array(graph.vertices) {it - (it + 1)}
        for(edge in graph.allEdges){
            val x = find(parent, edge.src)
            val y = find(parent, edge.dest)
            if(x != y) union(parent, x, y)
            else return true
        }
        return false
    }
}