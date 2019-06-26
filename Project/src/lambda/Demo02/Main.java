package lambda.Demo02;

import lambda.Demo01.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 直接用Java 8函数式接口包里的Predicate<T>和Consumer<T>就可以
 * 不需要两个接口了，Predicate接口包含验证方法，Consumer接口包含执行方法
 * @author wjy
 * @date 2019-06-26-20:32
 */
public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("zhou", "jielun", 35),
                new Person("zhou", "yunfa", 55),
                new Person("deng", "ziqi", 27)
        );
        checkAndExecute(list, (p) ->
            p.getFirstName().startsWith("z"),
        (p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));
    }

    public static void checkAndExecute(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : list) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
