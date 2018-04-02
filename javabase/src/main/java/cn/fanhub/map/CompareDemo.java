package cn.fanhub.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: CompareDemo.java, v 0.1 2018年03月26日 下午8:04 chengfan Exp $
 */
public class CompareDemo {
    public static void main(String[] args) {
        List<Strings> list = new ArrayList<>();
        list.add(new Strings("a", 1));
        list.add(new Strings("b", 5));
        list.add(new Strings("c", 3));
        list.add(new Strings("d", 2));
        Collections.sort(list);

        for (Strings strings : list) {
            System.out.println(strings.toString());
        }
    }
}