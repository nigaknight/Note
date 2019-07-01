package beanCollection;

import beanAttribute.Car;

import java.util.Map;

/**
 * @author micro soft
 * @version newPerson: NewPerson, v 0.1 2019/7/1 16:57 micro soft Exp$
 */
public class NewPerson {
    private String name;
    private int age;
    private Map<String, Car> cars;

    @Override
    public String toString() {
        return "NewPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }
}
