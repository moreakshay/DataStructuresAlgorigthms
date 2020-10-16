package graphs


class Kruksal {

    private val minSpanningTree: MutableList<GraphWeighted.Edge> = mutableListOf()
    private val unionFind = UnionFind()

    fun createKruksalMST(graph: GraphWeighted){
        val parent: Array<Int> = Array(graph.vertices){it -> it - (it + 1)}
        graph.allEdges.sortBy { edge: GraphWeighted.Edge -> edge.weight }
        var index = 0
        var counter = 0
        while (index < graph.vertices - 1){
            val edge = graph.allEdges[counter++]
            val xSet = unionFind.find(parent, edge.src)
            val ySet = unionFind.find(parent, edge.dest)
            if(xSet == ySet){} // ignore creates a cycle
            else {
                minSpanningTree.add(edge)
                index++
                unionFind.union(parent, xSet, ySet)
            }
//            counter++
        }
        printMST()
    }

    private fun printMST(){
        minSpanningTree.forEach { println("Edge from ${it.src} to ${it.dest} of weight ${it.weight}") }
    }
}