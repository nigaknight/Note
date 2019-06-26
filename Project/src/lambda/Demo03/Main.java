package lambda.Demo03;

import lambda.Demo01.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 用Iterable.forEach()取代foreach loop
 * @author wjy
 * @date 2019-06-26-20:46
 */
public class Main {
    public static void main(String[] args){
        List<Person> list = Arrays.asList(
                new Person("zhou", "jielun", 35),
                new Person("zhou", "yunfa", 55),
                new Person("deng", "ziqi", 27)
        );
        checkAndExecute(list,(p)->p.getFirstName().startsWith("z"),(p)-> System.out.println(p.getFirstName()+" "+p.getLastName()));
    }
    public static void checkAndExecute(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer){
        list.forEach((p)->{if(predicate.test(p))consumer.accept(p);});
    }
}
