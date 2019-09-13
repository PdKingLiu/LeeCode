package data_structures_and_algorithms;

/**
 * @author liupeidong
 * Created on 2019/9/13 15:14
 */
public class Prim {

    /*图——最小生成树——prim算法*/

    static class Graph {
        char[] vertex;
        int[][] weight;
    }

    public static void main(String[] args) {
        int M = 0x7fffffff;
        Graph graph = new Graph();
        graph.vertex = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        graph.weight = new int[][]{{M, 19, M, M, 14, M, 18},
                {19, M, 5, 7, 12, M, M},
                {M, 5, M, 3, M, M, M},
                {M, 7, 3, M, 8, 21, M},
                {14, 12, M, 8, M, M, 16},
                {M, M, M, 21, M, M, 27},
                {18, M, M, M, 16, 27, M}};
        prim(graph);
    }

    public static void prim(Graph G) {
        int[] adjVertex = new int[G.vertex.length];
        int[] lowVast = new int[G.vertex.length];
        lowVast[0] = 0;
        adjVertex[0] = 0;
        for (int i = 1; i < G.vertex.length; i++) {
            adjVertex[i] = 0;
            lowVast[i] = G.weight[0][i];
        }
        for (int i = 1; i < G.vertex.length; i++) {
            int min = 0x7fffffff;
            int j = 1;
            int index = 0;
            while (j < G.vertex.length) {
                if (lowVast[j] != 0 && lowVast[j] < min) {
                    index = j;
                    min = lowVast[j];
                }
                j++;
            }
            lowVast[index] = 0;
            System.out.print("->" + G.vertex[index] + ":" + min);
            for (j = 1; j < G.vertex.length; j++) {
                if (lowVast[i] != 0 && G.weight[index][j] < lowVast[j]) {
                    adjVertex[j] = index;
                    lowVast[j] = G.weight[index][j];
                }
            }
        }
    }

}