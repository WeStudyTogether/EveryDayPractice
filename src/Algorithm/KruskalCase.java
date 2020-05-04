package Algorithm;

import java.util.Arrays;


/**
 * @author Guangyao Gou
 * @date 2020/20/19 12:20:15
 * @ClassName KruskalCase.java
 * @Description 类描述
 */

public class KruskalCase {

    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = { { 0, 12, INF, INF, INF, 16, 14 }, { 12, 0, 10, INF, INF, 7, INF },
                { INF, 10, 0, 3, 5, 6, INF }, { INF, INF, 3, 0, 4, INF, INF }, { INF, INF, 5, 4, 0, 2, 8 },
                { 16, 7, 6, INF, 2, 0, 9 }, { 14, INF, INF, INF, 8, 9, 0 } };

        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;
//        this.vertexs = vertexs   会影响传过来的数据
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

    }
    
    public void kruskal() {
        int index = 0;
        int ends[] = new int[edgeNum];
        EData[] rets = new EData[edgeNum];
        
        EData[] edges = getEdges();
        sortedges(edges);
        
        for(int i = 0; i<edgeNum;i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            
            int m = getend(ends, p1);
            int n = getend(ends, p2);
            if(m!=n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println(Arrays.toString(rets));
    }
    
    

    public void print() {
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sortedges(EData[] edges) {
        EData temp;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j + 1].weight < edges[j].weight) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getend(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];

        }
        return i;
    }
}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }
}