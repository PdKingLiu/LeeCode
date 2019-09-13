package data_structures_and_algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liupeidong
 * Created on 2019/9/13 16:04
 */
public class Kruskal {

    /*图——最小生成树——克鲁斯卡尔*/

    static int M = 0x7fffffff;

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.vertex = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        graph.edges = 11;
        graph.weight = new int[][]{{M, 19, M, M, 14, M, 18},
                {19, M, 5, 7, 12, M, M},
                {M, 5, M, 3, M, M, M},
                {M, 7, 3, M, 8, 21, M},
                {14, 12, M, 8, M, M, 16},
                {M, M, M, 21, M, M, 27},
                {18, M, M, M, 16, 27, M}};
        new Kruskal().kruskal(graph);
    }

    private static class Graph {
        char[] vertex;
        int[][] weight;
        int edges;
    }

    static class Edge {
        //每条边
        int begin;
        int end;
        int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

    public void kruskal(Graph G) {
        Edge[] edge = getEdge(G);
        int[] parent = new int[G.vertex.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = 0;
        }
        int n, m;
        for (int i = 0; i < edge.length; i++) {
            n = find(parent, edge[i].begin);
            m = find(parent, edge[i].end);
            if (n != m) {
                parent[n] = m;
                System.out.println(String.format("(%d,%d,%d)", edge[i].begin, edge[i].end, edge[i].weight));
            }
        }
    }

    private int find(int[] parent, int begin) {
        while (parent[begin] > 0) {
            begin = parent[begin];
        }
        return begin;
    }

    private Edge[] getEdge(Graph g) {
        Edge[] edges = new Edge[g.edges];
        int count = 0;
        for (int i = 0; i < g.weight.length; i++) {
            for (int j = i + 1; j < g.weight[0].length; j++) {
                if (g.weight[i][j] < M) {
                    edges[count++] = new Edge(i, j, g.weight[i][j]);
                }
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(value -> value.weight));
        return edges;
    }

}
