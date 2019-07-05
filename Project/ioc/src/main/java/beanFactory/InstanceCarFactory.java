package beanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author micro soft
 * @date 2019/7/5 23:34
 */
public class InstanceCarFactory {
    private Map<String,Car> cars=null;

    public InstanceCarFactory(){
        cars=new HashMap<String, Car>();
        cars.put("Audi",new Car("Audi",300000.00));
        cars.put("Ford",new Car("Ford", 400000.00));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
