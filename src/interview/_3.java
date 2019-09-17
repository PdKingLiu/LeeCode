package interview;

import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/17 20:09
 */
public class _3 {
    public static void main(String[] args) {
        int M = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        int n, m, k;
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int[][] weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weight[i][j] = M;
            }
        }

        for (int i = 0; i < m; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            weight[a1 - 1][a2 - 1] = 0;
            weight[a2 - 1][a1 - 1] = 0;
        }
        for (int i = 0; i < k; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int a3 = scanner.nextInt();
            weight[a1 - 1][a2 - 1] = a3;
            weight[a2 - 1][a1 - 1] = a3;
        }
        Graph graph = new Graph();
        graph.vertex = new char[n];
        graph.weight = weight;
        System.out.println(prim(graph));
    }

    public static int prim(Graph G) {
        int minValue = 0;
        int[] adjVertex = new int[G.vertex.length];
        int[] lowVast = new int[G.vertex.length];
        lowVast[0] = -1;
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
                if (lowVast[j] != -1 && lowVast[j] < min) {
                    index = j;
                    min = lowVast[j];
                }
                j++;
            }
            lowVast[index] = -1;
            if (min > 0) {
                minValue += min;
            }
            for (j = 1; j < G.vertex.length; j++) {
                if (lowVast[j] != -1 && G.weight[index][j] < lowVast[j]) {
                    adjVertex[j] = index;
                    lowVast[j] = G.weight[index][j];
                }
            }
        }
        return minValue;
    }

    private static class Graph {
        char[] vertex;
        int[][] weight;
    }

}
