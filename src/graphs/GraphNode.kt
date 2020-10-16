package graphs


class GraphNode(val value: Int, val adj: Array<GraphNode>)

class GraphWeighted(val vertices: Int, val allEdges: MutableList<Edge> = mutableListOf()) {

    class Edge(val src: Int, val dest: Int, val weight: Int)

    fun addEdge(src: Int, dest: Int, weight: Int = 0) {
        allEdges.add(Edge(src, dest, weight))
    }
}

fun main(args: Array<String>) {
    val graph = GraphWeighted(6)
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 3)
    graph.addEdge(1, 2, 1)
    graph.addEdge(1, 3, 2)
    graph.addEdge(2, 3, 4)
    graph.addEdge(3, 4, 2)
    graph.addEdge(4, 5, 6)
//            print(UnionFind().isCycle(graph))
    Kruksal().createKruksalMST(graph)

}




