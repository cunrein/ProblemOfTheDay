package adventOfCode

class CharGraph {
    var grid = arrayOf<Array<Int>>()
    var charMap = mutableMapOf<Char, Int>()

    init {
        var  k = 0
        for (i in 'A'..'Z') {
            var array = arrayOf<Int>()
            charMap.put(i, k)
            for (j in 'A'..'Z') {
                array += 0
            }
            grid += array
            k++
        }
    }


    fun addEdge(sourceVertex: Char, destinationVertex: Char) {
        // Add edge to source vertex / node.
        grid[charMap[sourceVertex]!!][charMap[destinationVertex]!!] = 1
        //grid[charMap[destinationVertex]!!][charMap[sourceVertex]!!] = 1
    }

    override fun toString(): String = StringBuffer().apply {
        for (i in 'A'..'Z') {
            val lst = mutableListOf<String>()
            for (j in 'A'..'Z') {
                if(grid[charMap[i]!!][charMap[j]!!] == 1)
                    lst.add("$j")
            }
            if (lst.isNotEmpty()) {
                append("$i -> ")
                append(lst.joinToString(",", "[", "]\n"))
            }
        }
    }.toString()
}

fun createGraph(data: List<String>): CharGraph {
    return CharGraph().apply {
        data.forEach {
            val raw = it.split(" ")
            val source = raw[1].toCharArray()[0]
            val dest = raw[7].toCharArray()[0]
            addEdge(source, dest)
        }
    }
}

fun findPath(graph: CharGraph): String {
    val lsts = mutableSetOf<String>()
    var nodes = setOf<String>()
    for (i in 'A'..'Z') {
        val lstd = mutableSetOf<String>()
        for (j in 'A'..'Z') {
            if(graph.grid[graph.charMap[i]!!][graph.charMap[j]!!] == 1)
                lstd.add("$j")
        }
        if (lstd.isNotEmpty()) {
            lsts.add("$i")
            nodes = nodes.union(lsts.union(lstd))
        }
    }

    println(nodes)
    // find start nodes
    val lst = graph.charMap.filter {
        graph.grid[it.value].sum() == 0
    }

    return processNodes(lst.keys.sorted(), graph)
}

fun processNodes(nodes: List<Char>, graph: CharGraph): String {
    return StringBuilder().apply {
        nodes.forEach{
            append(it)
            val lst = graph.charMap.filter { p ->
                graph.grid[graph.charMap[it]!!][p.value] == 1
            }
            processNodes(lst.keys.sorted(), graph)
        }
    }.toString()

}

val day7Data = listOf("Step C must be finished before step A can begin,",
        "Step C must be finished before step F can begin.",
        "Step A must be finished before step B can begin.",
        "Step A must be finished before step D can begin.",
        "Step B must be finished before step E can begin.",
        "Step D must be finished before step E can begin.",
        "Step F must be finished before step E can begin.")