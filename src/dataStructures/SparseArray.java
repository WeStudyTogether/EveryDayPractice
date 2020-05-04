package dataStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Guangyao Gou
 * @date 2020/39/28 13:39:41
 * @ClassName SparseArray.java
 * @Description 类描述
 */

public class SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("原始的二维数组~~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // ->稀疏数组
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        System.out.println("得到的稀疏数组~~~");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //保存
        File file = new java.io.File("resource/map.data");
        FileWriter out = new FileWriter(file);
        for(int i = 0;i<sparseArr.length;i++) {
            for(int j = 0; j<3; j++) {
                out.write(sparseArr[i][j]+"\t");
            }
            out.write("\n");
        }
        out.close();
        
        //读取
        BufferedReader in = new BufferedReader(new FileReader("resource/map.data"));
        String line;
        int row = 0;
        int[][] sparseArr2 = new int[sparseArr.length][3];
        while((line = in.readLine())!= null) {
            String[] temp = line.split("\t");
            for(int j =0; j<temp.length; j++) {
                sparseArr2[row][j] =Integer.parseInt(temp[j]);
            }
            row++;
        }
        in.close();
        // ->二维数组
        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        System.out.println("回复后的二维数组~~~");
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }
        for (int[] row2 : chessArr2) {
            for (int data : row2) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}