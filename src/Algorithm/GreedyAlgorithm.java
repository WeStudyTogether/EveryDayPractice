package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.print.DocFlavor.STRING;

/**
 * @author Guangyao Gou
 * @date 2020/48/17 17:48:37
 * @ClassName GreedyAlgorithm.java
 * @Description 类描述
 */

public class GreedyAlgorithm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> a = new HashSet<>();
        a.add("北京");
        a.add("上海");
        a.add("天津");
        a.add("广州");
        a.add("深圳");
        a.add("成都");
        a.add("杭州");
        a.add("大连");

        ArrayList<String> selects = new ArrayList<String>();
        String maxKey = null;

        while (a.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                HashSet<String> areas = broadcasts.get(key);
                areas.retainAll(a);
                
                if (areas.size() > 0 && (maxKey == null || areas.size() > broadcasts.get(maxKey).size())) {
                            maxKey = key;
                }
//                HashSet<String> maxareas = broadcasts.get(maxKey);
//                maxareas.retainAll(a);
            }
            if(maxKey != null) {
                selects.add(maxKey);
                a.removeAll(broadcasts.get(maxKey));
            }
        }
 
        System.out.println(selects);
    }
}