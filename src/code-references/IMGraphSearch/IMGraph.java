import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class IMGraph {

    /**
     * Lookup from the node id to the actual node.
     */
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {

        /**
         * Identifier.
         */
        private int id;

        /**
         * Adjacent nodes.
         */
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        Node node;

        if (nodeLookup.containsKey(id)) {
            node = nodeLookup.get(id);
        } else {
            node = new Node(id);
            nodeLookup.put(id, node);
        }

        return node;
    }

    private void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

    /**
     * Depth First Search.
     * Goes DEEP (to children) before going broad (to neighbors).
     *
     * @param source      id of the source node.
     * @param destination id of the destination node.
     * @return true if has path, otherwise false.
     */
    public boolean hasPathDFS(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        HashSet<Integer> visited = new HashSet<>(nodeLookup.size());

        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visited) {
        if (visited.contains(sourceNode.id)) {
            return false;
        }

        visited.add(sourceNode.id);
        if (sourceNode.id == destinationNode.id) {
            return true;
        }

        for (Node child : sourceNode.adjacent) {
            if (hasPathDFS(child, destinationNode, visited)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Breadth First Search.
     * Goes BROAD (to neighbors) before going deeper.
     *
     * @param source      id of the source node.
     * @param destination if of destination node.
     * @return true if has path, otherwise false.
     */
    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        HashSet<Integer> visited = new HashSet<>(nodeLookup.size());
        LinkedList<Node> nextToVisit = new LinkedList<>();

        nextToVisit.add(source);

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node.id == destination.id) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);
            nextToVisit.addAll(node.adjacent);
        }

        return false;
    }
}
