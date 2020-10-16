package graphs

import java.util.*

class Search(size: Int) {

    private val visited = BooleanArray(size)

    fun breadthFirstSearch(node: GraphNode){
        val queue = LinkedList<GraphNode>()

        visited[node.value] = true
        queue.add(node)

        while(queue.isNotEmpty()){
            val n = queue.pop()
            // operate on node 'n' here
            for(n in node.adj){
                if(!visited[n.value]){
                    visited[n.value] = true
                    queue.add(n)
                }
            }
        }
    }

    fun depthFirstSearch(node: GraphNode){
        visited[node.value] = true
        // operate on node here
        for(n in node.adj){
            if(!visited[n.value]){
                depthFirstSearch(n)
            }
        }
    }
}
