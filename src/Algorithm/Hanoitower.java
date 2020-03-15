package Algorithm;

/**
* @author Guangyao Gou
* @date 2020/05/14 18:05:33
* @ClassName Hanoitowr.java
* @Description 类描述
*/

public class Hanoitower {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        hanoitower(5,'A' ,'B' ,'C' );
    }

    public static void hanoitower(int num,char a ,char b,char c) {
        if(num == 1) {
            System.out.println("第1个盘从"+a+"->"+c);
            
        }else {
            hanoitower(num - 1, a, c, b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            hanoitower(num-1, b, a, c);
        }
    }
}
