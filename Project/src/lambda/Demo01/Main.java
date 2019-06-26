package lambda.Demo01;

import java.util.Arrays;
import java.util.List;

/**
 * @author wjy
 * @date 2019-06-24-21:13
 */

// 将人名字中姓的字母前面为w的打印出来
public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("zhou", "jielun", 35),
                new Person("zhou", "yunfa", 55),
                new Person("deng", "ziqi", 27)
        );
        // 功能接口的实现使用lambda表达式
        fun(list,(p)->{return p.getFirstName().startsWith("z");},
                (p)-> System.out.println(p.getFirstName()+" "+p.getLastName()));
    }

    public static void fun(List<Person> personlist, Test test, Executor executor) {
        for(Person p:personlist){
            if(test.test(p)){
                executor.executor(p);
            }
        }
    }
}
