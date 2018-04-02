package cn.fanhub.map;

/**
 *
 * @author chengfan
 * @version $Id: Strings.java, v 0.1 2018年03月26日 下午8:00 chengfan Exp $
 */
public class Strings implements Comparable<Strings> {
    private String str;
    private int count;

    @Override
    public int compareTo(Strings strings) {
        return this.count - strings.count;
    }

    public Strings(String str, int count) {
        this.str = str;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("[str] = %s, [count] = %d", str, count);
    }
}