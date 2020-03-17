package Algorithm;

/**
* @author Guangyao Gou
* @date 2020/04/15 11:04:44
* @ClassName KnapsackProblem.java
* @Description 类描述
*/

public class KnapsackProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] w = {1,4,3};
        int[] val = {1500,3000,2000};
        int m = 4;
        int n = val.length;
        
        int[][] v = new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];
        
        for(int i = 0; i<v.length;i++) {
            v[i][0] = 0;
        }
        for(int i = 0; i<v[0].length;i++) {
            v[0][i] = 0;
        }
        
        for(int i = 1; i<v.length;i++) {
            for(int j = 1; j<v[0].length;j++) {
                if(w[i - 1] > j) {
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
                      if(v[i-1][j]< val[i-1]+v[i-1][j-w[i-1]])  {
                          v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                          path[i][j] = 1; 
                      }else {
                        v[i][j]= v[i-1][j];
                    }
                }
            }
        }
        
        int i = 1;//第一个物品开始
        int j = 4;//总容量
        while(i<path.length && j>0){
            if(path[i][j] == 1) {
                System.out.println(i);
                j -= w[i-1];
            }
            i++;
        }
    }

}
