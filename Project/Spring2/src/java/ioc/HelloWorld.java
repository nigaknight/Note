package ioc;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class HelloWorld {
    private String name;
    public HelloWorld(String name){
        this.name=name;
    }
    public HelloWorld(){

    }
    public void setName(String name){
        this.name=name;
    }
    public void hello(){
        System.out.println("hello "+name);
    }
}
