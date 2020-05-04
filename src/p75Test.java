
/**
 * @author Guangyao Gou
 * @date 2020/17/18 11:17:53
 * @ClassName p75Test.java
 * @Description 类描述
 */

class Base {
    public Base() {
        System.out.println("Base");
    }
}

class Sub extends Base {
    public Sub() {
        super();
        System.out.println("Sub");
    }
}

public class p75Test {
public static void main(String[] args) {
    Base a = new Sub();
}
}
