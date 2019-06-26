package Case01;

/**
 * @author wjy
 * @date 2019-06-20-22:31
 */
public class LambdaExam01 {
    public static void main(String[] args){
        MyLambdaInterface aBlockOfCode=(s)-> System.out.println(s);
        aBlockOfCode.doSomething("Hello World");
    }



}
