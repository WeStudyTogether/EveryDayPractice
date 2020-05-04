package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Guangyao Gou
 * @date 2020/30/13 20:30:53
 * @ClassName Graph.java
 * @Description 类描述
 */

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String Vertexs[] = { "A", "B", "C", "D", "E" };
        Graph graph = new Graph(n);
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
        graph.showGraph();
        graph.dfs();
        graph.bfs();
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i));
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        isVisited = new boolean[5];
        for (int j = 0; j < vertexList.size(); j++) {
            if (!isVisited[j]) {
                dfs(isVisited, j);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i));
        isVisited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()) {
            u = (Integer) queue.remove();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w));
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }

        }
    }

    private void bfs() {
        isVisited = new boolean[5];
        for (int j = 0; j < getNumOfVertex(); j++) {
            if (!isVisited[j]) {
                bfs(isVisited, j);
            }
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
