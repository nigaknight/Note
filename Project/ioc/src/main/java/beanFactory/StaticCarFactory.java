package beanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author micro soft
 * @date 2019/7/5 23:28
 */
public class StaticCarFactory {
    private static Map<String,Car> cars=new HashMap<String, Car>();

    static {
        cars.put("Audi",new Car("Audi",300000));
        cars.put("Ford",new Car("Ford",400000));
    }

    public static Car getCar(String brand){
        return cars.get(brand);
    }
}
