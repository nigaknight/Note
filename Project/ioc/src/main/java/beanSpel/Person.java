package beanSpel;

/**
 * @author micro soft
 * @version : Person, v 0.1 2019/7/1 18:33 micro soft Exp$
 */
public class Person {
    private String name;

    // 引用address bean的city属性
    private String city;

    private Car car;

    // 根据car的price确定info：car的price>=300000：金领
    // 否则为：白领
    private String info;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", car=" + car +
                ", info='" + info + '\'' +
                '}';
    }
}
