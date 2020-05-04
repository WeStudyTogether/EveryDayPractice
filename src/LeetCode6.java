
/**
 * @author Guangyao Gou
 * @date 2020/29/11 17:29:37
 * @ClassName LeetCode6.java
 * @Description 类描述
 */

//public class LeetCode6 {
//    public String convert(String s, int numRows) {
//        char[] chars = s.toCharArray();
//        int n = s.length() / (numRows * 2 - 2);
//        int m = s.length() % (numRows * 2 - 2);
//        int numCols = 0;
//        if(m == 0) {
//           numCols = n*(numRows - 1); 
//        }else if (0 < m && m <= numRows) {
//            numCols = n*(numRows - 1) + 1;
//        } else if (numRows < m && m <= numRows * 2 - 2) {
//            numCols = n*(numRows - 1) + m-numRows;
//
//        char[][] z = new char[numCols][numRows];
//        for(int i = 0; i<numCols; i++) {
//            if(i%(numRows-1)==0) {
//                for(int j = 0; j<numRows; j++) {
//                    z[i][j]=chars[(numRows * 2 - 2)*i+j];
//                }
//            }else{
//                    z[i][numRows-1-(i%(numRows-1))]=chars[i/(numRows-1)]
//                }
//        }
//    }
//}
