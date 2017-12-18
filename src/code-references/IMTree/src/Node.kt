class Node<T>(private val value: T) {
    var children: ArrayList<Node<T>> = ArrayList()
    var parent: Node<T>? = null

    fun add(child: Node<T>) {
        children.add(child)
        child.parent = this
    }

    fun search(value: String): Node<T>? {
        if (value == this.value) {
            return this
        }

        for (child in children) {
            val found = child.search(value)
            if (found != null) {
                return found
            }
        }

        return null
    }

    override fun toString(): String {
        var text = "$value"

        if (!children.isEmpty()) {
            text += " { " + children.joinToString { node -> node.toString() } + " } "
        }

        return text
    }
}
