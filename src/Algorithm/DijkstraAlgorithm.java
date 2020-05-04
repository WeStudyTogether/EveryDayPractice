package Algorithm;

import java.util.Arrays;

/**
* @author Guangyao Gou
* @date 2020/56/20 13:56:28
* @ClassName DijkstraAlgorithm.java
* @Description 类描述
*/

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        final int N = 65535;
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {N,5,7,N,N,N,2},
                {5,N,N,9,N,N,3},
                {7,N,N,N,8,N,N},
                {N,9,N,N,N,4,N},
                {N,N,8,N,N,5,4},
                {N,N,N,4,5,N,6},
                {2,3,N,N,4,6,N},
        };
         Graph graph = new Graph(vertex, matrix);
         graph.showGraph();
         
         graph.djs(6);
         graph.showDijkstra();
    }

}

class Graph{
    private char[] vertex;
    private int[][] matrix;
    VisitedVertex vv;
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    
    public void showDijkstra() {
        vv.show();
    }
    
    public void showGraph() {
        for(int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
    
    public void djs(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);
        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }
    }
    
    
    
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = vv.getDis(index) + matrix[index][i];
            if(!vv.in(i)&&len<vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }
        }
    }
}

class VisitedVertex{
    public int[] already_arr;
    public int[] pre_visited;
    public int[] dis;
    
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;
        
    }
    
    public boolean in(int index) {
        return already_arr[index] == 1;
    }
    
    public void updateDis(int index, int len) {
        dis[index] = len;
    }
    
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    public int getDis(int index) {
        return dis[index];
    }
    
    public int updateArr() {
        int min = 65535,index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
            
        }
        already_arr[index] = 1;
        return index;
    }
    
    public void show() {

        for (int i = 0; i < already_arr.length; i++) {
            System.out.print(already_arr[i]);
        }
        
        for(int i : pre_visited) {
            System.out.print(i);
        }
        
        for(int i : dis) {
            System.out.print(i);
        }
        
        int count = 0;
        char[] vertex = {'A','B','C','D','E','F','G'};
        for(int i : dis) {
            if(i != 65535) {
                System.out.println(vertex[count++]);
            }
        }
    }
}