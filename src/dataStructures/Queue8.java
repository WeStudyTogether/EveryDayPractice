package dataStructures;


/**
* @author Guangyao Gou
* @date 2020/08/03 11:08:35
* @ClassName Queue8.java
* @Description 类描述
*/

public class Queue8 {
    int max = 8;
    int[] array = new int[8];   
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }
    
    private void check(int n) {
        if(n == max) {
            print();
            count++;
            return;
        }
        
        for(int i = 0 ; i< max; i++) {
            array[n] = i;
            if(judge(n)) {
                check(n + 1);
            }
        }
    }

    private void print() {
        for(int i = 0; i<8 ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private boolean judge(int n) {
        for(int i = 0; i < n; i++) {
            if(array[i] == array[n] ||  Math.abs(i-n) == Math.abs(array[i]-array[n])) {
                return false;
            }
        }
        return true;
    }
}
