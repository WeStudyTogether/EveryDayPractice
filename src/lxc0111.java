
/**
 * @author Guangyao Gou
 * @date 2020/02/11 18:02:08
 * @ClassName lxc0111.java
 * @Description 类描述
 */

public class lxc0111 {
    private static String deleteSame(String s) {
        String a;
        char[] chars = s.toCharArray();;
        int i = 0;

        for(;i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                chars = delete(i, chars);
                if(chars == null)
                    break;
                else
                i = - 1;
            }           
        }
        if (chars == null)
            a= "YES";
        else {
            a= new String(chars);
        }
        return a;
    }

    private static char[] delete(int index, char[] array) {
        if(array.length - 2>0) {
        char[] arrNew = new char[array.length - 2];
        for (int i = 0; i < index; i++) {
            arrNew[i] = array[i];
        }
        for (int i = index; i < array.length - 2; i++) {
            arrNew[i] = array[i + 2];
        }
        return arrNew;
        }
        else {
            return null;
        }
    }
public static void main(String[] args) {
    String s ="aabaa";
    String a = deleteSame(s);
    System.out.println(a);
}
}
