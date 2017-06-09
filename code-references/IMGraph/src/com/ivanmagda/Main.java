package com.ivanmagda;

import com.ivanmagda.core.AdjacencyListGraph;
import com.ivanmagda.core.Vertex;

public class Main {

    public static void main(String[] args) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        Vertex<Integer> v1 = graph.createVertex(1);
        Vertex<Integer> v2 = graph.createVertex(2);
        Vertex<Integer> v3 = graph.createVertex(3);
        Vertex<Integer> v4 = graph.createVertex(4);
        Vertex<Integer> v5 = graph.createVertex(5);

        // Set up a cycle like so:
        //               v5
        //                ^
        //                | (3.2)
        //                |
        // v1 ---(1)---> v2 ---(1)---> v3 ---(4.5)---> v4
        // ^                                            |
        // |                                            V
        // ---------<-----------<---------(2.8)----<----|

        graph.addDirectedEdge(v1, v2, 1.0);
        graph.addDirectedEdge(v2, v3, 1.0);
        graph.addDirectedEdge(v3, v4, 4.5);
        graph.addDirectedEdge(v4, v1, 2.8);
        graph.addDirectedEdge(v2, v5, 3.2);

        System.out.println("v1 -> v2: " + graph.weightFrom(v1, v2));
        System.out.println("v1 -> v3: " + graph.weightFrom(v1, v3));
        System.out.println("v3 -> v4: " + graph.weightFrom(v3, v4));
        System.out.println("v4 -> v1: " + graph.weightFrom(v4, v1));

        System.out.println(graph);
    }
}
