package Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * @author Guangyao Gou
 * @date 2020/38/25 13:38:17
 * @ClassName HorseChessBoard.java
 * @Description 类描述
 */

public class HorseChessBoard {

    private static int x;
    private static int y;
    private static boolean[] visited;
    private static boolean finished;

    public static void main(String[] args) {
        x=8;
        y=8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[x][y];
        visited = new boolean[x*y];
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        for(int[] rows : chessboard) {
            for(int step : rows) {
                System.out.println(step);
            }
        }
    }
    
    public static void traversalChessboard(int[][] chessboard,int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row*x +column] = true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if(!visited[p.y*x+p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step+1);
            }
        }
        if(step<x*y&&!finished) {
            chessboard[row][column] = 0;
            visited[row*x +column] = false;
        }else {
            finished=true;
        }
    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y + 1) < y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y + 2) < y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < y) {
            ps.add(new Point(p1));
        }
        return ps;
    }
    
    public static  void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1< count2) {
                    return -1;
                }if(count1==count2) {
                    return 0;
                }else {
                    return 1;
                }
                
            }
        });
    }
}
