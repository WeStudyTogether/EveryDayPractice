package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Guangyao Gou
 * @date 2020/28/02 11:28:38
 * @ClassName PolandNotation.java
 * @Description 类描述
 */
//计算逆波兰表达式（后缀表达式）`
public class PolandNotation {
    public static void main(String[] args) {
        String string = "3 4 + 5 * 6 -";
        List<String> list = getListString(string);
        System.out.println(list);
        
        int res = cal(list);
        System.out.println(res);
    }

    public static List<String> getListString(String string) {
        String[] split = string.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int cal(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for(String item : ls) {
            if(item.matches("\\d+")) {
                stack.push(item);
            }else {
               int num2 = Integer.parseInt(stack.pop());
               int num1 = Integer.parseInt(stack.pop());
               int res = 0;
               if(item.equals("+")) {
                   res = num1+num2;
               }else if(item.equals("-")) {
                   res = num1-num2;
               }else if(item.equals("*")) {
                   res = num1*num2;
               }else if(item.equals("-")) {
                   res = num1+num2;
               }else if(item.equals("/")) {
                   res = num1/num2;
               }else {
                   throw new RuntimeException("运算符有误");
               }
               stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
