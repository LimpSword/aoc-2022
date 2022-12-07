package day7

class Node(private var value: String) {

    internal var parent: Node? = null
    private var children: MutableList<Node> = mutableListOf()

    fun addChild(node: Node) {
        if (children.stream().anyMatch { it.value == node.value }) return
        children.add(node)
        node.parent = this
    }

    fun getChild(value: String): Node {
        return children.stream().filter { it.value == value }.findFirst().get()
    }

    fun getSize(): Int {
        var size = 0

        if (this.value.matches("""\d+.*""".toRegex())) {
            return this.value.split(" ")[0].toInt()
        }

        for (child in children) {
            size += child.getSize()
        }
        return size
    }

    fun listAllDirectories(): List<Node> {
        val list = ArrayList<Node>()

        if (this.value.matches("""\d+.*""".toRegex())) return list

        for (child in children) {
            if (!child.value.matches("""\d+.*""".toRegex())) {
                list.add(child)
                list.addAll(child.listAllDirectories())
            }
        }
        return list
    }

    fun hasChildren(): Boolean =
        children.size >= 1
}