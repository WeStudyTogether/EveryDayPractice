
/**
 * @author Guangyao Gou
 * @date 2020/29/11 17:29:37
 * @ClassName LeetCode6.java
 * @Description 类描述
 */

//public class LeetCode6 {
//    public String convert(String s, int numRows) {
//        char[] chars = s.toCharArray();
//        int n = s.length() / (numRows * 3 - 2);
//        int m = s.length() % (numRows * 3 - 2);
//        int numCols = 0;
//        if (0 < m && m <= numRows) {
//            numCols = n + 1;
//        } else if (numRows < m && m <= numRows * 2 - 2) {
//            numCols = n + 1;
//        } else if (numRows * 2 - 2 < m && m < numRows * 3 - 2) {
//            numCols = n + 1;
//        }
//        char[][] z = new char[numCols][numRows];
//        for(int i = 0; i<numCols; i++) {
//            if(i%(numRows-1)==0) {
//                z[i][j]=chars[ij]
//            }
//        }
//    }
//}
