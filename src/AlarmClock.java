import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/40/11 16:40:08
 * @ClassName AlarmClock.java
 * @Description 类描述
 */

public class AlarmClock {
    private static int n;
    private static int[] Hour;//存放闹钟时间
    private static int[] Min;
    private static int x;
    private static int a;
    private static int b;

    private static int[] Hour2;//存放闹钟时间与最晚出发时间间隔
    private static int[] Min2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Hour = new int[n];
        Min = new int[n];
        Hour2 = new int[n];
        Min2 = new int[n];

        for (int i = 0; i < n; i++) {
            Hour[i] = scan.nextInt();
            Min[i] = scan.nextInt();
        }
        x = scan.nextInt();
        a = scan.nextInt();
        b = scan.nextInt();
        scan.close();
        if ((x - b) > 60) {//将上课时间a,b改成最晚出发时间
            b = 120 + b - x;
            a = a - 2;
        } else if (60 <= (x - b) && (x - b) < 0) {
            a = a - 1;
            b = 60 + b - x;
        } else {
            b = b - x;
        }
//        System.out.println(a);
//        System.out.println(b);

        for (int i = 0; i < n; i++) {
            if (Min[i] >= b) {
                Min2[i] = b - Min[i];
                Hour2[i] = a - Hour[i];
            } else {
                Min2[i] = 60 + Min[i] - b;
                Hour2[i] = Hour[i] - a - 1;
            }
//            System.out.println(Hour2[i]);
//            System.out.println(Min2[i]);
        }
        int m = Min[0];
        int h = Hour[0];
        int m2 = Min2[0];
        int h2 = Hour2[0];

        for (int i = 1; i < n; i++) {//比较间隔大小
            if (Hour2[i] >= 0 && Hour2[i] < h2) {
                h2 = Hour2[i];
                m2 = Min2[i];
                h = Hour[i];
                m = Min[i];
            }
            if (Hour2[i] == h2) {
                if (Min2[i] < m2) {
                    m2 = Min2[i];
                    h = Hour[i];
                    m = Min[i];
                }
            }
        }

        System.out.println(h + " " + m);
    }
}
