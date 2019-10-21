package test;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 测试stringbuilder在reverse之后自身会不会变化
 **/
public class Test01 {
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder("abcdefg");
        s.reverse();
        System.out.println(s);
    }
}
