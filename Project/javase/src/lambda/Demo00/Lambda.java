package lambda.Demo00;

/**
 * @author wjy
 * @date 2019-06-20-22:47
 */
public class Lambda {
    public static void main(String[] args){
        MyInterface myInterface=(s)-> System.out.println(s);
        myInterface.doSomething("Hello World");
    }

}
